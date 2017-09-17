
package org.mitre.fcc.broker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "url",
    "name",
    "email",
    "created_at",
    "updated_at",
    "time_zone",
    "phone",
    "shared_phone_number",
    "photo",
    "locale_id",
    "locale",
    "organization_id",
    "role",
    "verified",
    "external_id",
    "tags",
    "alias",
    "active",
    "shared",
    "shared_agent",
    "last_login_at",
    "two_factor_auth_enabled",
    "signature",
    "details",
    "notes",
    "role_type",
    "custom_role_id",
    "moderator",
    "ticket_restriction",
    "only_private_comments",
    "restricted_agent",
    "suspended",
    "chat_only",
    "default_group_id",
    "user_fields"
})
public class ZendeskUser {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("url")
    private String url;
    @JsonProperty("name")
    private String name;
    @JsonProperty("email")
    private String email;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("time_zone")
    private String timeZone;
    @JsonProperty("phone")
    private Object phone;
    @JsonProperty("shared_phone_number")
    private Object sharedPhoneNumber;
    @JsonProperty("photo")
    private Object photo;
    @JsonProperty("locale_id")
    private Integer localeId;
    @JsonProperty("locale")
    private String locale;
    @JsonProperty("organization_id")
    private Object organizationId;
    @JsonProperty("role")
    private String role;
    @JsonProperty("verified")
    private Boolean verified;
    @JsonProperty("external_id")
    private Object externalId;
    @JsonProperty("tags")
    private List<Object> tags = null;
    @JsonProperty("alias")
    private String alias;
    @JsonProperty("active")
    private Boolean active;
    @JsonProperty("shared")
    private Boolean shared;
    @JsonProperty("shared_agent")
    private Boolean sharedAgent;
    @JsonProperty("last_login_at")
    private String lastLoginAt;
    @JsonProperty("two_factor_auth_enabled")
    private Object twoFactorAuthEnabled;
    @JsonProperty("signature")
    private String signature;
    @JsonProperty("details")
    private String details;
    @JsonProperty("notes")
    private String notes;
    @JsonProperty("role_type")
    private Object roleType;
    @JsonProperty("custom_role_id")
    private Object customRoleId;
    @JsonProperty("moderator")
    private Boolean moderator;
    @JsonProperty("ticket_restriction")
    private Object ticketRestriction;
    @JsonProperty("only_private_comments")
    private Boolean onlyPrivateComments;
    @JsonProperty("restricted_agent")
    private Boolean restrictedAgent;
    @JsonProperty("suspended")
    private Boolean suspended;
    @JsonProperty("chat_only")
    private Boolean chatOnly;
    @JsonProperty("default_group_id")
    private Integer defaultGroupId;
    @JsonProperty("user_fields")
    private UserFields userFields;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updated_at")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonProperty("time_zone")
    public String getTimeZone() {
        return timeZone;
    }

    @JsonProperty("time_zone")
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    @JsonProperty("phone")
    public Object getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(Object phone) {
        this.phone = phone;
    }

    @JsonProperty("shared_phone_number")
    public Object getSharedPhoneNumber() {
        return sharedPhoneNumber;
    }

    @JsonProperty("shared_phone_number")
    public void setSharedPhoneNumber(Object sharedPhoneNumber) {
        this.sharedPhoneNumber = sharedPhoneNumber;
    }

    @JsonProperty("photo")
    public Object getPhoto() {
        return photo;
    }

    @JsonProperty("photo")
    public void setPhoto(Object photo) {
        this.photo = photo;
    }

    @JsonProperty("locale_id")
    public Integer getLocaleId() {
        return localeId;
    }

    @JsonProperty("locale_id")
    public void setLocaleId(Integer localeId) {
        this.localeId = localeId;
    }

    @JsonProperty("locale")
    public String getLocale() {
        return locale;
    }

    @JsonProperty("locale")
    public void setLocale(String locale) {
        this.locale = locale;
    }

    @JsonProperty("organization_id")
    public Object getOrganizationId() {
        return organizationId;
    }

    @JsonProperty("organization_id")
    public void setOrganizationId(Object organizationId) {
        this.organizationId = organizationId;
    }

    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    @JsonProperty("verified")
    public Boolean getVerified() {
        return verified;
    }

    @JsonProperty("verified")
    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    @JsonProperty("external_id")
    public Object getExternalId() {
        return externalId;
    }

    @JsonProperty("external_id")
    public void setExternalId(Object externalId) {
        this.externalId = externalId;
    }

