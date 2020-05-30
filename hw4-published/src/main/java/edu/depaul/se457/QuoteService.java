package edu.depaul.se457;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.Produces;
import java.util.*;

/**
 * Class: SE457 - HW4
 * Author: Raquib Talukder
 **/

@Path("/v1/quotes")
public class QuoteService {
    // quote objects will be saved into a hashmap
    // pre-seeding the hashmap with the five initial quotes
    static Map<Integer, QuoteObject> quoteDict = new HashMap<Integer, QuoteObject>() {
        {
            put (1, new QuoteObject(1, "Some say he knows two facts about ducks, and both of them are wrong. All we know is he's called the Stig. -Jeremy Clarkson"));
            put (2, new QuoteObject(2, "Stay hungry, stay foolish. -Steve Jobs"));
            put (3, new QuoteObject(3, "Puns are the highest form of literature. -Alfred Hitchcock"));
            put (4, new QuoteObject(4, "Some say that he invented the curtain. All we know is he's called the Stig. -Jeremy Clarkson"));
            put (5, new QuoteObject(5, "Talk is cheap. Show me the code. -Linus Torvalds"));
        }
    };

    // counter to keep track of IDs when new quotes are added. started at 6 because of the pre-seeded quotes
    static int instanceCounter = 6;

    // Gets all quotes that have been added to the service
    // optional parameters to paginate the list of quotes returned
    @GET
    @Path("/getQuotes")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllQuotes(@DefaultValue("-1") @QueryParam("pageStart") int pageStart,
                                 @DefaultValue("-1") @QueryParam("pagesSize") int pagesSize){
        List<QuoteObject> quoteObjects = new ArrayList<>(quoteDict.values());

        // user has dictated that results should be paginated
        if (pageStart != -1 && pagesSize != -1) {
            // check if 0 or negative pageStart or pagesSize
            // return 400 status code and message
            if(pagesSize <= 0 || pageStart <= 0) {
                return Response
                        .status(400)
                        .entity("<=0 page size and/or page start")
                        .build();
            }

            int fromIndex = (pageStart - 1) * pagesSize;
            // check if quoteObjects list is null or if index slice will return out of bounds error
            // return 400 status code and empty list
            if(quoteObjects == null || quoteObjects.size() < fromIndex) {
                return Response
                        .status(400)
                        .entity(Collections.emptyList())
                        .build();
            }

            // if list is able to be parsed with user pagination requirements
            // create a sublist of all the quotes
            // return 200 status code and a sublist of all the quotes
            return Response
                    .status(200)
                    .entity(quoteObjects.subList(fromIndex, Math.min(fromIndex + pagesSize, quoteObjects.size())))
                    .build();
        }
        // if pagination query parameters are not present
        // return 200 status code and all the quotes in the list
        else {
            return Response
                    .status(200)
                    .entity(quoteObjects)
                    .build();
        }
    }

    // Get a single quote by its identifier
    @GET
    @Path("/getQuotes/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getQuoteById(@PathParam("id") int id){
        // get the quoteObject from the hashmap
        QuoteObject quoteObject = quoteDict.get(id);
        // if not null
        // return status 200 code and the quoteObject
        // the quoteObject includes the identifier and the quote
        if(quoteObject != null){
            return Response
                    .status(200)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .entity(quoteObject)
                    .build();
        }
        // if the quoteObject is null from the hashmap
        // return status 400 and a message
        else {
            return Response
                    .status(400)
                    .entity("Object not found")
                    .build();
        }
    }

    // Adds a quote and returns the quote identifier
    @POST
    @Path("/addQuotes/{quote}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addQuote(@PathParam("quote") String quote){
        // take user input quote string and create a new quote object
        // ID is assigned from static instanceCounter variable
        QuoteObject quoteObject = new QuoteObject(instanceCounter, quote);
        // add the new quoteObject to the hashmap
        quoteDict.put(quoteObject.getId(), quoteObject);
        // increment the instanceCounter
        instanceCounter++;
        // return status 200 and the quoteObject created
        // the quoteObject includes the identifier and the quote
        return Response
                .status(200)
                .entity(quoteObject)
                .build();
    }

    // Replace a quote with a given identifier with a new quote
    @PUT
    @Path("/updateQuotes/{id}/quote/{newQuote}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateQuote(@PathParam("id") int id, @PathParam("newQuote") String newQuote){
        // get the quoteObject from the hashmap
        QuoteObject quoteObject = quoteDict.get(id);
        // if not null take in user parameters and create new quoteObject
        // replace hashmap at id key value with the new quote object
        // return status 200 code and the updated quoteObject
        // the quoteObject includes the identifier and the quote
        if (quoteObject != null) {
            QuoteObject newQuoteObject = new QuoteObject(id, newQuote);
            quoteDict.replace(id, newQuoteObject);
            return Response
                    .status(200)
                    .entity(newQuoteObject)
                    .build();
        }
        // if the quoteObject is null from the hashmap
        // return status 400 and a message
        else {
            return Response
                    .status(400)
                    .entity("Object not found")
                    .build();
        }
    }

    // Delete the quote with the given identifier.
    @DELETE
    @Path("/deleteQuotes/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteQuote(@PathParam("id") int id){
        // get the quoteObject from the hashmap
        QuoteObject removedQuote = quoteDict.get(id);
        // if not null remove the quote from the hashmap with the given id
        // return status 200 code and the removed quoteObject
        // the quoteObject includes the identifier and the quote
        if (removedQuote != null) {
            quoteDict.remove(id);
            return Response
                    .status(200)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .entity(removedQuote)
                    .build();
        }
        // if the quoteObject is null from the hashmap
        // return status 400 and a message
        else {
            return Response
                    .status(400)
                    .entity("Object not found")
                    .build();
        }
    }
}
