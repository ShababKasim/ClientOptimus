
package com.samaylabs.optimus.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for nodeResolver complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="nodeResolver">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="aid" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NRid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nodeResolver", propOrder = {
    "aid",
    "label",
    "nRid"
})
public class NodeResolver {

    protected long aid;
    protected String label;
    @XmlElement(name = "NRid")
    protected int nRid;

    /**
     * Gets the value of the aid property.
     * 
     */
    public long getAid() {
        return aid;
    }

    /**
     * Sets the value of the aid property.
     * 
     */
    public void setAid(long value) {
        this.aid = value;
    }

    /**
     * Gets the value of the label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabel(String value) {
        this.label = value;
    }

    /**
     * Gets the value of the nRid property.
     * 
     */
    public int getNRid() {
        return nRid;
    }

    /**
     * Sets the value of the nRid property.
     * 
     */
    public void setNRid(int value) {
        this.nRid = value;
    }

}
