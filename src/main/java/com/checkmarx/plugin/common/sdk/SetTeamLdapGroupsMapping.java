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
 *         &lt;element name="sessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="teamId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ldapGroups" type="{http://Checkmarx.com/v7}ArrayOfCxWSLdapGroupMapping" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "sessionId",
        "teamId",
        "ldapGroups"
})
@XmlRootElement(name = "SetTeamLdapGroupsMapping")
public class SetTeamLdapGroupsMapping {

    protected String sessionId;
    protected String teamId;
    protected ArrayOfCxWSLdapGroupMapping ldapGroups;

    /**
     * Gets the value of the sessionId property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * Sets the value of the sessionId property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSessionId(String value) {
        this.sessionId = value;
    }

    /**
     * Gets the value of the teamId property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTeamId() {
        return teamId;
    }

    /**
     * Sets the value of the teamId property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTeamId(String value) {
        this.teamId = value;
    }

    /**
     * Gets the value of the ldapGroups property.
     *
     * @return possible object is
     * {@link ArrayOfCxWSLdapGroupMapping }
     */
    public ArrayOfCxWSLdapGroupMapping getLdapGroups() {
        return ldapGroups;
    }

    /**
     * Sets the value of the ldapGroups property.
     *
     * @param value allowed object is
     *              {@link ArrayOfCxWSLdapGroupMapping }
     */
    public void setLdapGroups(ArrayOfCxWSLdapGroupMapping value) {
        this.ldapGroups = value;
    }

}
