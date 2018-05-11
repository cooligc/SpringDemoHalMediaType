/**
 * 
 */
package com.skc.rest;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author sitakant
 *
 */
public class AppDetails implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String version;
	private String developer;
	private String endpoint;
	private String description;
	private List<Map<String,String>> headers;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * @return the developer
	 */
	public String getDeveloper() {
		return developer;
	}
	/**
	 * @param developer the developer to set
	 */
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	/**
	 * @return the endpoint
	 */
	public String getEndpoint() {
		return endpoint;
	}
	/**
	 * @param endpoint the endpoint to set
	 */
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	/**
	 * @return the headers
	 */
	public List<Map<String,String>> getHeaders() {
		return headers;
	}
	/**
	 * @param headers the headers to set
	 */
	public void setHeaders(List<Map<String,String>> headers) {
		this.headers = headers;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AppDetails [name=" + name + ", version=" + version + ", developer=" + developer + ", endpoint="
				+ endpoint + ", headers=" + headers + "]";
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
