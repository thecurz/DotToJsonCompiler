package com.compiler;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class EdgeListener extends ExprParserBaseListener {
  private final String DEFAULT_NULL_WEIGHT_VALUE = "0";

  private Map<String, List<Object[]>> tupleMap = new HashMap<>();

  private static void addTuple(Map<String, List<Object[]>> map, String key, Object[] tuple) {
    map.computeIfAbsent(key, k -> new ArrayList<>()).add(tuple);
  }

  public void printTupleMap() {
    for (Map.Entry<String, List<Object[]>> entry : tupleMap.entrySet()) {
      String key = entry.getKey();
      List<Object[]> tuples = entry.getValue();

      System.out.println("Key: " + key);

      for (Object[] tuple : tuples) {
        String target = (String) tuple[0];
        String valueStr = (String) tuple[1];
        try {
          int value = Integer.parseInt(valueStr);
          System.out.println("  Tuple: " + target + ", " + value);
        } catch (NumberFormatException e) {
          System.err.println("Invalid integer value for tuple: " + target + ", " + valueStr);
        }
      }
    }
  }

  @Override
  public void enterEdgeStmt(ExprParser.EdgeStmtContext ctx) {
    String source = ctx.edge_stmt().node_id().id().getText();
    String edge = ctx.edge_stmt().edgeRHS().node_id().getText();
    String weight;
    if (ctx.edge_stmt().attr_list() != null && ctx.edge_stmt().attr_list().a_list() != null) {
      weight = ctx.edge_stmt().attr_list().a_list().id(1).getText();
    } else {
      weight = DEFAULT_NULL_WEIGHT_VALUE;
    }
    addTuple(tupleMap, source, new Object[] { edge, weight });
  }

  public Map<String, List<Object[]>> getTupleMap() {
    return tupleMap;
  }
}
