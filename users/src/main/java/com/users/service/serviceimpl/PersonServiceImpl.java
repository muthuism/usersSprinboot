package com.users.service.serviceimpl;


import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.users.model.PersonModel;
import com.users.pojo.PersonReqPojo;
import com.users.repo.PersonModelRepo;
import com.users.service.PersonService;


@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonModelRepo personModelRepo;

	@Override
	public ResponseEntity<?> addPerson(HttpServletRequest req,PersonReqPojo personReqPojo) throws Exception {
		
		
		String message="request has been save succesfully";
	 try {
		 PersonModel personModel = new PersonModel();
		 String uuid =UUID.randomUUID().toString();
		 personModel.setAge(personReqPojo.getAge());
		 personModel.setDate(personReqPojo.getDate());
		 personModel.setDob(personReqPojo.getDob());
		 personModel.setEducation(personReqPojo.getEducation());
		 personModel.setName(personReqPojo.getName());
		 personModel.setPersonid(uuid);
		 personModelRepo.save(personModel);
	 }catch(Exception e) {
		 message="request has not been saved ,Error Occured";
			return new ResponseEntity<>(HttpStatus.CREATED).ok(message);
	 }
	
		return new ResponseEntity<>(HttpStatus.CREATED).ok(message);
	}

	@Override
	public ResponseEntity<?> findPerson(HttpServletRequest req,String id) throws Exception {
		
		String message="Data has been fetched succesfully";
		 PersonReqPojo personReqPojo = new PersonReqPojo();
		 try {
		
			 PersonModel  personModel=personModelRepo.findById(id).get();			
			 personReqPojo.setAge(personModel.getAge());
			 personReqPojo.setDate(personModel.getDate());
			 personReqPojo.setDob(personModel.getDob());
			 personReqPojo.setEducation(personModel.getEducation());
			 personReqPojo.setName(personModel.getName());
			 personReqPojo.setPersonid(personModel.getPersonid());
			 
		 }catch(Exception e) {
			 message="Data has not been fetched ,Error Occured";
			 return new ResponseEntity<>(HttpStatus.OK).ok(message);
		 }
			
			return new ResponseEntity<>(HttpStatus.OK).ok(personReqPojo);
	}
	
	
	
}
