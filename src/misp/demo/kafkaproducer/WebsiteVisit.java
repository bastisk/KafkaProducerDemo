/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misp.demo.kafkaproducer;

import java.util.Date;
import java.util.Random;

/**
 *
 * @author basti
 */
public class WebsiteVisit {
    private String ip;
    private String message;
    private final Random rnd;
    
    //Constructor to initialize Randomizer
    public WebsiteVisit(){
        this.rnd = new Random();
        this.ip = "";
        this.message = "";
    }
    
    //Create Demo Data - in this case a website visit by an IP
    public void generate(){
        long runtime = new Date().getTime();
        //set variables...
        this.ip = "192.168.2." + this.rnd.nextInt(255);
        this.message = runtime + ",www.example.com," + this.ip;
    }
    
    public String getIP(){
        return this.ip;
    }
    
    public String getMessage(){
        return this.message;
    }
    
}
