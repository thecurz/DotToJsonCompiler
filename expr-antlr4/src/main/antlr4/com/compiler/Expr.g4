grammar Expr;

GRAPH: [Ss][Tt][Rr][Ii][Cc][Tt]?;
GRAPH_TYPE: [Gg][Rr][Aa][Pp][Hh] | [Dd][Ii][Gg][Rr][Aa][Pp][Hh];
ID: [a-zA-Z_0-9]+;
INT: [0-9]+;
SEMICOLON: ';';
COLON: ':';
COMMA: ',';
LBRACKET: '[';
RBRACKET: ']';
LBRACE: '{';
RBRACE: '}';
ARROW: '->' | '--';
EQUALS: '=';
WS: [ \t\r\n]+ -> skip;

graph: (GRAPH_TYPE ID? LBRACE stmt_list RBRACE);

stmt_list: (stmt (SEMICOLON stmt_list)?)?;

stmt: node_stmt
    | edge_stmt
    | attr_stmt
    | ID EQUALS ID
    | subgraph;

attr_stmt: (GRAPH_TYPE | 'node' | 'edge') attr_list;

attr_list: LBRACKET (a_list)? RBRACKET (attr_list)?;

a_list: ID EQUALS ID (SEMICOLON | COMMA)? (a_list)?;

edge_stmt: (node_id | subgraph) edgeRHS attr_list?;

edgeRHS: ARROW (node_id | subgraph) (edgeRHS)?;

node_stmt: node_id attr_list?;

node_id: ID (port)?;

port: COLON ID (COLON compass_pt)?
    | COLON compass_pt;

compass_pt: ('n' | 'ne' | 'e' | 'se' | 's' | 'sw' | 'w' | 'nw' | 'c' | '_');

subgraph: ('subgraph' (ID)?) LBRACE stmt_list RBRACE;


