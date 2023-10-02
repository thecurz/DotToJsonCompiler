package com.compiler;

import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ExprParserVisitorImpl implements ExprParserVisitor<String> {
    Map<String, String> memory = new HashMap<String, String>();

    @Override
    public String visitProgram(ExprParser.ProgramContext ctx) {
        return "";
    }
    @Override
    public String visitGraph(ExprParser.GraphContext ctx) {
        return "";
    }
    @Override
    public String visitStmtListExpr(ExprParser.StmtListExprContext ctx) {
        return "";
    }
    @Override
    public String visitNodeStmt(ExprParser.NodeStmtContext ctx) {
        return "";
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
        return "";
    }

    @Override
    public String visitSubgraphStmt(ExprParser.SubgraphStmtContext ctx) {
        return "";
    }

    @Override
    public String visitAttr_stmt(ExprParser.Attr_stmtContext ctx) {
        return "";
    }

    @Override
    public String visitAttr_list(ExprParser.Attr_listContext ctx) {
        return "";
    }

    @Override
    public String visitA_list(ExprParser.A_listContext ctx) {
        return "";
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
    public String visitSubgraph(ExprParser.SubgraphContext ctx) {
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
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }
}
