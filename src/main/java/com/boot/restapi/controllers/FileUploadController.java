package com.boot.restapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.boot.restapi.filehelper.FileUploadHelper;

@RestController
public class FileUploadController {
	@Autowired
	private FileUploadHelper fileUploadHelper;
	
	@PostMapping("upload-file")
	public ResponseEntity<String> fileupload(@RequestParam("file") MultipartFile file) {
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getContentType());
		System.out.println(file.getSize());
		
		//validation
		if(file.isEmpty())
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("request must contain file");
		
		if (!file.getContentType().equals("image/jpeg"))
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("only jpeg type allowed");
		
		boolean f = fileUploadHelper.uploadFile(file);
		if(f) {
			//return ResponseEntity.ok("file succesfully uploaded!");
			return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString());
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong try again!");
	}
}
