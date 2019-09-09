# SSH Ship Consumer On Timestamp

This Application help us to get count of message for topic in given time intervals

## Getting Started

Running the Job in Local

step 1) Clone repo 

    git clone https://github.com/shubhamdangare/ssh-timestamp-consumer-spark-kafka.git
    

    
step 2) Set Arguments in run.sh 

    1. Bootstart server
    2. Topic name
    3. Starting Time Interval
    4. Ending Time Interval 
    
Example 

    ```
    --class com.knoldus.StreamsProcessor   target/scala-2.11/stream-app_2.11-0.1.jar 
    ```

step 3) cd to the cloned repo and run the script
    
        ./run.sh

 
 

### To Run this for multiple topic 
    
    1) Submit different spark Job by changing topic name and runing script again

