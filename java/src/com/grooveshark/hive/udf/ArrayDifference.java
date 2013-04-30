package com.grooveshark.hive.udf;
import org.apache.hadoop.hive.ql.exec.UDF;
import java.util.ArrayList;

public class ArrayDifference extends UDF
{
    /**
     * Calculates count(A - B)
     * An item from A is counted, if and if only B does not contain that item.
     */
    public Long evaluate(ArrayList<String> A, ArrayList<String> B) {
       if (B == null || B.size() == 0) {
           if (A == null) {
               return new Long(0);
           } else {
               return new Long(A.size());
           }
       }
       long count = 0;
       for(String i1: A) {
           if (!B.contains(i1)) {
               count++;
           }
       }
       return count;
    }
}
