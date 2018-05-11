/**
 * 
 */
package com.skc.rest;

import java.util.List;
import java.util.Map;

/**
 * @author sitakant
 *
 */
public class AppBuilder {

	private static AppDetails appDetails;
	
	private AppBuilder() {}
	
	public static AppBuilder init() {
		appDetails = new AppDetails();
		return new AppBuilder();
	}
	
	public AppBuilder withDeveloper(String developer) {
		appDetails.setDeveloper(developer);
		return this;
	}
	
	public AppBuilder withAppName(String appName) {
		appDetails.setName(appName);
		return this;
	}
	
	public AppBuilder withAppVersion(String appVersion) {
		appDetails.setVersion(appVersion);
		return this;
	}
	
	public AppBuilder withRequestedEndpoint(String endpoint) {
		appDetails.setEndpoint(endpoint);
		return this;
	}
	
	public AppBuilder withHttpHeaders(List<Map<String,String>> headers) {
		appDetails.setHeaders(headers);
		return this;
	}

	public AppBuilder withDescription(String description) {
		appDetails.setDescription(description);
		return this;
	}
	public AppDetails build() {
		assert appDetails != null;
		return appDetails;
	}
	
}
