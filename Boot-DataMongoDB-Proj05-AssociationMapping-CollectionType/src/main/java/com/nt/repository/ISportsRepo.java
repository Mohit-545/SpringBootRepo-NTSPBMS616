//ISportsRepo.java
package com.nt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.document.Sports;

public interface ISportsRepo extends MongoRepository<Sports, Integer> {

}//interface
