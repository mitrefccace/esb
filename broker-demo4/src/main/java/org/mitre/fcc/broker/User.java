package org.mitre.fcc.broker;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator = ",", skipFirstLine = true)
public class User {

// Zendesk User Record:
//    "id": 4060748677,
//    "url": "https://vmdigioia.zendesk.com/api/v2/users/4060748677.json",
//    "name": "AD Agent",
//    "email": "wkchang@mitre.org",
//    "created_at": "2016-01-11T19:21:03Z",
//    "updated_at": "2017-08-08T20:41:56Z",
//    "time_zone": "Atlantic Time (Canada)",
//    "phone": "222-111-1111",
//    "shared_phone_number": false,
//    "photo": null,
//    "locale_id": 1,
//    "locale": "en-US",
//    "organization_id": null,
//    "role": "admin",
//    "verified": true,
//    "authenticity_token": "o3h1BOwKkScm9OkVd30i3QN5LOGljFRaKJ19MTXA59c=",
//    "external_id": null,
//    "tags": [],
//    "alias": "",
//    "active": true,
//    "shared": false,
//    "shared_agent": false,
//    "last_login_at": "2017-08-08T20:41:56Z",
//    "two_factor_auth_enabled": null,
//    "signature": "",
//    "details": "",
//    "notes": "",
//    "custom_role_id": null,
//    "moderator": true,
//    "ticket_restriction": null,
//    "only_private_comments": false,
//    "restricted_agent": false,
//    "suspended": false,
//    "chat_only": false,
//    "default_group_id": 27251458,
//    "user_fields": {
//                   "address": "3560 Main Street",
//                   "address_2": null,
//                   "bank_account": "12345679",
//                   "bank_name": "PNC Bank",
//                   "bank_routing_id": "543000",
//                   "city": "Fairfax",
//                   "last_name": "Chang",
//                   "ssn": "123-45-6789",
//                   "state": "VA",
//                   "zip": "12345"
//    }
	
	
	@DataField(pos = 1)
    private String id;
	
	@DataField(pos = 2)
    private String email;
	
	@DataField(pos = 3)
    private String name;

	@DataField(pos = 4)
	private String address;	
	
	@DataField(pos = 5)
	private String phone;

	@DataField(pos = 6)
	private String account;

	@DataField(pos = 7)
	private String notes;

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", name=" + name + ", address=" + address + ", phone=" + phone
				+ ", account=" + account + ", notes=" + notes + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}    

	public User clearId() {
		this.id = null;
		return this;
	}
}

