package edu.depaul.se457;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class: SESE457 - HW3
 * Author: Raquib Talukder
 **/

// annotation to declare this function a service
@WebService
public class QuoteServiceImplmentation {

    // array of quotes that will user will receive
    private final ArrayList<String> quotes = new ArrayList<String>(Arrays.asList(
                                                    "Some say he knows two facts about ducks, and both of them are wrong. All we know is he's called the Stig. -Jeremy Clarkson",
                                                    "Some say that he invented the curtain. All we know is he's called the Stig. -Jeremy Clarkson",
                                                    "Stay hungry, stay foolish. -Steve Jobs",
                                                    "Puns are the highest form of literature. -Alfred Hitchcock",
                                                    "Talk is cheap. Show me the code. -Linus Torvalds"));


    // function to return a random quote from the array above
    // annotation to allow clients to invoke the service
    @WebMethod
    public String getQuote(){
        // log that the quote was returned for debugging
        System.out.println("Endpoint invoked, quote returned.");
        // function to randomly return a quote to the user
        return (quotes.get((int) Math.floor(Math.random() * quotes.size())));
    }

    // function to add a quote to the array list
    // annotation to allow clients to invoke the service
    @WebMethod
    public void addQuote(String quote){
        // check if the quote is null or empty
        if (quote == null || quote.trim().equals("")) {
            // log that the quote wasn't added for debugging
            System.out.println("The quote was not added.");
        }
        else {
            // add quote to the array list
            quotes.add(quote);
            // log that the quote was added for debugging
            System.out.println("The quote added.");
        }
        System.out.println(quotes.size());
    }

    public static void main(String[] args) {
        QuoteServiceImplmentation quoteService = new QuoteServiceImplmentation();
        System.out.println(quoteService.getQuote());
        quoteService.addQuote(null);
        quoteService.addQuote("kl");
    }
}

