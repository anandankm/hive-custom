package com.grooveshark.hive.udf;

import java.util.TreeMap;

public class Test
{
    public static void main(String[] args) {
        TreeMap<String, String> map = new TreeMap<String, String>();
        map.put("yes", "no");
        map.put("string", "integer");
        MapToString ms = new MapToString();
        String value = ms.evaluate(map);
        System.out.println("Result: " + value);

    }
}
