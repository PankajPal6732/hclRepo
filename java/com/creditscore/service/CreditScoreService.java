package com.creditscore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.creditscore.entity.CustomerCreditDetail;
import com.creditscore.payload.request.CustomerCreditPayload;
import com.creditscore.payload.response.CreditScoreResponsePayload;
import com.creditscore.repository.CustomerCreditRepo;

@Service
public class CreditScoreService {

	@Autowired
	CustomerCreditRepo customerCreditRepo;
	
	public CreditScoreResponsePayload addCreditDetails(CustomerCreditDetail payload) {
		
		try {
			CreditScoreResponsePayload response= new CreditScoreResponsePayload();
			Integer count =0;
			
			// first checking details exists or not within 30 Days
			count=	customerCreditRepo.getCountBySsnNumAndDateRange(payload.getSsnNumber());
			
			if(count ==0) { // if record not found then continue
				//CustomerCreditDetail details = payload;
				customerCreditRepo.save(payload);
				response.setStatus("success");
				
				// from here other API will be called ************************
				
			}else {  // if record found under 30 days return failed status with message
				response.setStatus("Failed");
				response.setMessage("Credit Details found with same SSN number ( "+payload.getSsnNumber()+" ) within 30 days,"
						+ " Please try after some Days");
			}
			
			return response;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
