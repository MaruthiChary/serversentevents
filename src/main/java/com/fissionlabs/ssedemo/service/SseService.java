package com.fissionlabs.ssedemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import ch.rasc.sse.eventbus.SseEvent;
import ch.rasc.sse.eventbus.SseEventBus;

@Service
public class SseService {
	@Autowired
	 private final SseEventBus eventBus;
	@Autowired
	 private final ApplicationEventPublisher publish;
	  public SseService(SseEventBus eventBus,ApplicationEventPublisher appPublisher) {
		  this.publish = appPublisher;
	    this.eventBus = eventBus;
	  }

	  public void broadcastEvent(String eventName) {
		 System.out.print(this.eventBus.getAllEvents());
		  this.publish.publishEvent(SseEvent.of(eventName, "{'msg':'insert'}"));
		  
		//  this.publish.publishEvent(SseEvent.of(eventName, "testing port"));
		  
	    //this.eventBus.handleEvent(SseEvent.of(SseEvent.DEFAULT_EVENT, "{'msg':'from default'}"));
	  }
}
