lexer grammar ExprLexer;

GRAPH       : [Ss][Tt][Rr][Ii][Cc][Tt]?;
GRAPH_TYPE  : [Gg][Rr][Aa][Pp][Hh] | [Dd][Ii][Gg][Rr][Aa][Pp][Hh];
NODE        : 'node';
EDGE        : 'edge';
SUBGRAPH    : 'subgraph';
COMPASS_PT  : 'n' | 'ne' | 'e' | 'se' | 's' | 'sw' | 'w' | 'nw' | 'c' | '_';

STRING      : [a-zA-Z_][a-zA-Z_0-9]?; //\u{200}-\u{377} //\u{200}-\u{377}
NUMERAL     : [-]?([.][0-9]+|[0-9]+([.][0-9]*)?);
DQSRING     : [\\]?["]+.*?["]+;
HTMLSTRING  : [<]+.*?[>]+;
SEMICOLON   : ';';
COLON       : ':';
COMMA       : ',';
LBRACKET    : '[';
RBRACKET    : ']';
LBRACE      : '{';
RBRACE      : '}';
ARROW       : '->';
LINE        : '--';
EQUALS      : '=';
COMMENT     : ([/][*])+.*?([*][/])+ -> skip;
LCOMMENT    : ([/][/])+.*? -> skip;
PREPROC     : [#][^\r\n]* -> skip;
WS          : [ \t\r\n]+ -> skip;
