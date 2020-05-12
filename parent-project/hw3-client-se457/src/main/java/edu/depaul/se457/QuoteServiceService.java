
package edu.depaul.se457;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "QuoteServiceService", targetNamespace = "http://se457.depaul.edu/", wsdlLocation = "http://localhost:8888/quotes?wsdl")
public class QuoteServiceService
    extends Service
{

    private final static URL QUOTESERVICESERVICE_WSDL_LOCATION;
    private final static WebServiceException QUOTESERVICESERVICE_EXCEPTION;
    private final static QName QUOTESERVICESERVICE_QNAME = new QName("http://se457.depaul.edu/", "QuoteServiceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8888/quotes?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        QUOTESERVICESERVICE_WSDL_LOCATION = url;
        QUOTESERVICESERVICE_EXCEPTION = e;
    }

    public QuoteServiceService() {
        super(__getWsdlLocation(), QUOTESERVICESERVICE_QNAME);
    }

    public QuoteServiceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), QUOTESERVICESERVICE_QNAME, features);
    }

    public QuoteServiceService(URL wsdlLocation) {
        super(wsdlLocation, QUOTESERVICESERVICE_QNAME);
    }

    public QuoteServiceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, QUOTESERVICESERVICE_QNAME, features);
    }

    public QuoteServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public QuoteServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns QuoteService
     */
    @WebEndpoint(name = "QuoteServicePort")
    public QuoteService getQuoteServicePort() {
        return super.getPort(new QName("http://se457.depaul.edu/", "QuoteServicePort"), QuoteService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns QuoteService
     */
    @WebEndpoint(name = "QuoteServicePort")
    public QuoteService getQuoteServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://se457.depaul.edu/", "QuoteServicePort"), QuoteService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (QUOTESERVICESERVICE_EXCEPTION!= null) {
            throw QUOTESERVICESERVICE_EXCEPTION;
        }
        return QUOTESERVICESERVICE_WSDL_LOCATION;
    }

}
