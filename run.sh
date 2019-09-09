#mvn clean install
#--conf "spark.driver.extraJavaOptions=-Dlog4j.configuration=file:/home/knoldus/Desktop/Work/rccl/ssh-timestamp-consumer/log4j.properties" \
#--conf "spark.executor.extraJavaOptions=-Dlog4j.configuration=file:/home/knoldus/Desktop/Work/rccl/ssh-timestamp-consumer/log4j.properties" \

/home/knoldus/Downloads/spark-2.3.3-bin-hadoop2.7/bin/spark-submit \
--class com.knoldus.StreamsProcessor \
target/kafka-spark-streaming-1.0-SNAPSHOT.jar \
"localhost:9092" \
"test2" \
"2019-07-31 04:03:34"  \
"2019-07-31 05:34:53"