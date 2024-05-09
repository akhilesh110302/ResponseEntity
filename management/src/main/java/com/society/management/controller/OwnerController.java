package com.society.management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.society.management.Repository.OwnerRepo;
import com.society.management.entity.OwnerEntity;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/societyManagement")
public class OwnerController {

	private final OwnerRepo ownerRepo;

	@GetMapping("/getAllOwner")
	public ResponseEntity<?> getAllOwners() {

		List<OwnerEntity> c = ownerRepo.findAll();
		if(c.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(c));
	}

	@GetMapping("/getOwnerByIdPv/{customerId}")
	public  ResponseEntity<?> getAllOwnerByIdUsingPathVariable(@PathVariable("customerId") Integer id) {
		
		try {
			ownerRepo.findById(id).get();
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		catch(Exception e ){
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}

	@GetMapping("/getOwnerByIdReq")
	public ResponseEntity<?> getAllOwnerByIdUsingRequestParam(@RequestParam("customerId") Integer id) {
		try {
			ownerRepo.findById(id).get();
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		catch(Exception e ){
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}

	@PostMapping("/saveOwner")
	public ResponseEntity<?> saveOwners(@RequestBody OwnerEntity ownerEntity) {

		 ownerRepo.save(ownerEntity);
		 return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@PutMapping("/updateOwner/{id}")
	public ResponseEntity<?> updateOwners(@PathVariable Integer id,@RequestBody OwnerEntity updatedOwner) {
		
		try {
			OwnerEntity originalOwner = ownerRepo.findById(id).get();
			originalOwner.setEmail(updatedOwner.getEmail());
			originalOwner.setFullName(updatedOwner.getFullName());
			originalOwner.setPhoneNumber1(updatedOwner.getPhoneNumber1());
			originalOwner.setPhoneNumber2(updatedOwner.getPhoneNumber2());
			 ownerRepo.save(originalOwner);
			 return ResponseEntity.ok().body(originalOwner);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
}
