 <h1 align="center">Kafka-for-java-developers</h1>

<p align="center">
    <img src="assets/logo.png">
</p>

---

# 💻 About the project

• What is Apache Kafka?
Apache Kafka is an open source software platform for message stream processing written in Scala with Java. Among the advantages of the platform, we can emphasize its way of unifying its components and external Plugins, low latency and high throughput, approaching the real-time data feed.
## Concepts

• Messages – Understand by messages all the information that travels over Apache Kafka, be it a phrase, a word, an array of bytes, etc.

• Streaming – Streaming applied on this platform is the entire flow of a message until the capture by Apache Kafka and the consumption of this message, where we have the   following scenario: Actor -> Action -> Generates x messages, that is, a request flow for example: Cashier->Creation->Order and from this flow there can be a series of messages.

• Topic – A topic is a way of labeling or categorizing a message, imagine a closet with 10 drawers, each drawer can be a topic and the closet is the Apache Kafka platform, so in addition to categorizing it groups messages, another better analogy about the topic would be tables in relational databases.

• Producer – The producer or producer is the person who connects to a messaging platform and sends one or more messages to a specific topic.

• Consumer – The consumer or consumer is the person who connects to a messaging platform and consumes one or more messages from a specific topic.

• Broker – The concept of broker in Kafka's platform is nothing more than practically Kafka himself, he is the one who manages the topics, defines the way of storing messages, logs etc.

• Cluster – The concept of cluster is nothing more than a set of Brokers that communicate with each other or not for better scalability and fault tolerance.

• Log file – Each topic stores its records in a log format, that is, in a structured and sequential way, the log file is therefore the files that contain the information of a topic.

• Partitions – The partitions or partitions as the name said is the partition layer of messages within a topic, this partitioning guarantees the elasticity, fault tolerance and scalability of Apache Kafka, so each topic can have several partitions in different locations.

• Replicas – Replicas are like partitions of partitions, they have the same role as the partition but as a form of redundancy for a given partition, so Kafka partitions are highly available and replicated, when stream data is persisted in Kafka, it becomes available even if the app crashes.

• Segments – The segments are inside the partitions and segment the information contained in the log files of that partition, every topic has its partition and its segmentation, the segmentation serves to manage the ordering of the log file information as well as the time it will be persisted.

---
    
## 🦸 Author

<a href="#">
 <img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/50157211?s=120&v=4" width="100px;" alt=""/>
<br />

Made by Douglas Souza 👋🏽 Get in touch!

[![Linkedin Badge](https://img.shields.io/badge/-Douglas-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/dagurasujava/)](https://www.linkedin.com/in/dagurasujava/) 
[![Gmail Badge](https://img.shields.io/badge/-contini.ds@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:contini.ds@gmail.com)](mailto:contini.ds@gmail.com)

---
## README versions

[English 🇺🇸](./README.md)