// Generated from c:/Users/theca/Documents/java/DotToJsonCompiler-main/expr-antlr4/src/main/antlr4/com/compiler/ExprParser.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprParser}.
 */
public interface ExprParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExprParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ExprParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ExprParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#graph}.
	 * @param ctx the parse tree
	 */
	void enterGraph(ExprParser.GraphContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#graph}.
	 * @param ctx the parse tree
	 */
	void exitGraph(ExprParser.GraphContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmtListExpr}
	 * labeled alternative in {@link ExprParser#stmt_list}.
	 * @param ctx the parse tree
	 */
	void enterStmtListExpr(ExprParser.StmtListExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmtListExpr}
	 * labeled alternative in {@link ExprParser#stmt_list}.
	 * @param ctx the parse tree
	 */
	void exitStmtListExpr(ExprParser.StmtListExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nodeStmt}
	 * labeled alternative in {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterNodeStmt(ExprParser.NodeStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nodeStmt}
	 * labeled alternative in {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitNodeStmt(ExprParser.NodeStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code edgeStmt}
	 * labeled alternative in {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterEdgeStmt(ExprParser.EdgeStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code edgeStmt}
	 * labeled alternative in {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitEdgeStmt(ExprParser.EdgeStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code attrStmt}
	 * labeled alternative in {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterAttrStmt(ExprParser.AttrStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code attrStmt}
	 * labeled alternative in {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitAttrStmt(ExprParser.AttrStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssign(ExprParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssign(ExprParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subgraphStmt}
	 * labeled alternative in {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterSubgraphStmt(ExprParser.SubgraphStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subgraphStmt}
	 * labeled alternative in {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitSubgraphStmt(ExprParser.SubgraphStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#attr_stmt}.
	 * @param ctx the parse tree
	 */
	void enterAttr_stmt(ExprParser.Attr_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#attr_stmt}.
	 * @param ctx the parse tree
	 */
	void exitAttr_stmt(ExprParser.Attr_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#attr_list}.
	 * @param ctx the parse tree
	 */
	void enterAttr_list(ExprParser.Attr_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#attr_list}.
	 * @param ctx the parse tree
	 */
	void exitAttr_list(ExprParser.Attr_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#a_list}.
	 * @param ctx the parse tree
	 */
	void enterA_list(ExprParser.A_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#a_list}.
	 * @param ctx the parse tree
	 */
	void exitA_list(ExprParser.A_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#edge_stmt}.
	 * @param ctx the parse tree
	 */
	void enterEdge_stmt(ExprParser.Edge_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#edge_stmt}.
	 * @param ctx the parse tree
	 */
	void exitEdge_stmt(ExprParser.Edge_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#edgeRHS}.
	 * @param ctx the parse tree
	 */
	void enterEdgeRHS(ExprParser.EdgeRHSContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#edgeRHS}.
	 * @param ctx the parse tree
	 */
	void exitEdgeRHS(ExprParser.EdgeRHSContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#node_stmt}.
	 * @param ctx the parse tree
	 */
	void enterNode_stmt(ExprParser.Node_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#node_stmt}.
	 * @param ctx the parse tree
	 */
	void exitNode_stmt(ExprParser.Node_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#node_id}.
	 * @param ctx the parse tree
	 */
	void enterNode_id(ExprParser.Node_idContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#node_id}.
	 * @param ctx the parse tree
	 */
	void exitNode_id(ExprParser.Node_idContext ctx);
	/**
	 * Enter a parse tree produced by the {@code portId}
	 * labeled alternative in {@link ExprParser#port}.
	 * @param ctx the parse tree
	 */
	void enterPortId(ExprParser.PortIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code portId}
	 * labeled alternative in {@link ExprParser#port}.
	 * @param ctx the parse tree
	 */
	void exitPortId(ExprParser.PortIdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code portCompass}
	 * labeled alternative in {@link ExprParser#port}.
	 * @param ctx the parse tree
	 */
	void enterPortCompass(ExprParser.PortCompassContext ctx);
	/**
	 * Exit a parse tree produced by the {@code portCompass}
	 * labeled alternative in {@link ExprParser#port}.
	 * @param ctx the parse tree
	 */
	void exitPortCompass(ExprParser.PortCompassContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#subgraph}.
	 * @param ctx the parse tree
	 */
	void enterSubgraph(ExprParser.SubgraphContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#subgraph}.
	 * @param ctx the parse tree
	 */
	void exitSubgraph(ExprParser.SubgraphContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#edgeop}.
	 * @param ctx the parse tree
	 */
	void enterEdgeop(ExprParser.EdgeopContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#edgeop}.
	 * @param ctx the parse tree
	 */
	void exitEdgeop(ExprParser.EdgeopContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(ExprParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(ExprParser.IdContext ctx);
}