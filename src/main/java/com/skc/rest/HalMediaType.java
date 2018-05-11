/**
 * 
 */
package com.skc.rest;

import org.springframework.http.MediaType;

/**
 * @author sitakant
 *
 */
public enum HalMediaType {

	/*V1("application/vnd.cooligc.v1+json"),
	V2("application/vnd.cooligc.v2+json"),
	V3("application/vnd.cooligc.v3+json");*/
	V1("abc");
	
	private MediaType mediaType;
	
	HalMediaType(String mediaType){
		this.mediaType = MediaType.parseMediaType(mediaType);
	}
	
	public MediaType getMediaType() {
		return this.mediaType;
	}

	public String getType() {
		return this.mediaType.toString();
	}
	
	@Override
	public String toString() {
		return this.mediaType.getType();
	}
}
