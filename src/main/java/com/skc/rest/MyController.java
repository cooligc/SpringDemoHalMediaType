/**
 * 
 */
package com.skc.rest;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sitakant
 *
 */
@RestController
public class MyController {

	@GetMapping("/")
	public AppDetails getAppDetails(HttpServletRequest request) {
		return AppBuilder.init().withAppName("SpringDemoHalMediaType").withAppVersion("1.0").withDeveloper("cooligc")
				.withRequestedEndpoint("/").withHttpHeaders(getAllHeaders(request)).build();
	}

	@PostMapping(value="/data",consumes="application/vnd.cooligc.v1+json",produces="application/vnd.cooligc.v1+json")
	public AppDetails postAppDetails(@RequestBody AppDetails appDetails, HttpServletRequest request) {
		List<Map<String,String>> headers = getAllHeaders(request);
		return AppBuilder.init().withAppName(appDetails.getName()).withAppVersion(appDetails.getVersion())
				.withDeveloper("cooligc").withRequestedEndpoint("/data").withHttpHeaders(headers).withDescription("apiVersion1")
				.build();
	}
	
	private List<Map<String,String>> getAllHeaders(HttpServletRequest request) {
		List<Map<String,String>> headers = new ArrayList<>();
		Map<String,String> headerMap = new HashMap<>();
		Enumeration<String> enums = request.getHeaderNames();
		while(enums.hasMoreElements()) {
			String name = enums.nextElement();
			headerMap.put(name, request.getHeader(name));
		}
		headers.add(headerMap);
		return headers;
	}

	@PostMapping(value="/data",consumes="application/vnd.cooligc.v2+json",produces="application/vnd.cooligc.v2+json")
	public AppDetails postAppDetailsV2(@RequestBody AppDetails appDetails,HttpServletRequest request) {
		return AppBuilder.init().withAppName(appDetails.getName()).withAppVersion(appDetails.getVersion())
				.withDeveloper("cooligc").withRequestedEndpoint("/data").withHttpHeaders(getAllHeaders(request)).withDescription("apiVersion2")
				.build();
	}
	
	@PostMapping(value="/data",consumes= {"application/vnd.cooligc.v3+json","application/json"},produces={"application/vnd.cooligc.v3+json","application/json"})
	public AppDetails postAppDetailsV3(@RequestBody AppDetails appDetails,HttpServletRequest request) {
		return AppBuilder.init().withAppName(appDetails.getName()).withAppVersion(appDetails.getVersion())
				.withDeveloper("cooligc").withRequestedEndpoint("/data").withHttpHeaders(getAllHeaders(request)).withDescription("apiVersion3")
				.build();
	}
}
