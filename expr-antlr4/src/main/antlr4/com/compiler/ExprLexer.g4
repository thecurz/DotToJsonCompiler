lexer grammar ExprLexer;

NODE        : [Nn][Oo][Dd][Ee];
EDGE        : [Ed][Dd][Gg][Ee];
STRICT      : [Ss][Tt][Rr][Ii][Cc][Tt];
SUBGRAPH    : [Ss][Uu][Bb][Gg][Rr][Aa][Pp][Hh];
DIGRAPH     : [Dd][Ii][Gg][Rr][Aa][Pp][Hh];
GRAPH       : [Gg][Rr][Aa][Pp][Hh];

STRING      : [a-zA-Z_][a-zA-Z_0-9]*; //\u{200}-\u{377} //\u{200}-\u{377}
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
LCOMMENT    : ([/][/])+.*?[\n] -> skip;
PREPROC     : [#][^\r\n]* -> skip;
WS          : [ \t\r\n]+ -> skip;

COMPASS_PT  : ('n' | 'ne' | 'e' | 'se' | 's' | 'sw' | 'w' | 'nw' | 'c' | '_');