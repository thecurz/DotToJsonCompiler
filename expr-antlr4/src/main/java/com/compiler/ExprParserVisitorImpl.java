package com.compiler;

import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import com.compiler.ExprParser.GraphContext;
import com.compiler.ExprParser.StmtContext;
import com.compiler.ExprParser.Stmt_listContext;

public class ExprParserVisitorImpl implements ExprParserVisitor<String> {
    Map<String, String> memory = new HashMap<String, String>();
    private final String endingChar = "\n";

    @Override
    public String visitProgram(ExprParser.ProgramContext ctx) {
        String graphResult = visit(ctx.graph()); // Aún no es claro como guardarlo
        return graphResult;
    }

    @Override
    public String visitGraph(ExprParser.GraphContext ctx) {
        String str = "";
        String id = ctx.id() != null ? ctx.id().getText() : "";
        String value = ctx.GRAPH() != null ? ctx.GRAPH().getText() : ctx.DIGRAPH().getText();
        str += id + " " + value;
        memory.put(id, value);
        return str + visitStmt_list(ctx.stmt_list()) + endingChar;
    }

    @Override
    public String visitSubgraph(ExprParser.SubgraphContext ctx) {
        String str = "";
        // TODO: implement nonexistent id
        str += ctx.id();
        str += " " + visitStmt_list(ctx.stmt_list());
        return str + endingChar;
    }

    private String visitStmt(ExprParser.StmtContext ctx){
        if (ctx.node_stmt() != null) {
            return visitNodeStmt(ctx.node_stmt());
        } else if (ctx.edge_stmt() != null) {
            return visitEdgeStmt(ctx.edge_stmt());
        } else if (ctx.attr_stmt() != null) {
            return visitAttrStmt(ctx.attr_stmt());
        } else if (ctx.assign() != null) {
            return visitAssign(ctx.assign());
        } else if (ctx.subgraph() != null) {
            return visitSubgraphStmt(ctx.subgraph());
        }
        return "";
    }
    
    @Override
    public String visitSubgraphStmt(ExprParser.SubgraphStmtContext ctx) {
        String id = ctx.id() != null ? ctx.id().getText() : "";
        String value = visit(ctx.stmt_list());
        memory.put(id, value);
        return value;
    }

    private String processStmtList(Stmt_listContext ctx, String str) {
        StmtContext stmt = ctx.stmt(); // Access the stmt if it exists

        if (stmt != null) {
            str += " " + visit(stmt);
            processStmtList(ctx.stmt_list(), str);
        }
        return str;
    }

    @Override
    public String visitStmt_list(Stmt_listContext ctx) {
        String str = processStmtList(ctx, " ");
        memory.put("stmt_list", str);
        return str + endingChar;
    }

    @Override
    public String visitNodeStmt(ExprParser.NodeStmtContext ctx) {
        String nodeID = ctx.node_stmt().node_id().getText();
        String attr_list = ctx.node_stmt().attr_list().getText();
        memory.put(nodeID, attr_list);
        return attr_list;
    }

    @Override
    public String visitEdgeStmt(ExprParser.EdgeStmtContext ctx) {
        String id = ctx.node_id() != null ? "node_id" : "subgraph";
        String result = visit(ctx.edgeRHS());

        String attrList = ctx.attr_list() != null ? visit(ctx.attr_list()) : null;

        String values = result;
        if (attrList != null) {
            values += " " + attrList;
        }

        memory.put(id, values);
        return values;
    }

    @Override
    public String visitAttrStmt(ExprParser.AttrStmtContext ctx) {
        String id = ctx.getChild(0).getText();
        String values = visit(ctx.attr_list());
        memory.put(id, values);
        return values;
    }

    @Override
    public String visitAssign(ExprParser.AssignContext ctx) {
        String id = ctx.id(0).getText();
        String value = ctx.id(1).getText();
        memory.put(id, value);
        return value;
    }

    @Override
    public String visitAttr_stmt(ExprParser.Attr_stmtContext ctx) {
        String type = ctx.getChild(0).getText();
        String value = visit(ctx.attr_list());
        memory.put(type, value);

        return "";
    }

    @Override
    public String visitAttr_list(ExprParser.Attr_listContext ctx) {
        StringBuilder result = new StringBuilder();
        if (ctx.a_list() != null) {
            result.append(visit(ctx.a_list()));
        }
        if (ctx.attr_list() != null) {
            result.append(visit(ctx.attr_list()));
        }

        return result.toString();
    }

