package com.grooveshark.hive.udf;
import org.apache.hadoop.hive.ql.exec.UDF;
import java.util.TreeMap;
import java.util.Map;

public class MapRemove extends UDF
{
    /**
     * Removes the given key and orders the keys lexicographically.
     */
    public Map<String, String> evaluate(Map<String, String> map, String... remKeys) {
       if(map == null) {
           return null;
       }
       for(String remKey : remKeys) {
           if (map.containsKey(remKey)) {
               map.remove(remKey);
           }
       }
       TreeMap<String, String> result = new TreeMap<String, String>(map);
       return result;
    }
}
