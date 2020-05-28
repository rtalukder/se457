package edu.depaul.se457;

/**
 * Class: SE457 - HW4
 * Author: Raquib Talukder
 **/

public class QuoteObject {
    int id;
    String quote;

    public QuoteObject(int id, String quote){
        this.id = id;
        this.quote = quote;
    }

    public String getQuote(){
        return quote;
    }

    public Integer getId(){
        return id;
    }
}
