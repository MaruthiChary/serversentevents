package com.fissionlabs.ssedemo.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.fissionlabs.ssedemo.service.SseService;

import ch.rasc.sse.eventbus.SseEvent;
import ch.rasc.sse.eventbus.SseEventBus;

@RestController

public class SSEController {
	@Autowired
private final SseEventBus eventBus;
	@Autowired
	private SseService service;
	private int i=0;
	public SSEController(SseEventBus eventBus) {
	    this.eventBus = eventBus;
	  }
	 @GetMapping(value = "/register")
	  public SseEmitter register(@RequestParam("event") String eventName,HttpServletRequest req) {
		System.out.println(eventName);
		
		
		i++;
	    return this.eventBus.createSseEmitter(eventName+i,eventName);
	  }
	 @GetMapping("/test")
	  public String test(@RequestParam(value ="event",defaultValue = "message") String eventName) {
		 this.service.broadcastEvent(eventName);
		 return "sentMsg";
	   
	  }
}
