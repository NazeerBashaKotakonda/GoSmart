package com.gosmart.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gosmart.constants.ContactOwnerConstants;
import com.gosmart.repository.entity.ContactOwnerEntity;
import com.gosmart.service.ContactOwnerService;

import lombok.extern.slf4j.Slf4j;
/**
 * 
 * @author NazeerBasha
 *
 */
@Repository
@Slf4j
@RequestMapping("/api/v1")
public class ContactOwnerController {
	
	private ContactOwnerService contactOwnerService;
	
	@PostMapping("/contactowner/save")
	public ResponseEntity<Integer> inserContactOwner(@RequestBody ContactOwnerEntity contactOwnerEntity)
	{
		log.info("{}-ContactOwnerController insertContactOwner() started contactOwnerdatails in repositoty",
				ContactOwnerConstants.CONTACT_OWNER);
		try {
			log.info("{}-ContactOwnerController insertContactOwner() saved contactOwnerdatails in repositoty",
					ContactOwnerConstants.CONTACT_OWNER);
			Integer contactOwnerId=contactOwnerService.insertContactOwner(contactOwnerEntity);
			return new ResponseEntity<>(contactOwnerId,HttpStatus.CREATED);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	public ResponseEntity<List<ContactOwnerEntity>>getContactOwner(@PathVariable Integer contactOwnerId)
	{	log.info("{}-ContactOwnerController getContactOwner() started contactOwnerdatails in repositoty",
			ContactOwnerConstants.CONTACT_OWNER);
		try {
			log.info("{}-ContactOwnerController getContactOwner() getting contactOwnerdatails in repositoty",
					ContactOwnerConstants.CONTACT_OWNER);
			List<ContactOwnerEntity> contactOwners=contactOwnerService.getContactOwner(contactOwnerId);
			return new ResponseEntity<>(contactOwners,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
