package edu.depaul.se457;

import javax.xml.ws.Endpoint;

/**
 * Class: SE457 - HW3
 * Author: Raquib Talukder
 **/

public class QuoteServer {
    public static void main(String[] args) {
        // URI of the server that will be hosting the service
        String serverURI = "http://localhost:8888/quotes";
        // create an instance of the service
        QuoteServiceImplmentation quoteService = new QuoteServiceImplmentation();
        // publish the service for external consumption on the localhost and the QuoteService class
        Endpoint.publish(serverURI, quoteService);

        System.out.println("Server started at " + serverURI);
    }
}
