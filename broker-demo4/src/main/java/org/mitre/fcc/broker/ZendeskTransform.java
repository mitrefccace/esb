package org.mitre.fcc.broker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.apache.camel.Exchange;

public class ZendeskTransform  {
	private final static Logger logger = LoggerFactory.getLogger(ZendeskTransform.class);
	
	public String transform(Object body, Exchange exchange) {
		
        String zendeskJSON = null;
        
		if (body instanceof User) {
			logger.info("Found a User object");
			User user = (User)body;

	        ObjectMapper mapper = new ObjectMapper(); 
	        ObjectNode userNode = mapper.createObjectNode(); 
	        ObjectNode userFields = mapper.createObjectNode(); 
	        ObjectNode customFields = mapper.createObjectNode(); 

	        // Skip ID because Zendesk will not need it for create or update.  Zendesk will use email or external ID for updates
	        userFields.put("name", user.getName()); 
	        userFields.put("email" , user.getEmail());
	        userFields.put("phone", user.getPhone());
	        userFields.put("notes", user.getNotes()); 

	        customFields.put("address", user.getAddress()); 
	        customFields.put("bank_account", user.getAccount());
	        
	        userFields.set("user_fields", customFields);
	        userNode.set("user", userFields);
	        
	        
	        try {
	        	zendeskJSON = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userNode);
	        	logger.info("zendesk json:\n" + zendeskJSON);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        
// Zendesk User Record:
//	      "id": 4060748677,
//	      "url": "https://vmdigioia.zendesk.com/api/v2/users/4060748677.json",
//	      "name": "AD Agent",
//	      "email": "wkchang@mitre.org",
//	      "created_at": "2016-01-11T19:21:03Z",
//	      "updated_at": "2017-08-08T20:41:56Z",
//	      "time_zone": "Atlantic Time (Canada)",
//	      "phone": "222-111-1111",
//	      "shared_phone_number": false,
//	      "photo": null,
//	      "locale_id": 1,
//	      "locale": "en-US",
//	      "organization_id": null,
//	      "role": "admin",
//	      "verified": true,
//	      "authenticity_token": "o3h1BOwKkScm9OkVd30i3QN5LOGljFRaKJ19MTXA59c=",
//	      "external_id": null,
//	      "tags": [],
//	      "alias": "",
//	      "active": true,
//	      "shared": false,
//	      "shared_agent": false,
//	      "last_login_at": "2017-08-08T20:41:56Z",
//	      "two_factor_auth_enabled": null,
//	      "signature": "",
//	      "details": "",
//	      "notes": "",
//	      "custom_role_id": null,
//	      "moderator": true,
//	      "ticket_restriction": null,
//	      "only_private_comments": false,
//	      "restricted_agent": false,
//	      "suspended": false,
//	      "chat_only": false,
//	      "default_group_id": 27251458,
//	      "user_fields": {
//	                     "address": "3560 Main Street",
//	                     "address_2": null,
//	                     "bank_account": "12345679",
//	                     "bank_name": "PNC Bank",
//	                     "bank_routing_id": "543000",
//	                     "city": "Fairfax",
//	                     "last_name": "Chang",
//	                     "ssn": "123-45-6789",
//	                     "state": "VA",
//	                     "zip": "12345"
//	      }
		}
		return zendeskJSON;
	}

}
