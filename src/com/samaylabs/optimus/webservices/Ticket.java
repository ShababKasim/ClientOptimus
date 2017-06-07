
package com.samaylabs.optimus.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ticket complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ticket">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="agvno" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pdestination" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sdestination" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="source" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uid" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ticket", propOrder = {
    "agvno",
    "pdestination",
    "sdestination",
    "source",
    "status",
    "tid",
    "type",
    "uid"
})
public class Ticket {

    protected int agvno;
    protected int pdestination;
    protected int sdestination;
    protected int source;
    protected String status;
    protected int tid;
    protected String type;
    protected long uid;

    /**
     * Gets the value of the agvno property.
     * 
     */
    public int getAgvno() {
        return agvno;
    }

    /**
     * Sets the value of the agvno property.
     * 
     */
    public void setAgvno(int value) {
        this.agvno = value;
    }

    /**
     * Gets the value of the pdestination property.
     * 
     */
    public int getPdestination() {
        return pdestination;
    }

    /**
     * Sets the value of the pdestination property.
     * 
     */
    public void setPdestination(int value) {
        this.pdestination = value;
    }

    /**
     * Gets the value of the sdestination property.
     * 
     */
    public int getSdestination() {
        return sdestination;
    }

    /**
     * Sets the value of the sdestination property.
     * 
     */
    public void setSdestination(int value) {
        this.sdestination = value;
    }

    /**
     * Gets the value of the source property.
     * 
     */
    public int getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     * 
     */
    public void setSource(int value) {
        this.source = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the tid property.
     * 
     */
    public int getTid() {
        return tid;
    }

    /**
     * Sets the value of the tid property.
     * 
     */
    public void setTid(int value) {
        this.tid = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the uid property.
     * 
     */
    public long getUid() {
        return uid;
    }

    /**
     * Sets the value of the uid property.
     * 
     */
    public void setUid(long value) {
        this.uid = value;
    }

}
