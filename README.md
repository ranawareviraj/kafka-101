# kafka-101

Build steps:
1. Clone the repository: `git clone https://github.com/ranawareviraj/kafka-101.git`

2. Start the Kafka and Zookeeper
   - Start ZooKeeper: `bin/zookeeper-server-start.sh config/zookeeper.properties`
   - Start Kafka: `bin/kafka-server-start.sh config/server.properties`

3. Create a topic `bin/kafka-topics.sh --create --topic first-topic --bootstrap-server localhost:9092`

4. Watch Kafka producer and consumer in action
   - Start a producer console: `bin/kafka-topics.sh --describe --topic first-topic --bootstrap-server localhost:9092`
   - Start a consumer console: `bin/kafka-console-consumer.sh --topic first-topic --from-beginning --bootstrap-server localhost:9092`

5. Start the Spring Boot application
   - Run the Spring Boot application: `mvn spring-boot:run`