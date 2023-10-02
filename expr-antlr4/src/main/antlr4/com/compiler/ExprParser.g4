parser grammar ExprParser;
options { tokenVocab=ExprLexer; }

program     : graph EOF
            ;
graph       : STRICT? (GRAPH | DIGRAPH) id? LBRACE stmt_list RBRACE 
            ;
stmt_list   : (stmt SEMICOLON? stmt_list)?                          #stmtListExpr
            ;
stmt        : node_stmt                                             #nodeStmt
            | edge_stmt                                             #edgeStmt
            | attr_stmt                                             #attrStmt
            | id EQUALS id                                          #assign
            | subgraph                                              #subgraphStmt
            ;
attr_stmt   : (GRAPH | NODE | EDGE) attr_list                       
            ;
attr_list   : LBRACKET (a_list)? RBRACKET (attr_list)?              
            ;
a_list      : id EQUALS id (SEMICOLON | COMMA)? (a_list)?           
            ;
edge_stmt   : (node_id | subgraph) edgeRHS (attr_list)?             
            ;
edgeRHS     : edgeop (node_id | subgraph) (edgeRHS)?               
            ;
node_stmt   : node_id (attr_list)?                                  
            ;
node_id     : id (port)?                                            
            ;
port        : COLON id (COLON COMPASS_PT)?                          #portId
            | COLON COMPASS_PT                                      #portCompass
            ;
subgraph    : (SUBGRAPH (id)?)? LBRACE stmt_list RBRACE             
            ;
edgeop      : ARROW | LINE                                          
            ;
id          : STRING | NUMERAL | DQSRING | HTMLSTRING             
            ;