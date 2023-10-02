package com.compiler;

import java.util.List;
import java.util.Map;

public class EdgeDataJsonSerializer {
    public static String convertTupleMapToJson(Map<String, List<Object[]>> tupleMap) {
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
}
