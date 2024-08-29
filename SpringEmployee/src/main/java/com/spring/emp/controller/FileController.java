 package com.spring.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.emp.helper.Fileupload;

@RestController
public class FileController {

	@Autowired
	private  Fileupload fileupload;
	@PostMapping("/file")
	public ResponseEntity<String> uploadfile(@RequestParam("file") MultipartFile file){
		//validation
	try {
		
		if(file.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
		}
		if(!file.getContentType().equals("image/jpeg")) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("only works with jpeg");
		}
		
		boolean f = fileupload.uploadfile(file);
		if(f)
		{
			return ResponseEntity.ok("File is successfully");
		}
	} catch(Exception e)
	{
		e.printStackTrace();
		
	}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
	}
	
	//file upload code
	
	
	
	
}
