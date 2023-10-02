# Trabajo parcial

En el presente proyecto se busca realizar un traductor del lenguage DOT al formato JSON para listas de adyacencia utilizando [Antlr](https://www.antlr.org/about.html).

## Formatos
### Formato de entrada
Se utiliza el lenguaje DOT según las especificaciones que graphviz indica.
[Documentación del lenguaje DOT](https://graphviz.org/doc/info/lang.html)

### Formato de destino
Se transformará a una lista de adyacencia con el siguiente formato:
```
{
    "nodoInicio": [["nodofin", peso], ...],
    ...
}
```
De ser listas sin peso, se considerará 0 como peso por default.

## Analizadores gramáticos

### Analizador léxico
[Ver código](https://raw.githubusercontent.com/thecurz/DotToJsonCompiler/main/expr-antlr4/src/main/antlr4/com/compiler/ExprLexer.g4)

### Analizador sintáctico
Basado en las especificaciones indicadas en la documentación del lenguaje DOT.
[Ver código](https://raw.githubusercontent.com/thecurz/DotToJsonCompiler/main/expr-antlr4/src/main/antlr4/com/compiler/ExprParser.g4)


## Traducción

Para la traducción hacemos uso de Java y Antlr.

## Tabla de símbolos
[Ver código](https://raw.githubusercontent.com/thecurz/DotToJsonCompiler/main/expr-antlr4/src/main/java/com/compiler/ExprParserVisitorImpl.java)

## Traducción del ASL
[Ver código](https://raw.githubusercontent.com/thecurz/DotToJsonCompiler/main/expr-antlr4/src/main/java/com/compiler/ToJSONListener.java)


## Resultado

Con el input

```
digraph G {

  subgraph cluster_0 {
    style=filled;
    color=lightgrey;
    node [style=filled,color=white];
    a0 -> a1 -> a2 -> a3;
    label = "process #1";
  }

  subgraph cluster_1 {
    node [style=filled];
    b0 -> b1 -> b2 -> b3;
    label = "process #2";
    color=blue
  }
  start -> a0;
  start -> b0;
  a1 -> b3;
  b2 -> a3;
  a3 -> a0;
  a3 -> end;
  b3 -> end;

  start [shape=Mdiamond];
  end [shape=Msquare];
}
```


Muestra como resultado
```
{"b2":[["a3", 0]],"a1":[["b3", 0]],"b3":[["end", 0]],"a3":[["a0", 0],["end", 0]],"start":[["a0", 0],["b0", 0]],"b0":[["b1", 0]],"a0":[["a1", 0]]}
```
