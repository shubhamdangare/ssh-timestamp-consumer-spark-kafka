# SSH Ship Consumer On Timestamp

This Application help us to get count of message for topic in given time intervals

## Getting Started

Running the Job in Local

step 1) Clone repo 

    git clone 
    

    
step 2) Set Arguments in run.sh 

    1. Bootstart server
    2. Topic name
    3. Starting Time Interval
    4. Ending Time Interval 
    
Example 

    ```
    --class com.knoldus.StreamsProcessor   target/scala-2.11/stream-app_2.11-0.1.jar "10.17.22.77:9092,10.17.22.92:9092,10.17.22.93:9092" "ga-profile-bookings-a-shore-topic-v2" "2019-07-30 22:33:46" "2019-07-30 22:34:53"
    ```

step 3) cd to the cloned repo and run the script
    
        ./run.sh

 
 

### To Run this for multiple topic 
    
    1) Submit different spark Job by changing topic name and runing script again

