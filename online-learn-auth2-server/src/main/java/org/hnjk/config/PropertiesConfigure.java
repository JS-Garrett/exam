package org.hnjk.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="spring.security.oauth2")
public class PropertiesConfigure {
	private String signKey;
	private List<Map<String, String>> clients = new ArrayList<Map<String, String>>();
	public String getSignKey() {
		return signKey;
	}

	public void setSignKey(String signKey) {
		this.signKey = signKey;
	}

	public List<Map<String, String>> getClients() {
		return clients;
	}

	public void setClients(List<Map<String, String>> clients) {
		this.clients = clients;
	}
	
}
