# mqtt-2-kafka

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .
## Starting Apache ActiveMQ locally
You can start Apache ActiveMQ broker locally via docker using the ArtemisCloud container image:

```shell script
docker run -it --rm -p 8161:8161 -p 61616:61616 -p 5672:5672 -e AMQ_USER=quarkus -e AMQ_PASSWORD=quarkus quay.io/artemiscloud/activemq-artemis-broker
```

> **_NOTE:_** We don't have to create the Queue, it will be created by the Camel Consumer if it doesn't exist

## Starting Kafka locally
For dev mode we are using the dev services Kafka. Quakus will detect we are not connected to any Kafka broker and will automatically provision a Kafka for us.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can start a Docker image locally for Kafka
```shell script
docker run -it --rm --name redpanda -p 9092:9092 vectorized/redpanda
```

You can then execute your native executable with: `./target/mqtt-2-kafka-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- Camel Kafka ([guide](https://camel.apache.org/camel-quarkus/latest/reference/extensions/kafka.html)): Sent and receive messages to/from an Apache Kafka broker
- Camel Paho ([guide](https://camel.apache.org/camel-quarkus/latest/reference/extensions/paho.html)): Communicate with MQTT message brokers using Eclipse Paho MQTT Client
