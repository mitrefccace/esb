
package org.mitre.fcc.broker.zendesk;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "address",
    "address_2",
    "bank_account",
    "bank_name",
    "bank_routing_id",
    "city",
    "last_name",
    "ssn",
    "state",
    "zip"
})
public class UserFields {

    @JsonProperty("address")
    private Object address;
    @JsonProperty("address_2")
    private Object address2;
    @JsonProperty("bank_account")
    private Object bankAccount;
    @JsonProperty("bank_name")
    private Object bankName;
    @JsonProperty("bank_routing_id")
    private Object bankRoutingId;
    @JsonProperty("city")
    private Object city;
    @JsonProperty("last_name")
    private Object lastName;
    @JsonProperty("ssn")
    private Object ssn;
    @JsonProperty("state")
    private Object state;
    @JsonProperty("zip")
    private Object zip;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("address")
    public Object getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(Object address) {
        this.address = address;
    }

    @JsonProperty("address_2")
    public Object getAddress2() {
        return address2;
    }

    @JsonProperty("address_2")
    public void setAddress2(Object address2) {
        this.address2 = address2;
    }

    @JsonProperty("bank_account")
    public Object getBankAccount() {
        return bankAccount;
    }

    @JsonProperty("bank_account")
    public void setBankAccount(Object bankAccount) {
        this.bankAccount = bankAccount;
    }

    @JsonProperty("bank_name")
    public Object getBankName() {
        return bankName;
    }

    @JsonProperty("bank_name")
    public void setBankName(Object bankName) {
        this.bankName = bankName;
    }

    @JsonProperty("bank_routing_id")
    public Object getBankRoutingId() {
        return bankRoutingId;
    }

    @JsonProperty("bank_routing_id")
    public void setBankRoutingId(Object bankRoutingId) {
        this.bankRoutingId = bankRoutingId;
    }

    @JsonProperty("city")
    public Object getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(Object city) {
        this.city = city;
    }

    @JsonProperty("last_name")
    public Object getLastName() {
        return lastName;
    }

    @JsonProperty("last_name")
    public void setLastName(Object lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("ssn")
    public Object getSsn() {
        return ssn;
    }

    @JsonProperty("ssn")
    public void setSsn(Object ssn) {
        this.ssn = ssn;
    }

    @JsonProperty("state")
    public Object getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(Object state) {
        this.state = state;
    }

    @JsonProperty("zip")
    public Object getZip() {
        return zip;
    }

    @JsonProperty("zip")
    public void setZip(Object zip) {
        this.zip = zip;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
