package com.grooveshark.hive.udf;
import org.apache.hadoop.hive.ql.exec.UDF;
import java.util.TreeMap;
import java.util.Map;

public class MapToString extends UDF
{
    /**
     * Orders the tree keys lexicographically and returns a JSON string.
     */
    public String evaluate(Map<String, String> map) {
       if(map == null) {
           return null;
       }
       TreeMap<String, String> resultMap = new TreeMap<String, String>(map);
       StringBuilder result = new StringBuilder("{");
       for(String key: resultMap.keySet()) {
           result.append("\"" + key + "\"");
           result.append(":");
           result.append("\"" + resultMap.get(key) + "\",");
       }
       if (resultMap.size() > 0) {
           result = result.deleteCharAt(result.length() - 1);
       }
       result.append("}");
       return result.toString();
    }
}
