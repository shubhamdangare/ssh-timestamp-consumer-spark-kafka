package com.knoldus

import org.apache.spark.sql.SparkSession
import org.scalatest.{BeforeAndAfter, FlatSpec}

class StreamsProcessorSpec extends FlatSpec with BeforeAndAfter {
  var spark: SparkSession = _

  before {
    spark = SparkSession
      .builder
      .appName("Spark-Kafka-Integration-ToCount-TimeStampInBetween")
      .master("local")
      .getOrCreate()

  }

  "Spark Kafka TimeStamp count" should " Get the count in between interval" in {
    import org.apache.spark.sql.functions._

    val dfReadStream = spark
      .readStream
      .format("kafka")
      .option("kafka.bootstrap.servers", "localhost:9093")
      .option("subscribe", "test2")
      .option("startingOffsets", "earliest")
      .option("enable.auto.commit", "false")
      .load()
      .selectExpr("timestamp")
      .filter(col("timestamp").geq(lit("2019-7-31 04:03:34")) && col("timestamp").leq(lit("2018-8-28 04:03:34")))
      .toDF("TimeStampInBetweenCalculate")

    dfReadStream.createOrReplaceTempView("TimeStampInBetweenCalculated")
    val wordCountsDataFrame =
      spark.sql("select count(*) as total from TimeStampInBetweenCalculated HAVING COUNT(*)>1")

    val dfWriteStream = wordCountsDataFrame
      .withColumn("SparkBatchCompletedAt", lit(current_timestamp()))
      .writeStream
      .format("console")
      .outputMode("complete")
      .start()

    dfWriteStream.stop()

  }

  after {

    spark.stop()
  }


}
