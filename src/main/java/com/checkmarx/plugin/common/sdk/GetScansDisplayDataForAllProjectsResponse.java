package com.checkmarx.plugin.common.sdk;

import javax.xml.bind.annotation.*;


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
 *         &lt;element name="GetScansDisplayDataForAllProjectsResult" type="{http://Checkmarx.com/v7}CxWSResponseScansDisplayData" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getScansDisplayDataForAllProjectsResult"
})
@XmlRootElement(name = "GetScansDisplayDataForAllProjectsResponse")
public class GetScansDisplayDataForAllProjectsResponse {

    @XmlElement(name = "GetScansDisplayDataForAllProjectsResult")
    protected CxWSResponseScansDisplayData getScansDisplayDataForAllProjectsResult;

    /**
     * Gets the value of the getScansDisplayDataForAllProjectsResult property.
     *
     * @return possible object is
     * {@link CxWSResponseScansDisplayData }
     */
    public CxWSResponseScansDisplayData getGetScansDisplayDataForAllProjectsResult() {
        return getScansDisplayDataForAllProjectsResult;
    }

    /**
     * Sets the value of the getScansDisplayDataForAllProjectsResult property.
     *
     * @param value allowed object is
     *              {@link CxWSResponseScansDisplayData }
     */
    public void setGetScansDisplayDataForAllProjectsResult(CxWSResponseScansDisplayData value) {
        this.getScansDisplayDataForAllProjectsResult = value;
    }

}
