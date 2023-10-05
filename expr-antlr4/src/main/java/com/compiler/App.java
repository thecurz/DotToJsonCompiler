package com.compiler;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import picocli.CommandLine;
import picocli.CommandLine.Option;

@CommandLine.Command(name = "Expr", mixinStandardHelpOptions = true, version = "0.0.1", description = "Antlr4 Analyzer")
public class App implements Callable<Integer> {
    @Option(names = { "-i", "--input" }, description = "Input file path")
    private String inputFilePath = "./input.dot";

    @Option(names = { "-o", "--output" }, description = "Output file path")
    private String outputFilePath = "output.json";

    @Override
    public Integer call() throws Exception {
        CharStream input = CharStreams.fromFileName(inputFilePath);

        ExprLexer lexer = new ExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);

        ParseTree tree = parser.graph();
        EdgeListener listener = new EdgeListener();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, tree);

        Map<String, List<Object[]>> serializableData = listener.getTupleMap();
        String json = EdgeDataJsonSerializer.convertTupleMapToJson(serializableData);

        ExprParserVisitorImpl visitor = new ExprParserVisitorImpl();
        String visitedTree = visitor.visit(tree);
        String map = visitor.mapToString();
        try {
            Path path = Paths.get("tabla_simbolos.txt");
            Files.write(path, Collections.singleton(map));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // System.out.println(visitedTree);
        // TODO: implement
        // ExprParserVisitorImpl visitor = ExprParserVisitorImpl();
        // String SymbolTable = TableToTxt(visitor.getMemory());
        // TableToTxt.save("filename");

        try (FileWriter fileWriter = new FileWriter(outputFilePath)) {
            fileWriter.write(json);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            return 1;
        }
        return 0;

    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.out.println(exitCode);
    }
}
