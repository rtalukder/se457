import javax.ws.rs.*;
import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class: SE457 - HW4
 * Author: Raquib Talukder
 **/

@Path("/v1/quotes")
public class QuoteService {
    Map<Integer, QuoteObject> quoteDict = new HashMap<Integer, QuoteObject>() {
        {
            put (0, new QuoteObject(0, "Some say he knows two facts about ducks, and both of them are wrong. All we know is he's called the Stig. -Jeremy Clarkson"));
            put (1, new QuoteObject(1, "Stay hungry, stay foolish. -Steve Jobs"));
            put (2, new QuoteObject(2, "Puns are the highest form of literature. -Alfred Hitchcock"));
            put (3, new QuoteObject(3, "Some say that he invented the curtain. All we know is he's called the Stig. -Jeremy Clarkson"));
            put (4, new QuoteObject(4, "Talk is cheap. Show me the code. -Linus Torvalds"));
        }
    };

    int counter = 0;

    // Gets all quotes that have been added to the service,
    // ordered by identifier
    @GET
    @Path("/getQuotes")
    public List<QuoteObject> getAllQuotes(){
        List<QuoteObject> quoteObjects = new ArrayList<>(quoteDict.values());
        return quoteObjects;
    }

    // Get a single quote by its identifier
    @GET
    @Path("/getQuotes/{id}")
    public QuoteObject getQuoteById(int id){
        QuoteObject quoteObject = quoteDict.get(id);
        return quoteObject;
    }

    // Adds a quote and returns the quote identifier
    @POST
    @Path("/addQuotes/{quote}")
    public int addQuote(String quote){
        QuoteObject quoteObject = new QuoteObject(counter, quote);
        quoteDict.put(quoteObject.getId(), quoteObject);
        counter++;
        return counter - 1;
    }

    // Replace a quote with a given identifier with a new quote
    @PUT
    @Path("/updateQuotes/{id}/quote/{quote}")
    public QuoteObject updateQuote(int id, QuoteObject newQuote){
        String newQuoteString = newQuote.getQuote();
        QuoteObject newQuoteObject = new QuoteObject(id, newQuoteString);
        quoteDict.replace(id, newQuoteObject);
        return newQuoteObject;
    }

    @DELETE
    @Path("/deleteQuotes/{id}")
    // Delete the quote with the given identifier.
    public Response deleteQuote(int id){
        quoteDict.remove(id);
        return null;
    }
}
