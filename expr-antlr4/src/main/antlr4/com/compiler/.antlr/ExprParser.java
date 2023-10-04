// Generated from c:/Users/theca/Documents/java/DotToJsonCompiler-main/expr-antlr4/src/main/antlr4/com/compiler/ExprParser.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ExprParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NODE=1, EDGE=2, STRICT=3, SUBGRAPH=4, DIGRAPH=5, GRAPH=6, STRING=7, NUMERAL=8, 
		DQSRING=9, HTMLSTRING=10, SEMICOLON=11, COLON=12, COMMA=13, LBRACKET=14, 
		RBRACKET=15, LBRACE=16, RBRACE=17, ARROW=18, LINE=19, EQUALS=20, COMMENT=21, 
		LCOMMENT=22, PREPROC=23, WS=24, COMPASS_PT=25;
	public static final int
		RULE_program = 0, RULE_graph = 1, RULE_stmt_list = 2, RULE_stmt = 3, RULE_attr_stmt = 4, 
		RULE_attr_list = 5, RULE_a_list = 6, RULE_edge_stmt = 7, RULE_edgeRHS = 8, 
		RULE_node_stmt = 9, RULE_node_id = 10, RULE_port = 11, RULE_subgraph = 12, 
		RULE_edgeop = 13, RULE_id = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "graph", "stmt_list", "stmt", "attr_stmt", "attr_list", "a_list", 
			"edge_stmt", "edgeRHS", "node_stmt", "node_id", "port", "subgraph", "edgeop", 
			"id"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "';'", 
			"':'", "','", "'['", "']'", "'{'", "'}'", "'->'", "'--'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NODE", "EDGE", "STRICT", "SUBGRAPH", "DIGRAPH", "GRAPH", "STRING", 
			"NUMERAL", "DQSRING", "HTMLSTRING", "SEMICOLON", "COLON", "COMMA", "LBRACKET", 
			"RBRACKET", "LBRACE", "RBRACE", "ARROW", "LINE", "EQUALS", "COMMENT", 
			"LCOMMENT", "PREPROC", "WS", "COMPASS_PT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ExprParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public GraphContext graph() {
			return getRuleContext(GraphContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ExprParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			graph();
			setState(31);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GraphContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(ExprParser.LBRACE, 0); }
		public Stmt_listContext stmt_list() {
			return getRuleContext(Stmt_listContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(ExprParser.RBRACE, 0); }
		public TerminalNode GRAPH() { return getToken(ExprParser.GRAPH, 0); }
		public TerminalNode DIGRAPH() { return getToken(ExprParser.DIGRAPH, 0); }
		public TerminalNode STRICT() { return getToken(ExprParser.STRICT, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public GraphContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_graph; }
	}

	public final GraphContext graph() throws RecognitionException {
		GraphContext _localctx = new GraphContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_graph);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRICT) {
				{
				setState(33);
				match(STRICT);
				}
			}

			setState(36);
			_la = _input.LA(1);
			if ( !(_la==DIGRAPH || _la==GRAPH) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1920L) != 0)) {
				{
				setState(37);
				id();
				}
			}

			setState(40);
			match(LBRACE);
			setState(41);
			stmt_list();
			setState(42);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Stmt_listContext extends ParserRuleContext {
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public Stmt_listContext stmt_list() {
			return getRuleContext(Stmt_listContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(ExprParser.SEMICOLON, 0); }
		public Stmt_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt_list; }
	}

	public final Stmt_listContext stmt_list() throws RecognitionException {
		Stmt_listContext _localctx = new Stmt_listContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stmt_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 67542L) != 0)) {
				{
				setState(44);
				stmt();
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(45);
					match(SEMICOLON);
					}
				}

				setState(48);
				stmt_list();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StmtContext extends ParserRuleContext {
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	 
		public StmtContext() { }
		public void copyFrom(StmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NodeStmtContext extends StmtContext {
		public Node_stmtContext node_stmt() {
			return getRuleContext(Node_stmtContext.class,0);
		}
		public NodeStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EdgeStmtContext extends StmtContext {
		public Edge_stmtContext edge_stmt() {
			return getRuleContext(Edge_stmtContext.class,0);
		}
		public EdgeStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttrStmtContext extends StmtContext {
		public Attr_stmtContext attr_stmt() {
			return getRuleContext(Attr_stmtContext.class,0);
		}
		public AttrStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SubgraphStmtContext extends StmtContext {
		public SubgraphContext subgraph() {
			return getRuleContext(SubgraphContext.class,0);
		}
		public SubgraphStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends StmtContext {
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public TerminalNode EQUALS() { return getToken(ExprParser.EQUALS, 0); }
		public AssignContext(StmtContext ctx) { copyFrom(ctx); }
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_stmt);
		try {
			setState(60);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new NodeStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				node_stmt();
				}
				break;
			case 2:
				_localctx = new EdgeStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(53);
				edge_stmt();
				}
				break;
			case 3:
				_localctx = new AttrStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(54);
				attr_stmt();
				}
				break;
			case 4:
				_localctx = new AssignContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(55);
				id();
				setState(56);
				match(EQUALS);
				setState(57);
				id();
				}
				break;
			case 5:
				_localctx = new SubgraphStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(59);
				subgraph();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Attr_stmtContext extends ParserRuleContext {
		public Attr_listContext attr_list() {
			return getRuleContext(Attr_listContext.class,0);
		}
		public TerminalNode GRAPH() { return getToken(ExprParser.GRAPH, 0); }
		public TerminalNode NODE() { return getToken(ExprParser.NODE, 0); }
		public TerminalNode EDGE() { return getToken(ExprParser.EDGE, 0); }
		public Attr_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr_stmt; }
	}

	public final Attr_stmtContext attr_stmt() throws RecognitionException {
		Attr_stmtContext _localctx = new Attr_stmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_attr_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 70L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(63);
			attr_list();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Attr_listContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(ExprParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(ExprParser.RBRACKET, 0); }
		public A_listContext a_list() {
			return getRuleContext(A_listContext.class,0);
		}
		public Attr_listContext attr_list() {
			return getRuleContext(Attr_listContext.class,0);
		}
		public Attr_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr_list; }
	}

	public final Attr_listContext attr_list() throws RecognitionException {
		Attr_listContext _localctx = new Attr_listContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_attr_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(LBRACKET);
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1920L) != 0)) {
				{
				setState(66);
				a_list();
				}
			}

			setState(69);
			match(RBRACKET);
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(70);
				attr_list();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class A_listContext extends ParserRuleContext {
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public TerminalNode EQUALS() { return getToken(ExprParser.EQUALS, 0); }
		public A_listContext a_list() {
			return getRuleContext(A_listContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(ExprParser.SEMICOLON, 0); }
		public TerminalNode COMMA() { return getToken(ExprParser.COMMA, 0); }
		public A_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_a_list; }
	}

	public final A_listContext a_list() throws RecognitionException {
		A_listContext _localctx = new A_listContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_a_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			id();
			setState(74);
			match(EQUALS);
			setState(75);
			id();
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON || _la==COMMA) {
				{
				setState(76);
				_la = _input.LA(1);
				if ( !(_la==SEMICOLON || _la==COMMA) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1920L) != 0)) {
				{
				setState(79);
				a_list();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Edge_stmtContext extends ParserRuleContext {
		public EdgeRHSContext edgeRHS() {
			return getRuleContext(EdgeRHSContext.class,0);
		}
		public Node_idContext node_id() {
			return getRuleContext(Node_idContext.class,0);
		}
		public SubgraphContext subgraph() {
			return getRuleContext(SubgraphContext.class,0);
		}
		public Attr_listContext attr_list() {
			return getRuleContext(Attr_listContext.class,0);
		}
		public Edge_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_edge_stmt; }
	}

	public final Edge_stmtContext edge_stmt() throws RecognitionException {
		Edge_stmtContext _localctx = new Edge_stmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_edge_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
			case NUMERAL:
			case DQSRING:
			case HTMLSTRING:
				{
				setState(82);
				node_id();
				}
				break;
			case SUBGRAPH:
			case LBRACE:
				{
				setState(83);
				subgraph();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(86);
			edgeRHS();
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(87);
				attr_list();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EdgeRHSContext extends ParserRuleContext {
		public EdgeopContext edgeop() {
			return getRuleContext(EdgeopContext.class,0);
		}
		public Node_idContext node_id() {
			return getRuleContext(Node_idContext.class,0);
		}
		public SubgraphContext subgraph() {
			return getRuleContext(SubgraphContext.class,0);
		}
		public EdgeRHSContext edgeRHS() {
			return getRuleContext(EdgeRHSContext.class,0);
		}
		public EdgeRHSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_edgeRHS; }
	}

	public final EdgeRHSContext edgeRHS() throws RecognitionException {
		EdgeRHSContext _localctx = new EdgeRHSContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_edgeRHS);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			edgeop();
			setState(93);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
			case NUMERAL:
			case DQSRING:
			case HTMLSTRING:
				{
				setState(91);
				node_id();
				}
				break;
			case SUBGRAPH:
			case LBRACE:
				{
				setState(92);
				subgraph();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ARROW || _la==LINE) {
				{
				setState(95);
				edgeRHS();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Node_stmtContext extends ParserRuleContext {
		public Node_idContext node_id() {
			return getRuleContext(Node_idContext.class,0);
		}
		public Attr_listContext attr_list() {
			return getRuleContext(Attr_listContext.class,0);
		}
		public Node_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_node_stmt; }
	}

	public final Node_stmtContext node_stmt() throws RecognitionException {
		Node_stmtContext _localctx = new Node_stmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_node_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			node_id();
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(99);
				attr_list();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Node_idContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public PortContext port() {
			return getRuleContext(PortContext.class,0);
		}
		public Node_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_node_id; }
	}

	public final Node_idContext node_id() throws RecognitionException {
		Node_idContext _localctx = new Node_idContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_node_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			id();
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(103);
				port();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PortContext extends ParserRuleContext {
		public PortContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_port; }
	 
		public PortContext() { }
		public void copyFrom(PortContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PortCompassContext extends PortContext {
		public TerminalNode COLON() { return getToken(ExprParser.COLON, 0); }
		public TerminalNode COMPASS_PT() { return getToken(ExprParser.COMPASS_PT, 0); }
		public PortCompassContext(PortContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PortIdContext extends PortContext {
		public List<TerminalNode> COLON() { return getTokens(ExprParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(ExprParser.COLON, i);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode COMPASS_PT() { return getToken(ExprParser.COMPASS_PT, 0); }
		public PortIdContext(PortContext ctx) { copyFrom(ctx); }
	}

	public final PortContext port() throws RecognitionException {
		PortContext _localctx = new PortContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_port);
		int _la;
		try {
			setState(114);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				_localctx = new PortIdContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				match(COLON);
				setState(107);
				id();
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(108);
					match(COLON);
					setState(109);
					match(COMPASS_PT);
					}
				}

				}
				break;
			case 2:
				_localctx = new PortCompassContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				match(COLON);
				setState(113);
				match(COMPASS_PT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SubgraphContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(ExprParser.LBRACE, 0); }
		public Stmt_listContext stmt_list() {
			return getRuleContext(Stmt_listContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(ExprParser.RBRACE, 0); }
		public TerminalNode SUBGRAPH() { return getToken(ExprParser.SUBGRAPH, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public SubgraphContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subgraph; }
	}

	public final SubgraphContext subgraph() throws RecognitionException {
		SubgraphContext _localctx = new SubgraphContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_subgraph);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SUBGRAPH) {
				{
				setState(116);
				match(SUBGRAPH);
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1920L) != 0)) {
					{
					setState(117);
					id();
					}
				}

				}
			}

			setState(122);
			match(LBRACE);
			setState(123);
			stmt_list();
			setState(124);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EdgeopContext extends ParserRuleContext {
		public TerminalNode ARROW() { return getToken(ExprParser.ARROW, 0); }
		public TerminalNode LINE() { return getToken(ExprParser.LINE, 0); }
		public EdgeopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_edgeop; }
	}

	public final EdgeopContext edgeop() throws RecognitionException {
		EdgeopContext _localctx = new EdgeopContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_edgeop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			_la = _input.LA(1);
			if ( !(_la==ARROW || _la==LINE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(ExprParser.STRING, 0); }
		public TerminalNode NUMERAL() { return getToken(ExprParser.NUMERAL, 0); }
		public TerminalNode DQSRING() { return getToken(ExprParser.DQSRING, 0); }
		public TerminalNode HTMLSTRING() { return getToken(ExprParser.HTMLSTRING, 0); }
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1920L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0019\u0083\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0003\u0001#\b\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001\'\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0003\u0002/\b\u0002\u0001\u0002\u0001"+
		"\u0002\u0003\u00023\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003=\b"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0003"+
		"\u0005D\b\u0005\u0001\u0005\u0001\u0005\u0003\u0005H\b\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006N\b\u0006\u0001\u0006"+
		"\u0003\u0006Q\b\u0006\u0001\u0007\u0001\u0007\u0003\u0007U\b\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007Y\b\u0007\u0001\b\u0001\b\u0001\b\u0003"+
		"\b^\b\b\u0001\b\u0003\ba\b\b\u0001\t\u0001\t\u0003\te\b\t\u0001\n\u0001"+
		"\n\u0003\ni\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000bo\b\u000b\u0001\u000b\u0001\u000b\u0003\u000bs\b\u000b\u0001\f\u0001"+
		"\f\u0003\fw\b\f\u0003\fy\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000e\u0000\u0000\u000f\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u0000\u0005"+
		"\u0001\u0000\u0005\u0006\u0002\u0000\u0001\u0002\u0006\u0006\u0002\u0000"+
		"\u000b\u000b\r\r\u0001\u0000\u0012\u0013\u0001\u0000\u0007\n\u0089\u0000"+
		"\u001e\u0001\u0000\u0000\u0000\u0002\"\u0001\u0000\u0000\u0000\u00042"+
		"\u0001\u0000\u0000\u0000\u0006<\u0001\u0000\u0000\u0000\b>\u0001\u0000"+
		"\u0000\u0000\nA\u0001\u0000\u0000\u0000\fI\u0001\u0000\u0000\u0000\u000e"+
		"T\u0001\u0000\u0000\u0000\u0010Z\u0001\u0000\u0000\u0000\u0012b\u0001"+
		"\u0000\u0000\u0000\u0014f\u0001\u0000\u0000\u0000\u0016r\u0001\u0000\u0000"+
		"\u0000\u0018x\u0001\u0000\u0000\u0000\u001a~\u0001\u0000\u0000\u0000\u001c"+
		"\u0080\u0001\u0000\u0000\u0000\u001e\u001f\u0003\u0002\u0001\u0000\u001f"+
		" \u0005\u0000\u0000\u0001 \u0001\u0001\u0000\u0000\u0000!#\u0005\u0003"+
		"\u0000\u0000\"!\u0001\u0000\u0000\u0000\"#\u0001\u0000\u0000\u0000#$\u0001"+
		"\u0000\u0000\u0000$&\u0007\u0000\u0000\u0000%\'\u0003\u001c\u000e\u0000"+
		"&%\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000\'(\u0001\u0000\u0000"+
		"\u0000()\u0005\u0010\u0000\u0000)*\u0003\u0004\u0002\u0000*+\u0005\u0011"+
		"\u0000\u0000+\u0003\u0001\u0000\u0000\u0000,.\u0003\u0006\u0003\u0000"+
		"-/\u0005\u000b\u0000\u0000.-\u0001\u0000\u0000\u0000./\u0001\u0000\u0000"+
		"\u0000/0\u0001\u0000\u0000\u000001\u0003\u0004\u0002\u000013\u0001\u0000"+
		"\u0000\u00002,\u0001\u0000\u0000\u000023\u0001\u0000\u0000\u00003\u0005"+
		"\u0001\u0000\u0000\u00004=\u0003\u0012\t\u00005=\u0003\u000e\u0007\u0000"+
		"6=\u0003\b\u0004\u000078\u0003\u001c\u000e\u000089\u0005\u0014\u0000\u0000"+
		"9:\u0003\u001c\u000e\u0000:=\u0001\u0000\u0000\u0000;=\u0003\u0018\f\u0000"+
		"<4\u0001\u0000\u0000\u0000<5\u0001\u0000\u0000\u0000<6\u0001\u0000\u0000"+
		"\u0000<7\u0001\u0000\u0000\u0000<;\u0001\u0000\u0000\u0000=\u0007\u0001"+
		"\u0000\u0000\u0000>?\u0007\u0001\u0000\u0000?@\u0003\n\u0005\u0000@\t"+
		"\u0001\u0000\u0000\u0000AC\u0005\u000e\u0000\u0000BD\u0003\f\u0006\u0000"+
		"CB\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000"+
		"\u0000EG\u0005\u000f\u0000\u0000FH\u0003\n\u0005\u0000GF\u0001\u0000\u0000"+
		"\u0000GH\u0001\u0000\u0000\u0000H\u000b\u0001\u0000\u0000\u0000IJ\u0003"+
		"\u001c\u000e\u0000JK\u0005\u0014\u0000\u0000KM\u0003\u001c\u000e\u0000"+
		"LN\u0007\u0002\u0000\u0000ML\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000"+
		"\u0000NP\u0001\u0000\u0000\u0000OQ\u0003\f\u0006\u0000PO\u0001\u0000\u0000"+
		"\u0000PQ\u0001\u0000\u0000\u0000Q\r\u0001\u0000\u0000\u0000RU\u0003\u0014"+
		"\n\u0000SU\u0003\u0018\f\u0000TR\u0001\u0000\u0000\u0000TS\u0001\u0000"+
		"\u0000\u0000UV\u0001\u0000\u0000\u0000VX\u0003\u0010\b\u0000WY\u0003\n"+
		"\u0005\u0000XW\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000Y\u000f"+
		"\u0001\u0000\u0000\u0000Z]\u0003\u001a\r\u0000[^\u0003\u0014\n\u0000\\"+
		"^\u0003\u0018\f\u0000][\u0001\u0000\u0000\u0000]\\\u0001\u0000\u0000\u0000"+
		"^`\u0001\u0000\u0000\u0000_a\u0003\u0010\b\u0000`_\u0001\u0000\u0000\u0000"+
		"`a\u0001\u0000\u0000\u0000a\u0011\u0001\u0000\u0000\u0000bd\u0003\u0014"+
		"\n\u0000ce\u0003\n\u0005\u0000dc\u0001\u0000\u0000\u0000de\u0001\u0000"+
		"\u0000\u0000e\u0013\u0001\u0000\u0000\u0000fh\u0003\u001c\u000e\u0000"+
		"gi\u0003\u0016\u000b\u0000hg\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000"+
		"\u0000i\u0015\u0001\u0000\u0000\u0000jk\u0005\f\u0000\u0000kn\u0003\u001c"+
		"\u000e\u0000lm\u0005\f\u0000\u0000mo\u0005\u0019\u0000\u0000nl\u0001\u0000"+
		"\u0000\u0000no\u0001\u0000\u0000\u0000os\u0001\u0000\u0000\u0000pq\u0005"+
		"\f\u0000\u0000qs\u0005\u0019\u0000\u0000rj\u0001\u0000\u0000\u0000rp\u0001"+
		"\u0000\u0000\u0000s\u0017\u0001\u0000\u0000\u0000tv\u0005\u0004\u0000"+
		"\u0000uw\u0003\u001c\u000e\u0000vu\u0001\u0000\u0000\u0000vw\u0001\u0000"+
		"\u0000\u0000wy\u0001\u0000\u0000\u0000xt\u0001\u0000\u0000\u0000xy\u0001"+
		"\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z{\u0005\u0010\u0000\u0000"+
		"{|\u0003\u0004\u0002\u0000|}\u0005\u0011\u0000\u0000}\u0019\u0001\u0000"+
		"\u0000\u0000~\u007f\u0007\u0003\u0000\u0000\u007f\u001b\u0001\u0000\u0000"+
		"\u0000\u0080\u0081\u0007\u0004\u0000\u0000\u0081\u001d\u0001\u0000\u0000"+
		"\u0000\u0013\"&.2<CGMPTX]`dhnrvx";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}