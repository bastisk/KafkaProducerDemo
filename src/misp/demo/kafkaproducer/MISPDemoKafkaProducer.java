/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misp.demo.kafkaproducer;
import java.util.Properties;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

/**
 *
 * @author basti
 */
public class MISPDemoKafkaProducer {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {    
        //get command line parameters
        long events = Long.parseLong(args[0]);
        String serverlist = args[1];
                   
        //Create Properties
        Properties props = new Properties();
        props.put("metadata.broker.list", serverlist);
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("partitioner.class","misp.demo.kafkaproducer.SimplePartitioner"); //MISP-Demo.KafkaProducer.
        props.put("request.required.acks", "1");

        //Create config for producer
        ProducerConfig config = new ProducerConfig(props);

        //Create producer object
        Producer<String, String> producer = new Producer<>(config);

        WebsiteVisit visit = new WebsiteVisit();

        //send specified amount of data
        for(long i = 0; i < events; i++){
            visit.generate();
            KeyedMessage<String, String> data = new KeyedMessage<>("page_visits", visit.getIP(), visit.getMessage());
            producer.send(data);
        }
        producer.close();

    }
}

