package com.compiler;

// import org.antlr.v4.runtime.tree.ParseTree;
// import org.antlr.v4.runtime.tree.TerminalNode;
// import java.lang.reflect.Field;
// import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class ToJSONListener extends ExprParserBaseListener {
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
        // int value = (int) tuple[1];
        String valueStr = (String) tuple[1];
        int value = Integer.parseInt(valueStr);
        System.out.println("  Tuple: " + target + ", " + value);
      }
    }
  }

  public String convertTupleMapToJson() {
    StringBuilder jsonBuilder = new StringBuilder("{");

    boolean firstKey = true;
    for (Map.Entry<String, List<Object[]>> entry : tupleMap.entrySet()) {
      if (!firstKey) {
        jsonBuilder.append(",");
      } else {
        firstKey = false;
      }

      String key = entry.getKey();
      List<Object[]> tuples = entry.getValue();

      jsonBuilder.append("\"").append(key).append("\":[");

      boolean firstTuple = true;
      for (Object[] tuple : tuples) {
        if (!firstTuple) {
          jsonBuilder.append(",");
        } else {
          firstTuple = false;
        }

        String target = (String) tuple[0];
        int value = Integer.parseInt(tuple[1].toString());

        jsonBuilder.append("[\"").append(target).append("\", ").append(value).append("]");
      }

      jsonBuilder.append("]");
    }

    jsonBuilder.append("}");

    return jsonBuilder.toString();
  }

  @Override
  public void enterEdge_stmt(ExprParser.Edge_stmtContext ctx) {
    String source = ctx.node_id().id().getText();
    String edge = ctx.edgeRHS().node_id().getText();
    String weight;
    if (ctx.attr_list() != null && ctx.attr_list().a_list() != null) {
      weight = ctx.attr_list().a_list().id(1).getText();
    } else {
      weight = "0";
    }
    // System.out.println("Source: " + source);
    // System.out.println("EDGE:" + ctx.edgeRHS().node_id().getText());
    // System.out.println("attr:" + ctx.attr_list().a_list().ID(1));
    addTuple(tupleMap, source, new Object[] { edge, weight });
    // Class<?> myClass = ctx.attr_list().a_list().ID().getClass();
    // Get all declared fields (variables) of the class
    // Field[] fields = myClass.getDeclaredFields();
    // System.out.println("Fields:");
    // for (Field field : fields) {
    // System.out.println(field.getName());
    // }
    //
    // // Get all declared methods of the class
    // Method[] methods = myClass.getDeclaredMethods();
    // System.out.println("\nMethods:");
    // for (Method method : methods) {
    // System.out.println(method.getName());
    // }
    // edges.add(edgeJson);
  }
}
