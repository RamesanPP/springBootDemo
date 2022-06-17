package com.example.springBoot.Demo.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.springBoot.Demo.entity.DepartmentIdSequence;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class SequenceGeneratorService {

	@Autowired
	private MongoOperations mongoOps;
	
	public int getSequenceNumber(String sequenceName) {
		Query que = new Query(Criteria.where("id").is(sequenceName));
		Update update = new Update().inc("seqNo", 1);
		
		DepartmentIdSequence counter = mongoOps
                .findAndModify(que,
                        update, options().returnNew(true).upsert(true),
                        DepartmentIdSequence.class);

        return !Objects.isNull(counter) ? counter.getSeqNo() : 1;
	}
	
}