    @Override
    public String visitA_list(ExprParser.A_listContext ctx) {
        StringBuilder result = new StringBuilder();
        String id = ctx.id(0).getText();
        String value = ctx.id(1).getText();

        result.append(id).append("=").append(value).append(" ");
        if (ctx.a_list() != null) {
            result.append(visit(ctx.a_list()));
        }

        return result.toString();
    }

    @Override
    public String visitEdge_stmt(ExprParser.Edge_stmtContext ctx) {
        String value = visit(ctx.edgeRHS());
        if (ctx.node_id() != null) {
            String nodeIdInfo = visit(ctx.node_id());
            value += " " + nodeIdInfo;
        } else if (ctx.subgraph() != null) {
            String subgraphInfo = visit(ctx.subgraph());
            value += " " + subgraphInfo;
        }
        if (ctx.attr_list() != null) {
            String attrListInfo = visit(ctx.attr_list());
            value += " " + attrListInfo;
        }
        memory.put("edge", value);
        return value;
    }

    @Override
    public String visitEdgeRHS(ExprParser.EdgeRHSContext ctx) {
        String result = "";
        result += visit(ctx.edgeop());

        if (ctx.node_id() != null) { result += visit(ctx.node_id()); } 
        else if (ctx.subgraph() != null) { result += visit(ctx.subgraph()); }

        if (ctx.edgeRHS() != null) { result += visit(ctx.edgeRHS()); }
        return result;
    }

    @Override
    public String visitNode_stmt(ExprParser.Node_stmtContext ctx) {
        String id = visit(ctx.node_id());
        String values = "";
        
        if (ctx.attr_list() != null) { values = visit(ctx.attr_list()); }
        
        memory.put(id, values);
        return values;
    }

    @Override
    public String visitNode_id(ExprParser.Node_idContext ctx) {
        String id = ctx.id().getText();
        String portInfo = "";
        
        if (ctx.port() != null) { portInfo = visit(ctx.port()); }
        String value = id + portInfo;
        
        memory.put(id, value);
        return value;
    }

    @Override
    public String visitPortId(ExprParser.PortIdContext ctx) {
        String id = ctx.id().getText();
        String value = "Port ID";
        if (ctx.COMPASS_PT() != null) { value += " with Compass Point"; }

        memory.put(id, value);
        return value;
    }

    @Override
    public String visitPortCompass(ExprParser.PortCompassContext ctx) {
        String id = ctx.COMPASS_PT().getText();
        memory.put(id, ":");
        return ":";
    }

    @Override
    public String visitEdgeop(ExprParser.EdgeopContext ctx) {
        String value = ctx.getText();
        memory.put("edgeOperator", value);
        return value;
    }

    @Override
    public String visitId(ExprParser.IdContext ctx) {
        String id = ctx.getStart().getText();
        String value = ctx.getText();
        memory.put(id, value);
        return value;
    }

    /**
     * Visit a parse tree, and return a user-defined result of the operation.
     *
     * @param tree The {@link ParseTree} to visit.
     * @return The result of visiting the parse tree.
     */

    /**
     * Visit the children of a node, and return a user-defined result of the
     * operation.
     *
     * @param node The {@link RuleNode} whose children should be visited.
     * @return The result of visiting the children of the node.
     */
    // @Override
    // public String visitChildren(RuleNode node) {
    //     return "";
    // }

    /**
     * Visit a terminal node, and return a user-defined result of the operation.
     *
     * @param node The {@link TerminalNode} to visit.
     * @return The result of visiting the node.
     */
    @Override
    public String visitTerminal(TerminalNode node) {
        String id = node.getText();
        int value = node.getSymbol().getType();
        
        if (value == ExprLexer.ID) {
            // Es un identificador, realiza alguna acción
        } else if (value == ExprLexer.NUMERAL) {
            // Es un número, realiza alguna acción
        } else if (value == ExprLexer.STRING) {
            // Es una cadena, realiza alguna acción
        }
 
        return id;
    }

    /**
     * Visit an error node, and return a user-defined result of the operation.
     *
     * @param node The {@link ErrorNode} to visit.
     * @return The result of visiting the node.
     */
    @Override
    public String visitErrorNode(ErrorNode node) {
        System.err.println("Error sintáctico en la línea " + node.getSymbol().getLine() +
        ", columna " + node.getSymbol().getCharPositionInLine() +
        ": Token inesperado '" + node.getSymbol().getText() + "'");

        return "";
    }

    @Override
    public String visit(ParseTree tree) {
        String str = "";
        if (tree instanceof GraphContext) {
            GraphContext graphContext = (GraphContext) tree;
            System.out.println("isistance");
            str += " " + visitGraph(graphContext);
        }
        return str;
    }

}
