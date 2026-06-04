// Common interface representing an abstract network packet format
interface NetworkPacket { }

/*
In modern microservice architectures, a virtualization proxy rarely speaks just one protocol. It often acts as a bridge or translator between different system architectures—for instance,
accepting an inbound HTTP/JSON Rest Request and translating it into a downstream gRPC/Protocol Buffers call, or converting an AMQP (RabbitMQ) Message into an Apache Kafka Event.
*/

// Concrete definitions of distinct protocol payload types
class JsonRestPacket implements NetworkPacket {}
class GrpcProtoPacket implements NetworkPacket {}
class KafkaEventPacket implements NetworkPacket {}

public class ProtocolTransformationEngine 
{
     // THE SMELLY METHOD: Hardcoding combinations of packet conversions
     public NetworkPacket transformPayload(NetworkPacket inbound, NetworkPacket outboundSchema)
     {
          // Case 1: REST API Client calling a gRPC Downstream Service
          if (inbound instanceof JsonRestPacket && outboundSchema instanceof GrpcProtoPacket)
          {
               System.out.println("Translating JSON REST Payload into Binary gRPC Protobuf...");
               /* Complex Logic: Parse JSON strings, map keys to proto fields, serialize to bytes */
               return new GrpcProtoPacket();
          }
          
          // Case 2: gRPC Service publishing an asynchronous event to a Kafka Cluster
          if (inbound instanceof GrpcProtoPacket && outboundSchema instanceof KafkaEventPacket)
          {
               System.out.println("Translating gRPC Binary payload into a Kafka Event stream record...");
               /* Complex Logic: Deserialize proto bytes, format into Kafka record bytes with partition keys */
               return new KafkaEventPacket();
          }
          
          // Case 3: A JSON REST Gateway proxying directly to a Kafka Topic
          if (inbound instanceof JsonRestPacket && outboundSchema instanceof KafkaEventPacket)
          {
               System.out.println("Translating JSON REST Payload into Kafka Event message payload...");
               /* Complex Logic: Map HTTP headers to Kafka record headers, string to byte conversion */
               return new KafkaEventPacket();
          }

          throw new IllegalArgumentException("Unsupported protocol transformation pair.");
     }
}
