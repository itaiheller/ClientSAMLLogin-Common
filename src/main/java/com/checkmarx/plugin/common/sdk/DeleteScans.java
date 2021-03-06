package com.checkmarx.plugin.common.sdk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="sessionID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="scanIDs" type="{http://Checkmarx.com/v7}ArrayOfLong" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "sessionID",
        "scanIDs"
})
@XmlRootElement(name = "DeleteScans")
public class DeleteScans {

    protected String sessionID;
    protected ArrayOfLong scanIDs;

    /**
     * Gets the value of the sessionID property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSessionID() {
        return sessionID;
    }

    /**
     * Sets the value of the sessionID property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSessionID(String value) {
        this.sessionID = value;
    }

    /**
     * Gets the value of the scanIDs property.
     *
     * @return possible object is
     * {@link ArrayOfLong }
     */
    public ArrayOfLong getScanIDs() {
        return scanIDs;
    }

    /**
     * Sets the value of the scanIDs property.
     *
     * @param value allowed object is
     *              {@link ArrayOfLong }
     */
    public void setScanIDs(ArrayOfLong value) {
        this.scanIDs = value;
    }

}
