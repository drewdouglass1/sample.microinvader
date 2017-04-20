package com.ibm.space.space;

import javax.servlet.ServletContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

public class CircuitBreaker {
	
	@Context ServletContext context;
	
	private Client client;
	private int tries;
	private int tries_count;
	private long timeout;
	private long started_timeout;
	private boolean breaked;
	private String urlin;
	public CircuitBreaker(int tries, long timeout, String urlin) {
		try {
			  client = ClientBuilder.newClient();
			}catch(Exception e) { client = null;}
		this.tries = tries;
		this.timeout = timeout;
		this.urlin = urlin;
		breaked = false;
		tries_count = 0;
	}
	
	public String callRest() {
		
		if (client == null) {
			try {
				  client = ClientBuilder.newClient();
				}catch(Exception e) { client = null; return "[]";}
		}
		
		try {
				  if (!breaked) {
				       return client.target(urlin).request(MediaType.APPLICATION_JSON).get(String.class);
				  }
				  else {
					  if (System.currentTimeMillis() - started_timeout >= timeout) {
						  breaked = false;
						  tries_count = 0;
					  }
				  }
		}catch(Exception e) 
		{
				tries_count++;
				if (tries_count >= tries) {
					tries_count = 0;
					breaked = true;
					started_timeout = System.currentTimeMillis();
				}
		 }
		 return "[]";		
	}
}
