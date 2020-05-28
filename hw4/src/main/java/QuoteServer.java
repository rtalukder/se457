import javax.xml.ws.Endpoint;

/**
 * Class: SE457 - HW4
 * Author: Raquib Talukder
 **/

public class QuoteServer {
    public static void main(String[] args) {
        // URI of the server that will be hosting the service
        String serverURI = "http://localhost:8888/quotes";




        // create an instance of the service
        QuoteService quoteService = new QuoteService();
//        System.out.println(quoteService.addQuote("Some say he knows two facts about ducks, and both of them are wrong. All we know is he's called the Stig. -Jeremy Clarkson"));
//        System.out.println(quoteService.addQuote("Stay hungry, stay foolish. -Steve Jobs"));
//        System.out.println(quoteService.addQuote("Puns are the highest form of literature. -Alfred Hitchcock"));
//        System.out.println(quoteService.addQuote("Some say that he invented the curtain. All we know is he's called the Stig. -Jeremy Clarkson"));
//        System.out.println(quoteService.addQuote("Talk is cheap. Show me the code. -Linus Torvalds"));
//
//        System.out.println(quoteService.getQuoteById(3));
//        System.out.println(quoteService.updateQuote(3, "this is a new quote"));
//        System.out.println(quoteService.getQuoteById(3));
//        System.out.println(quoteService.deleteQuote(3));
//        System.out.println(quoteService.getQuoteById(3));
//        System.out.println(quoteService.getQuoteById(4));
//        System.out.println(quoteService.getAllQuotes());
//        System.out.println(quoteService.getAllQuotes());

        // publish the service for external consumption on the localhost and the QuoteService class
        //Endpoint.publish(serverURI, quoteService);

        System.out.println("Server started at " + serverURI);
        // System.out.println("Current quotes list size: " + quoteService.quotes.size());
    }
}
