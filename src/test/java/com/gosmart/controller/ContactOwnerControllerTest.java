package com.gosmart.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.lang.ModuleLayer.Controller;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gosmart.repository.ContactOwnerRepository;
import com.gosmart.repository.entity.ContactOwnerEntity;
import com.gosmart.service.ContactOwnerService;
import com.gosmart.service.Impl.ContactOwnerServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class ContactOwnerControllerTest {
	@InjectMocks
	private ContactOwnerController contactOwnerController;
	@Mock
	private ContactOwnerService contactOwnerService;
	@Test
	public void testInserContactOwner() throws Exception
	{
		ContactOwnerEntity contactOwnerEntity=new ContactOwnerEntity();
		Integer contactOwnerId=1;
		when(contactOwnerService.insertContactOwner(contactOwnerEntity)).thenReturn(contactOwnerId);
		ResponseEntity<Integer> response=contactOwnerController.inserContactOwner(contactOwnerEntity);
		assertEquals(HttpStatus.CREATED,response.getStatusCode());
	}
	@Test
	public void testInserContactOwner_Exception() throws Exception
	{
		ContactOwnerEntity contactOwnerEntity=new ContactOwnerEntity();
		when(contactOwnerService.insertContactOwner(contactOwnerEntity)).thenThrow(NullPointerException.class);
		ResponseEntity<Integer> response=contactOwnerController.inserContactOwner(contactOwnerEntity);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,response.getStatusCode());
	}
	
	@Test
	public void testGetContactOwner() throws Exception
	{
		Integer contactOwnerId=1;
		List<ContactOwnerEntity> contactOwnerList=new ArrayList<>();
		when(contactOwnerService.getContactOwner(contactOwnerId)).thenReturn(contactOwnerList);
		ResponseEntity<List<ContactOwnerEntity>> responseEntity=contactOwnerController.getContactOwner(contactOwnerId);
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
	}
	@Test
	public void testGetContactOwner_Exception() throws Exception
	{
		Integer contactOwnerId=1;
		when(contactOwnerService.getContactOwner(contactOwnerId)).thenThrow(NullPointerException.class);
		ResponseEntity<List<ContactOwnerEntity>> responseEntity=contactOwnerController.getContactOwner(contactOwnerId);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,responseEntity.getStatusCode());
	}

}
