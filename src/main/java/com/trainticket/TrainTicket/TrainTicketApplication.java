package com.trainticket.TrainTicket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrainTicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainTicketApplication.class, args);
	}

	private TrainTicketAppServer trainTicketAppServer;

	@Autowired
	public TrainTicketApplication(TrainTicketAppServer trainTicketAppServer) {
		this.trainTicketAppServer = trainTicketAppServer;
	}

}
