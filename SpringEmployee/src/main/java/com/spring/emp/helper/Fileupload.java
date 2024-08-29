package com.spring.emp.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class Fileupload {

	
	public final String UPLOAD_DIR = "C:\\Users\\pc\\Documents\\workspace-spring-tool-suite-4-4.20.1.RELEASE\\SpringEmployee\\src\\main\\resources\\static\\image";

public boolean uploadfile(MultipartFile multipartFile) {
	
	boolean f=false;
	try {
		
		
		Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
	f =true;
	}
	catch(Exception e) {
   e.printStackTrace();
}
	return f;
	
}
}