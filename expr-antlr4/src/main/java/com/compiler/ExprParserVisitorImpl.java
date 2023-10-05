package com.compiler;

import java.util.LinkedHashMap;
import java.util.Map;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import com.compiler.ExprParser.EdgeRHSContext;
import com.compiler.ExprParser.Edge_stmtContext;
import com.compiler.ExprParser.GraphContext;
import com.compiler.ExprParser.StmtContext;
import com.compiler.ExprParser.Stmt_listContext;

public class ExprParserVisitorImpl implements ExprParserVisitor<String> {
    Map<String, String> memory = new LinkedHashMap<String, String>();
    private int number = 0;

    public String getN() {
        String result = "" + number;
        number++;
        return result;
    }

    private final String endingChar = "\n";

    public void printMap() {
        for (Map.Entry<String, String> entry : memory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public String mapToString() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> entry : memory.entrySet()) {
            result.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return result.toString();
    }

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
        memory.put("Graph" + id, value);
        return str + visitStmt_list(ctx.stmt_list()) + endingChar;
    }

    @Override
    public String visitSubgraph(ExprParser.SubgraphContext ctx) {

        String str = "";
        // TODO: implement nonexistent id
        str += ctx.id();
        memory.put(getN() + "Subraph", ctx.id().getText());
        str += " " + visitStmt_list(ctx.stmt_list());

        return str + endingChar;
    }

    @Override
    public String visitSubgraphStmt(ExprParser.SubgraphStmtContext ctx) {
        String id = ctx.subgraph().id() != null ? ctx.subgraph().id().getText() : "";
        String value = visitStmt_list(ctx.subgraph().stmt_list());
        memory.put(id, value);
        return value;
    }

    private String processStmtList(Stmt_listContext ctx, String str) {
        StmtContext stmt = ctx.stmt(); // Access the stmt if it exists
        if (stmt == null)
            return str;
        str += " " + visit(stmt);
        processStmtList(ctx.stmt_list(), str);
        if (stmt instanceof ExprParser.NodeStmtContext) {
            ExprParser.NodeStmtContext node_ctx = (ExprParser.NodeStmtContext) stmt;
            String text = node_ctx.node_stmt().node_id().getText();
            memory.put(getN() + "node_stmt" + text, text);
        } else if (stmt instanceof ExprParser.EdgeStmtContext) {
            ExprParser.EdgeStmtContext edge_ctx = (ExprParser.EdgeStmtContext) stmt;
            String text = edge_ctx.edge_stmt().node_id().getText();
            memory.put(getN() + "edge_stmt", text + " -> "
                    + edge_ctx.edge_stmt().edgeRHS().node_id().getText());
            EdgeRHSContext curr = edge_ctx.edge_stmt().edgeRHS();
            while (curr.edgeRHS() != null) {
                // System.out.println(curr.node_id().getText());
                memory.put(getN() + "edge_stmt", curr.node_id().getText() + " -> "
                        + curr.edgeRHS().node_id().getText());
                curr = curr.edgeRHS();
            }
            // TODO: RHS
        } else if (stmt instanceof ExprParser.AttrStmtContext) {
            ExprParser.AttrStmtContext attr_ctx = (ExprParser.AttrStmtContext) stmt;
            // TODO: graph? node? edge?
            memory.put(getN() + "attr_stmt", visitAttr_list(attr_ctx.attr_stmt().attr_list()));
        } else if (stmt instanceof ExprParser.AssignContext) {
            ExprParser.AssignContext attr_ctx = (ExprParser.AssignContext) stmt;
            memory.put(getN() + "assign", visitAssign(attr_ctx));
        } else if (stmt instanceof ExprParser.SubgraphStmtContext) {
            ExprParser.SubgraphStmtContext sub_ctx = (ExprParser.SubgraphStmtContext) stmt;
            memory.put(getN() + "subgraph_stmt", sub_ctx.subgraph().id().getText());
            visitSubgraphStmt(sub_ctx);
        }
        //
        // else if (ctx.stmt_list() != null) {
        // System.out.println("called");
        // processStmtList(ctx.stmt_list(), str);
        // }
        return str;
    }

    @Override
    public String visitStmt_list(Stmt_listContext ctx) {
        String str = processStmtList(ctx, " ");
        memory.put(getN() + "stmt_list", str);
        return str + endingChar;
    }

    @Override
    public String visitNodeStmt(ExprParser.NodeStmtContext ctx) {
        String nodeID = ctx.node_stmt().node_id().getText();
        String attr_list = ctx.node_stmt().attr_list().getText();
        memory.put(getN() + nodeID, attr_list);
        return attr_list;
    }

    @Override
    public String visitEdgeStmt(ExprParser.EdgeStmtContext ctx) {
        String id = ctx.edge_stmt().node_id() != null ? "node_id" : "subgraph";
        String result = visit(ctx.edge_stmt().edgeRHS());

        String attrList = ctx.edge_stmt().attr_list() != null ? visit(ctx.edge_stmt().attr_list()) : null;

        String values = result;
        if (attrList != null) {
            values += " " + attrList;
        }

        memory.put(getN() + id, values);
        return values;
    }

