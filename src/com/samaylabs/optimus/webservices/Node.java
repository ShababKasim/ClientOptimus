
package com.samaylabs.optimus.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for node complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="node">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="anchor_id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nodeType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="x_co" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="y_co" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "node", propOrder = {
    "anchorId",
    "id",
    "name",
    "nodeType",
    "xCo",
    "yCo"
})
public class Node {

    @XmlElement(name = "anchor_id")
    protected long anchorId;
    protected int id;
    protected String name;
    protected int nodeType;
    @XmlElement(name = "x_co")
    protected float xCo;
    @XmlElement(name = "y_co")
    protected float yCo;

    /**
     * Gets the value of the anchorId property.
     * 
     */
    public long getAnchorId() {
        return anchorId;
    }

    /**
     * Sets the value of the anchorId property.
     * 
     */
    public void setAnchorId(long value) {
        this.anchorId = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the nodeType property.
     * 
     */
    public int getNodeType() {
        return nodeType;
    }

    /**
     * Sets the value of the nodeType property.
     * 
     */
    public void setNodeType(int value) {
        this.nodeType = value;
    }

    /**
     * Gets the value of the xCo property.
     * 
     */
    public float getXCo() {
        return xCo;
    }

    /**
     * Sets the value of the xCo property.
     * 
     */
    public void setXCo(float value) {
        this.xCo = value;
    }

    /**
     * Gets the value of the yCo property.
     * 
     */
    public float getYCo() {
        return yCo;
    }

    /**
     * Sets the value of the yCo property.
     * 
     */
    public void setYCo(float value) {
        this.yCo = value;
    }

}
