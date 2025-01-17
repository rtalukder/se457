
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
@WebServiceClient(name = "QuoteServiceImplmentationService", targetNamespace = "http://se457.depaul.edu/", wsdlLocation = "http://localhost:8888/quotes?wsdl")
public class QuoteServiceImplmentationService
    extends Service
{

    private final static URL QUOTESERVICEIMPLMENTATIONSERVICE_WSDL_LOCATION;
    private final static WebServiceException QUOTESERVICEIMPLMENTATIONSERVICE_EXCEPTION;
    private final static QName QUOTESERVICEIMPLMENTATIONSERVICE_QNAME = new QName("http://se457.depaul.edu/", "QuoteServiceImplmentationService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8888/quotes?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        QUOTESERVICEIMPLMENTATIONSERVICE_WSDL_LOCATION = url;
        QUOTESERVICEIMPLMENTATIONSERVICE_EXCEPTION = e;
    }

    public QuoteServiceImplmentationService() {
        super(__getWsdlLocation(), QUOTESERVICEIMPLMENTATIONSERVICE_QNAME);
    }

    public QuoteServiceImplmentationService(WebServiceFeature... features) {
        super(__getWsdlLocation(), QUOTESERVICEIMPLMENTATIONSERVICE_QNAME, features);
    }

    public QuoteServiceImplmentationService(URL wsdlLocation) {
        super(wsdlLocation, QUOTESERVICEIMPLMENTATIONSERVICE_QNAME);
    }

    public QuoteServiceImplmentationService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, QUOTESERVICEIMPLMENTATIONSERVICE_QNAME, features);
    }

    public QuoteServiceImplmentationService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public QuoteServiceImplmentationService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns QuoteServiceImplmentation
     */
    @WebEndpoint(name = "QuoteServiceImplmentationPort")
    public QuoteServiceImplmentation getQuoteServiceImplmentationPort() {
        return super.getPort(new QName("http://se457.depaul.edu/", "QuoteServiceImplmentationPort"), QuoteServiceImplmentation.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns QuoteServiceImplmentation
     */
    @WebEndpoint(name = "QuoteServiceImplmentationPort")
    public QuoteServiceImplmentation getQuoteServiceImplmentationPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://se457.depaul.edu/", "QuoteServiceImplmentationPort"), QuoteServiceImplmentation.class, features);
    }

    private static URL __getWsdlLocation() {
        if (QUOTESERVICEIMPLMENTATIONSERVICE_EXCEPTION!= null) {
            throw QUOTESERVICEIMPLMENTATIONSERVICE_EXCEPTION;
        }
        return QUOTESERVICEIMPLMENTATIONSERVICE_WSDL_LOCATION;
    }

}
