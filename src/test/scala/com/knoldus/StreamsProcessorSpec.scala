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

  "Spark Kafka TimeStamp Integration Testing" should "Get the count in between interval" in {

    StreamsProcessor.getMessageCountForGivenInterval(spark, Array("localhost:9092", "test2", "2019-7-31 04:03:34", "2018-8-28 04:03:34"), false)

  }

  after {

    spark.stop()
  }


}
