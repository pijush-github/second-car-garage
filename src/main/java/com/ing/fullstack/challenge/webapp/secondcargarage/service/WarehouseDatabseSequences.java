package com.ing.fullstack.challenge.webapp.secondcargarage.service;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "warehouseSequences")
public class WarehouseDatabseSequences {
	
    @Id
    private String id;
    private int seq;
    
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
}