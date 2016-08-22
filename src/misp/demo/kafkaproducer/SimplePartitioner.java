/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misp.demo.kafkaproducer;

import kafka.producer.Partitioner;
import kafka.utils.VerifiableProperties;

/**
 *
 * @author basti
 */
public class SimplePartitioner implements Partitioner {
    
    public SimplePartitioner (VerifiableProperties props){
        
    }

    public int partition(Object key, int a_numPartitions){
        int partition = 0;
        String stringKey = (String) key;
        int offset = stringKey.lastIndexOf('.');
        if(offset > 0){
            partition = Integer.parseInt(stringKey.substring(offset + 1)) % a_numPartitions;
        }
        return partition;
    }
    
}
