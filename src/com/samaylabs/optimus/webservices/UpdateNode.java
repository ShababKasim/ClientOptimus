
package com.samaylabs.optimus.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateNode complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateNode">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="arg1" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="arg2" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="arg3" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="arg4" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateNode", propOrder = {
    "arg0",
    "arg1",
    "arg2",
    "arg3",
    "arg4"
})
public class UpdateNode {

    protected long arg0;
    protected long arg1;
    protected float arg2;
    protected float arg3;
    protected int arg4;

    /**
     * Gets the value of the arg0 property.
     * 
     */
    public long getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     * 
     */
    public void setArg0(long value) {
        this.arg0 = value;
    }

    /**
     * Gets the value of the arg1 property.
     * 
     */
    public long getArg1() {
        return arg1;
    }

    /**
     * Sets the value of the arg1 property.
     * 
     */
    public void setArg1(long value) {
        this.arg1 = value;
    }

    /**
     * Gets the value of the arg2 property.
     * 
     */
    public float getArg2() {
        return arg2;
    }

    /**
     * Sets the value of the arg2 property.
     * 
     */
    public void setArg2(float value) {
        this.arg2 = value;
    }

    /**
     * Gets the value of the arg3 property.
     * 
     */
    public float getArg3() {
        return arg3;
    }

    /**
     * Sets the value of the arg3 property.
     * 
     */
    public void setArg3(float value) {
        this.arg3 = value;
    }

    /**
     * Gets the value of the arg4 property.
     * 
     */
    public int getArg4() {
        return arg4;
    }

    /**
     * Sets the value of the arg4 property.
     * 
     */
    public void setArg4(int value) {
        this.arg4 = value;
    }

}
