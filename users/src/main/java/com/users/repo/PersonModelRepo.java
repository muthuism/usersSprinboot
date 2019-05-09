package com.users.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.users.model.PersonModel;



@Repository
public interface PersonModelRepo extends JpaRepository<PersonModel,String> {

}
