package com.grooveshark.hive.udf;
import org.apache.hadoop.hive.ql.exec.UDF;

public final class Rank extends UDF
{
    private long counter;
    private long last_key;
    /**
     * Keeps a counter if the last key was the same as the current key 
     */
    public long evaluate(final long key) {
       if(key != this.last_key) {
           this.counter = 1;
           this.last_key = key;
       }
       return this.counter++;
    }
}
