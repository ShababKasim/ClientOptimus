
package com.samaylabs.optimus.webservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.samaylabs.optimus.webservices package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetOptimusLogsDatedResponse_QNAME = new QName("http://WebServices.optimus.samaylabs.com/", "getOptimusLogsDatedResponse");
    private final static QName _GetUsers_QNAME = new QName("http://WebServices.optimus.samaylabs.com/", "getUsers");
    private final static QName _GetOptimusLogsDated_QNAME = new QName("http://WebServices.optimus.samaylabs.com/", "getOptimusLogsDated");
    private final static QName _GetUsersResponse_QNAME = new QName("http://WebServices.optimus.samaylabs.com/", "getUsersResponse");
    private final static QName _GetOptimusLogsResponse_QNAME = new QName("http://WebServices.optimus.samaylabs.com/", "getOptimusLogsResponse");
    private final static QName _GetOptimusLogs_QNAME = new QName("http://WebServices.optimus.samaylabs.com/", "getOptimusLogs");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.samaylabs.optimus.webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetOptimusLogsDated }
     * 
     */
    public GetOptimusLogsDated createGetOptimusLogsDated() {
        return new GetOptimusLogsDated();
    }

    /**
     * Create an instance of {@link GetOptimusLogsDatedResponse }
     * 
     */
    public GetOptimusLogsDatedResponse createGetOptimusLogsDatedResponse() {
        return new GetOptimusLogsDatedResponse();
    }

    /**
     * Create an instance of {@link GetUsers }
     * 
     */
    public GetUsers createGetUsers() {
        return new GetUsers();
    }

    /**
     * Create an instance of {@link GetOptimusLogsResponse }
     * 
     */
    public GetOptimusLogsResponse createGetOptimusLogsResponse() {
        return new GetOptimusLogsResponse();
    }

    /**
     * Create an instance of {@link GetOptimusLogs }
     * 
     */
    public GetOptimusLogs createGetOptimusLogs() {
        return new GetOptimusLogs();
    }

    /**
     * Create an instance of {@link GetUsersResponse }
     * 
     */
    public GetUsersResponse createGetUsersResponse() {
        return new GetUsersResponse();
    }

    /**
     * Create an instance of {@link ListWrapper }
     * 
     */
    public ListWrapper createListWrapper() {
        return new ListWrapper();
    }

    /**
     * Create an instance of {@link Logs }
     * 
     */
    public Logs createLogs() {
        return new Logs();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOptimusLogsDatedResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices.optimus.samaylabs.com/", name = "getOptimusLogsDatedResponse")
    public JAXBElement<GetOptimusLogsDatedResponse> createGetOptimusLogsDatedResponse(GetOptimusLogsDatedResponse value) {
        return new JAXBElement<GetOptimusLogsDatedResponse>(_GetOptimusLogsDatedResponse_QNAME, GetOptimusLogsDatedResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUsers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices.optimus.samaylabs.com/", name = "getUsers")
    public JAXBElement<GetUsers> createGetUsers(GetUsers value) {
        return new JAXBElement<GetUsers>(_GetUsers_QNAME, GetUsers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOptimusLogsDated }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices.optimus.samaylabs.com/", name = "getOptimusLogsDated")
    public JAXBElement<GetOptimusLogsDated> createGetOptimusLogsDated(GetOptimusLogsDated value) {
        return new JAXBElement<GetOptimusLogsDated>(_GetOptimusLogsDated_QNAME, GetOptimusLogsDated.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUsersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices.optimus.samaylabs.com/", name = "getUsersResponse")
    public JAXBElement<GetUsersResponse> createGetUsersResponse(GetUsersResponse value) {
        return new JAXBElement<GetUsersResponse>(_GetUsersResponse_QNAME, GetUsersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOptimusLogsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices.optimus.samaylabs.com/", name = "getOptimusLogsResponse")
    public JAXBElement<GetOptimusLogsResponse> createGetOptimusLogsResponse(GetOptimusLogsResponse value) {
        return new JAXBElement<GetOptimusLogsResponse>(_GetOptimusLogsResponse_QNAME, GetOptimusLogsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOptimusLogs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices.optimus.samaylabs.com/", name = "getOptimusLogs")
    public JAXBElement<GetOptimusLogs> createGetOptimusLogs(GetOptimusLogs value) {
        return new JAXBElement<GetOptimusLogs>(_GetOptimusLogs_QNAME, GetOptimusLogs.class, null, value);
    }

}
