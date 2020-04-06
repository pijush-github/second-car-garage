package com.ing.fullstack.challenge.webapp.secondcargarage.service;


import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.ing.fullstack.challenge.webapp.secondcargarage.domain.VehicleSequences;
import com.ing.fullstack.challenge.webapp.secondcargarage.domain.WarehouseSequences;

@Service
public class NextSequenceGeneratorService {
	
	@Autowired 
	private MongoOperations mongoOperations;

    public int getNextWarehoseSequence(String seqName)
    {
        WarehouseSequences counter = mongoOperations.findAndModify(
            query(where("_id").is(seqName)),
            new Update().inc("seq",1),
            options().returnNew(true).upsert(true),
            WarehouseSequences.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;
        
    }
    
    public int getNextVehicleSequence(String seqName)
    {
    	VehicleSequences counter = mongoOperations.findAndModify(
            query(where("_id").is(seqName)),
            new Update().inc("seq",1),
            options().returnNew(true).upsert(true),
            VehicleSequences.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;
        
    }
}
