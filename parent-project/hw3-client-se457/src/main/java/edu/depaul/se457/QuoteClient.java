package edu.depaul.se457;

import java.net.MalformedURLException;

/**
 * Class: SESE457 - HW3
 * Author: Raquib Talukder
 **/

public class QuoteClient {
    public static void main(String[] args) throws MalformedURLException {

        // start an instance of the service
        QuoteServiceImplmentationService quoteService = new QuoteServiceImplmentationService();
        // attach the instance of the service to the interface and get a port number
        QuoteServiceImplmentation quoteServiceEndpoint = quoteService.getQuoteServiceImplmentationPort();
        // hit the getQuote endpoint and save it under quoteRecv
        String quoteRecv = quoteServiceEndpoint.getQuote();
        // print the quote received
        System.out.println(quoteRecv);
        // add a quote to the arraylist
        quoteServiceEndpoint.addQuote("hello, world");

    }
}
