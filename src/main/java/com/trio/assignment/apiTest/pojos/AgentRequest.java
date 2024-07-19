
package com.trio.assignment.apiTest.pojos;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "hardwareId",
    "mqttPassword"
})
@Generated("jsonschema2pojo")
public class AgentRequest {

    @JsonProperty("hardwareId")
    private String hardwareId;
    @JsonProperty("mqttPassword")
    private String mqttPassword;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("hardwareId")
    public String getHardwareId() {
        return hardwareId;
    }

    @JsonProperty("hardwareId")
    public void setHardwareId(String hardwareId) {
        this.hardwareId = hardwareId;
    }

    @JsonProperty("mqttPassword")
    public String getMqttPassword() {
        return mqttPassword;
    }

    @JsonProperty("mqttPassword")
    public void setMqttPassword(String mqttPassword) {
        this.mqttPassword = mqttPassword;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AgentRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("hardwareId");
        sb.append('=');
        sb.append(((this.hardwareId == null)?"<null>":this.hardwareId));
        sb.append(',');
        sb.append("mqttPassword");
        sb.append('=');
        sb.append(((this.mqttPassword == null)?"<null>":this.mqttPassword));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.mqttPassword == null)? 0 :this.mqttPassword.hashCode()));
        result = ((result* 31)+((this.hardwareId == null)? 0 :this.hardwareId.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AgentRequest) == false) {
            return false;
        }
        AgentRequest rhs = ((AgentRequest) other);
        return ((((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties)))&&((this.mqttPassword == rhs.mqttPassword)||((this.mqttPassword!= null)&&this.mqttPassword.equals(rhs.mqttPassword))))&&((this.hardwareId == rhs.hardwareId)||((this.hardwareId!= null)&&this.hardwareId.equals(rhs.hardwareId))));
    }

}
