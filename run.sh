sbt package

/home/knoldus/Downloads/spark-2.3.3-bin-hadoop2.7/bin/spark-submit \
--packages org.apache.spark:spark-sql-kafka-0-10_2.11:2.3.0 \
--class com.knoldus.StreamsProcessor \
target/scala-2.11/stream-app_2.11-0.1.jar \
"localhost:9092" \
"test2" \
"2019-07-30 22:33:46"  \
"2019-07-30 22:34:53"