    @JsonProperty("tags")
    public List<Object> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    @JsonProperty("alias")
    public String getAlias() {
        return alias;
    }

    @JsonProperty("alias")
    public void setAlias(String alias) {
        this.alias = alias;
    }

    @JsonProperty("active")
    public Boolean getActive() {
        return active;
    }

    @JsonProperty("active")
    public void setActive(Boolean active) {
        this.active = active;
    }

    @JsonProperty("shared")
    public Boolean getShared() {
        return shared;
    }

    @JsonProperty("shared")
    public void setShared(Boolean shared) {
        this.shared = shared;
    }

    @JsonProperty("shared_agent")
    public Boolean getSharedAgent() {
        return sharedAgent;
    }

    @JsonProperty("shared_agent")
    public void setSharedAgent(Boolean sharedAgent) {
        this.sharedAgent = sharedAgent;
    }

    @JsonProperty("last_login_at")
    public String getLastLoginAt() {
        return lastLoginAt;
    }

    @JsonProperty("last_login_at")
    public void setLastLoginAt(String lastLoginAt) {
        this.lastLoginAt = lastLoginAt;
    }

    @JsonProperty("two_factor_auth_enabled")
    public Object getTwoFactorAuthEnabled() {
        return twoFactorAuthEnabled;
    }

    @JsonProperty("two_factor_auth_enabled")
    public void setTwoFactorAuthEnabled(Object twoFactorAuthEnabled) {
        this.twoFactorAuthEnabled = twoFactorAuthEnabled;
    }

    @JsonProperty("signature")
    public String getSignature() {
        return signature;
    }

    @JsonProperty("signature")
    public void setSignature(String signature) {
        this.signature = signature;
    }

    @JsonProperty("details")
    public String getDetails() {
        return details;
    }

    @JsonProperty("details")
    public void setDetails(String details) {
        this.details = details;
    }

    @JsonProperty("notes")
    public String getNotes() {
        return notes;
    }

    @JsonProperty("notes")
    public void setNotes(String notes) {
        this.notes = notes;
    }

    @JsonProperty("role_type")
    public Object getRoleType() {
        return roleType;
    }

    @JsonProperty("role_type")
    public void setRoleType(Object roleType) {
        this.roleType = roleType;
    }

    @JsonProperty("custom_role_id")
    public Object getCustomRoleId() {
        return customRoleId;
    }

    @JsonProperty("custom_role_id")
    public void setCustomRoleId(Object customRoleId) {
        this.customRoleId = customRoleId;
    }

    @JsonProperty("moderator")
    public Boolean getModerator() {
        return moderator;
    }

    @JsonProperty("moderator")
    public void setModerator(Boolean moderator) {
        this.moderator = moderator;
    }

    @JsonProperty("ticket_restriction")
    public Object getTicketRestriction() {
        return ticketRestriction;
    }

    @JsonProperty("ticket_restriction")
    public void setTicketRestriction(Object ticketRestriction) {
        this.ticketRestriction = ticketRestriction;
    }

    @JsonProperty("only_private_comments")
    public Boolean getOnlyPrivateComments() {
        return onlyPrivateComments;
    }

    @JsonProperty("only_private_comments")
    public void setOnlyPrivateComments(Boolean onlyPrivateComments) {
        this.onlyPrivateComments = onlyPrivateComments;
    }

    @JsonProperty("restricted_agent")
    public Boolean getRestrictedAgent() {
        return restrictedAgent;
    }

    @JsonProperty("restricted_agent")
    public void setRestrictedAgent(Boolean restrictedAgent) {
        this.restrictedAgent = restrictedAgent;
    }

    @JsonProperty("suspended")
    public Boolean getSuspended() {
        return suspended;
    }

    @JsonProperty("suspended")
    public void setSuspended(Boolean suspended) {
        this.suspended = suspended;
    }

    @JsonProperty("chat_only")
    public Boolean getChatOnly() {
        return chatOnly;
    }

    @JsonProperty("chat_only")
    public void setChatOnly(Boolean chatOnly) {
        this.chatOnly = chatOnly;
    }

    @JsonProperty("default_group_id")
    public Integer getDefaultGroupId() {
        return defaultGroupId;
    }

    @JsonProperty("default_group_id")
    public void setDefaultGroupId(Integer defaultGroupId) {
        this.defaultGroupId = defaultGroupId;
    }

    @JsonProperty("user_fields")
    public UserFields getUserFields() {
        return userFields;
    }

    @JsonProperty("user_fields")
    public void setUserFields(UserFields userFields) {
        this.userFields = userFields;
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
