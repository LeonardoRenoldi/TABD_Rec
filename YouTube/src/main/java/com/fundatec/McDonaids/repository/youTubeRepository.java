package com.fundatec.McDonaids.repository;



import com.fundatec.McDonaids.model.youTube;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface youTubeRepository extends MongoRepository<youTube, Integer> {

    Optional<youTube> findById(Integer id);



}