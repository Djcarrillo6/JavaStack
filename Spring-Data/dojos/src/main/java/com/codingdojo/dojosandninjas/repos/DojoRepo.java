package com.codingdojo.dojosandninjas.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojosandninjas.models.Dojo;


@Repository
// DojoRepo interface extends the CrudRepo;
public interface DojoRepo extends CrudRepository<Dojo, Long>{
	List<Dojo> findAll();
}