    @Override
    public String visitAttrStmt(ExprParser.AttrStmtContext ctx) {
        String id = ctx.getChild(0).getText();
        String values = visit(ctx.attr_stmt().attr_list());
        memory.put(getN() + id, values);
        return values;
    }

    @Override
    public String visitAssign(ExprParser.AssignContext ctx) {
        String id = ctx.id(0).getText();
        String value = ctx.id(1).getText();
        // memory.put(id, value);
        return id + " = " + value;
    }

    @Override
    public String visitAttr_stmt(ExprParser.Attr_stmtContext ctx) {
        String type = ctx.getChild(0).getText();
        String value = visit(ctx.attr_list());
        memory.put(getN() + type, value);

        return "";
    }

    @Override
    public String visitAttr_list(ExprParser.Attr_listContext ctx) {
        StringBuilder result = new StringBuilder();
        if (ctx.a_list() != null) {
            result.append(visitA_list(ctx.a_list()));
            visitA_list(ctx.a_list());
        }
        if (ctx.attr_list() != null) {
            result.append(visitAttr_list(ctx.attr_list()));
            visitAttr_list(ctx.attr_list());
        }
        return result.toString();
    }

    @Override
    public String visitA_list(ExprParser.A_listContext ctx) {
        StringBuilder result = new StringBuilder();
        String id = ctx.id(0).getText();
        String id2 = ctx.id(1).getText();
        String value = ctx.id(1).getText();
        memory.put(getN() + "a_list", id + " = " + id2);
        result.append(id).append("=").append(value).append(" ");
        if (ctx.a_list() != null) {
            visitA_list(ctx.a_list());
            result.append(visit(ctx.a_list()));
        }

        return result.toString();
    }

    @Override
    public String visitEdge_stmt(ExprParser.Edge_stmtContext ctx) {
        // String value = visit(ctx.edgeRHS());
        // if (ctx.node_id() != null) {
        // String nodeIdInfo = visit(ctx.node_id());
        // value += " " + nodeIdInfo;
        // } else if (ctx.subgraph() != null) {
        // String subgraphInfo = visit(ctx.subgraph());
        // value += " " + subgraphInfo;
        // }
        // if (ctx.attr_list() != null) {
        // String attrListInfo = visit(ctx.attr_list());
        // value += " " + attrListInfo;
        // }
        // memory.put(getN() + "edge", value);
        // return value;
        return "";
    }

    @Override
    public String visitEdgeRHS(ExprParser.EdgeRHSContext ctx) {
        String result = "";
        result += visit(ctx.edgeop());

        if (ctx.node_id() != null) {
            result += visit(ctx.node_id());
        } else if (ctx.subgraph() != null) {
            result += visit(ctx.subgraph());
        }

        if (ctx.edgeRHS() != null) {
            result += visit(ctx.edgeRHS());
        }
        return result;
    }

    @Override
    public String visitNode_stmt(ExprParser.Node_stmtContext ctx) {
        String id = visit(ctx.node_id());
        String values = "";

        if (ctx.attr_list() != null) {
            values = visit(ctx.attr_list());
        }

        memory.put(getN() + id, values);
        return values;
    }

    @Override
    public String visitNode_id(ExprParser.Node_idContext ctx) {
        String id = ctx.id().getText();
        String portInfo = "";

        if (ctx.port() != null) {
            portInfo = visit(ctx.port());
        }
        String value = id + portInfo;

        memory.put(id, value);
        return value;
    }

    @Override
    public String visitPortId(ExprParser.PortIdContext ctx) {
        String id = ctx.id().getText();
        String value = "Port ID";
        if (ctx.COMPASS_PT() != null) {
            value += " with Compass Point";
        }

        memory.put(getN() + id, value);
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
        memory.put(getN() + "edgeOperator", value);
        return value;
    }

    @Override
    public String visitId(ExprParser.IdContext ctx) {
        String id = ctx.getStart().getText();
        String value = ctx.getText();
        memory.put(id, value);
        return value;
    }

    @Override
    public String visitTerminal(TerminalNode node) {
        throw new UnsupportedOperationException("visitTerminal function is not implemented.");
        // String id = node.getText();
        // int value = node.getSymbol().getType();

        // if (value == ExprLexer.ID) {
        // // Es un identificador, realiza alguna acción
        // } else if (value == ExprLexer.NUMERAL) {
        // // Es un número, realiza alguna acción
        // } else if (value == ExprLexer.STRING) {
        // // Es una cadena, realiza alguna acción
        // }

        // return id;
    }

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
            str += " " + visitGraph(graphContext);
        }
        return str;
    }

    @Override
    public String visitChildren(RuleNode node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitChildren'");
    }

}
