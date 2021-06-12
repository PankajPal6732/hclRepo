package com.creditscore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.creditscore.entity.CustomerCreditDetail;
import com.creditscore.payload.response.CreditScoreResponsePayload;
import com.creditscore.service.CreditScoreService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/creditscore")
public class CreditScoreController {

	@Autowired
	CreditScoreService creditScoreService;
	
	@PostMapping("addCreditScore")
	public String createCreditDetails(@RequestBody CustomerCreditDetail request) {
		
		try {
			CreditScoreResponsePayload responsePaylod =	creditScoreService.addCreditDetails(request);
			
			Gson gsn = new Gson();
			
			String response = gsn.toJson(responsePaylod);
			return response;
		}catch(Exception ex) {
			ex.printStackTrace();
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);		
			}
	}
}
