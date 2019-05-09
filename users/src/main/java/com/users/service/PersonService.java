package com.users.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.users.pojo.PersonReqPojo;



public interface PersonService {

	public ResponseEntity<?> addPerson(HttpServletRequest req, PersonReqPojo personReqPojo) throws Exception;

	public ResponseEntity<?> findPerson(HttpServletRequest req, String id) throws Exception;

}
