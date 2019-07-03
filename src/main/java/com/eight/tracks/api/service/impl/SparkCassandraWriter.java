package com.eight.tracks.api.service.impl;

import com.datastax.driver.core.Row;
import com.datastax.spark.connector.japi.CassandraJavaUtil;
import com.datastax.spark.connector.japi.SparkContextJavaFunctions;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.SparkSession;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
public class SparkCassandraWriter {

  private SparkConf sparkConf;
  private SparkSession spark;
  protected Dataset<Row> orderRow;


  public static final String SPARK_CASSANDRA_HOST_CONF="spark.cassandra.connection.host";
  public static final String SPARK_CASSANDRA_USER_CONF="spark.cassandra.auth.username";
  public static final String SPARK_CASSANDRA_PASS_CONF="spark.cassandra.auth.password";


  public void writeToPopularTracks() {

    sparkConf.set("spark.cassandra.connection.host", "localhost");
    sparkConf.set("spark.cassandra.output.consistency.level", "LOCAL_QUORUM");
    JavaSparkContext sc = new JavaSparkContext(sparkConf);
    spark = SparkSession.builder().config(sparkConf).enableHiveSupport().getOrCreate();
    SparkContextJavaFunctions functions = CassandraJavaUtil.javaFunctions(sc);


    //Implement spark job to read from the tracks metadata and write to popular tracks table
    //The job will aggregate data based on likes ,number of plays etc and sort the data accordingly and display the results
    //on landing page.
   }

}
