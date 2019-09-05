package com.knoldus

import org.apache.spark.sql.SparkSession

object StreamsProcessor {
  def main(args: Array[String]): Unit = {

    val spark = SparkSession
      .builder
      .appName("Spark-Kafka-Integration-ToCount-TimeStampInBetween")
      .master("local")
      .getOrCreate()

    import org.apache.spark.sql.functions._

      val dfReadStream = spark
        .readStream
        .format("kafka")
        .option("kafka.bootstrap.servers", args(0))
        .option("subscribe", args(1))
        .option("startingOffsets", "earliest")
        .option("enable.auto.commit", "false")
        .load()
        .selectExpr("timestamp")
        .filter(col("timestamp").geq(lit(args(2))) && col("timestamp").leq(lit(args(3))))
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

      dfWriteStream.awaitTermination()
      spark.stop()

  }
}
