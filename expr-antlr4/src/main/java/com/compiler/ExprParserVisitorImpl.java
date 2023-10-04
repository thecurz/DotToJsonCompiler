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
    private String visitStmt(StmtContext ctx){
        String str = "";
        return str;
    }
    @Override
    public String visitSubgraphStmt(ExprParser.SubgraphStmtContext ctx) {
        return "";
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
        return "";
    }

    @Override
    public String visitAttrStmt(ExprParser.AttrStmtContext ctx) {
        return "";
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
        return "";
    }

    @Override
    public String visitEdgeRHS(ExprParser.EdgeRHSContext ctx) {
        return "";
    }

    @Override
    public String visitNode_stmt(ExprParser.Node_stmtContext ctx) {
        return "";
    }

    @Override
    public String visitNode_id(ExprParser.Node_idContext ctx) {
        return "";
    }

    @Override
    public String visitPortId(ExprParser.PortIdContext ctx) {
        return "";
    }

    @Override
    public String visitPortCompass(ExprParser.PortCompassContext ctx) {
        return "";
    }

    @Override
    public String visitEdgeop(ExprParser.EdgeopContext ctx) {
        return "";
    }

    @Override
    public String visitId(ExprParser.IdContext ctx) {
        return "";
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
    @Override
    public String visitChildren(RuleNode node) {
        return "";
    }

    /**
     * Visit a terminal node, and return a user-defined result of the operation.
     *
     * @param node The {@link TerminalNode} to visit.
     * @return The result of visiting the node.
     */
    @Override
    public String visitTerminal(TerminalNode node) {
        return "";
    }

    /**
     * Visit an error node, and return a user-defined result of the operation.
     *
     * @param node The {@link ErrorNode} to visit.
     * @return The result of visiting the node.
     */
    @Override
    public String visitErrorNode(ErrorNode node) {
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
