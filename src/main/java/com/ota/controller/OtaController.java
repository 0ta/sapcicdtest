package com.ota.controller;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OtaController {
//    @RequestMapping("/")
//    String home() {
//    	System.out.println("Hello from home");
//    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); 
//    	String sPrincipal = (String) authentication.getPrincipal();
//        return "home -> Hello World ota!" + sPrincipal;
//    }
//    @RequestMapping("/test")
//    String test() {
//    	System.out.println("Hello from test");
//    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); 
//    	String sPrincipal = (String) authentication.getPrincipal();
//        return "test -> Hello World ota!" + sPrincipal;
//    }
    @RequestMapping("/test1")
    String test1() {
    	System.out.println("Hello from test1");
        return "test -> Hello World anonymous user!";
    }	
    @RequestMapping("/test2")
    String test2(final HttpServletRequest req) {
    	System.out.println("Hello from test2");
    	String remoteip = req.getRemoteAddr();
    	String localip = req.getLocalAddr();
    	String xip = req.getHeader("X-Forwarded-For");
    	StringBuffer sb = new StringBuffer("test -> Hello World anonymous user!");
    	sb.append("Remote Address:");
    	sb.append(remoteip + "¥n");
    	sb.append("Local Address:");
    	sb.append(localip + "¥n");
    	sb.append("X Forwarded For:");
    	sb.append(xip + "¥n");
    	Enumeration<String> names = req.getHeaderNames();
    	while(names.hasMoreElements()){
    	    String headername = names.nextElement();
    	    sb.append(headername + ":");
        	sb.append(req.getHeader(headername) + "¥n");
    	}
        return sb.toString();
    }
    @RequestMapping("/sleep")
    String sleep() {
    	System.out.println("Hello and Sleeping.....");
    	try {
			Thread.sleep(300000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
        return "wake up! -> Hello World anonymous user!";
    }         
}
