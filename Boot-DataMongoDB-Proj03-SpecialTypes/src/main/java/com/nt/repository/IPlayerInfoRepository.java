//IPlayerInfoRepository.java
package com.nt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.document.PlayerInfo;

public interface IPlayerInfoRepository extends MongoRepository<PlayerInfo, Integer> {

}//interface
