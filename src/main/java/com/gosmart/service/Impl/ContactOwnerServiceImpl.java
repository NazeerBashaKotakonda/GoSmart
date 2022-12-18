package com.gosmart.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gosmart.constants.ContactOwnerConstants;
import com.gosmart.exception.GoSmartException;
import com.gosmart.repository.ContactOwnerRepository;
import com.gosmart.repository.entity.ContactOwnerEntity;
import com.gosmart.service.ContactOwnerService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ContactOwnerServiceImpl implements ContactOwnerService {

	@Autowired
	private ContactOwnerRepository contactOwnerRepository;

	/**
	 * This method is used for the insertContactOwner
	 * 
	 * @param contactOwnerEntity This is the parameter to insertContactOwner()
	 * @return Integer This returns contactOwnerId
	 */

	@Override
	public Integer insertContactOwner(ContactOwnerEntity contactOwnerEntity) {
		Integer contactOwnerId = 0;
		log.info("{}- ServiceImpl insertContactOwner() started", ContactOwnerConstants.CONTACT_OWNER);
		try {
			log.info("{}-ServiceImpl insertContactOwner() saving contactOwnerdatails in repositoty",
					ContactOwnerConstants.CONTACT_OWNER);

			if (contactOwnerEntity != null) {
				ContactOwnerEntity contactOwner = contactOwnerRepository.save(contactOwnerEntity);
				log.info("{}-ServiceImpl insertContactOwner() saved contactOwnerdatails in repositoty",
						ContactOwnerConstants.CONTACT_OWNER);

				if (contactOwner != null) {
					
					log.info("{}-ServiceImpl insertContactOwner()-{}",
							ContactOwnerConstants.CONTACT_OWNER,contactOwnerId);

					contactOwnerId = contactOwner.getContactOwnwrId();
				}
			}

		} catch (Exception e) {
			log.error("{}-ServiceImpl insertContactOwner() exception occured-{}",
					ContactOwnerConstants.CONTACT_OWNER,e.getMessage());
			throw new GoSmartException(e.getMessage());
			

		}

		return contactOwnerId;
	}
	public List<ContactOwnerEntity>getContactOwner(Integer contactOwnerId)
	{
		log.info("{}- ServiceImpl getContactOwner() started", ContactOwnerConstants.CONTACT_OWNER);
		List<ContactOwnerEntity> owners=null;
		try 
		{
			log.info("{}-ServiceImpl getContactOwner()getting contactOwnerdatails in repositoty",
					ContactOwnerConstants.CONTACT_OWNER);
			owners=contactOwnerRepository.findAllByContactOwnerId(contactOwnerId);
		} 
		catch (Exception e) 
		{
			throw new GoSmartException(e.getMessage());
		}
		return owners;
	}

}
