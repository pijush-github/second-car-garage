package com.ing.fullstack.challenge.webapp.secondcargarage.service;


import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class NextSequenceGeneratorService {
	
	@Autowired 
	private MongoOperations mongoOperations;

    public int getNextWarehoseSequence(String seqName)
    {
        WarehouseDatabseSequences counter = mongoOperations.findAndModify(
            query(where("_id").is(seqName)),
            new Update().inc("seq",1),
            options().returnNew(true).upsert(true),
            WarehouseDatabseSequences.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;
        
    }
    
    public int getNextCarSequence(String seqName)
    {
    	CarDatabseSequences counter = mongoOperations.findAndModify(
            query(where("_id").is(seqName)),
            new Update().inc("seq",1),
            options().returnNew(true).upsert(true),
            CarDatabseSequences.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;
        
    }
}
