package com.users.resource;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.users.pojo.PersonReqPojo;
import com.users.service.PersonService;

@RestController
public class AppBookResource {

	@Autowired
	private PersonService personService;

	@PostMapping(value = "/addperson", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> addPerson(HttpServletRequest req, @RequestBody PersonReqPojo personReqPojo)
			throws Exception {

		return personService.addPerson(req, personReqPojo);

	}

	@GetMapping(value = "/findperson/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> findperson(HttpServletRequest req, @PathVariable("id") String id) throws Exception {

		return personService.findPerson(req, id);

	}

	@PostMapping(path = "/readcsv", consumes = "multipart/form-data")
	public ResponseEntity<?> validateCSV(HttpServletRequest req, @RequestParam(value = "file") MultipartFile file)
			throws Exception {
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				String completeData = new String(bytes);
				String[] rows = completeData.split("#");
				String[] columns = rows[0].split(",");
			} catch (Exception e) {

				throw e;
			}

		}
		return null;
	}

}