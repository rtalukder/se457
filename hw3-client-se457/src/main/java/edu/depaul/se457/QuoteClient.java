package edu.depaul.se457;

/**
 * Class: SESE457 - HW3
 * Author: Raquib Talukder
 **/

public class QuoteClient {
    public static void main(String[] args) {
        QuoteServiceService quoteService = new QuoteServiceService();
        QuoteService quote = quoteService.getQuoteServicePort();

        String quoteRecv = quote.getQuote();
        System.out.println(quoteRecv);

        quote.addQuote("hello, world");
    }
}
