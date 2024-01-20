package com.boot.restapi.filehelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
public class FileUploadHelper {
	//public final String upload_dir = "C:\\Users\\sagar\\eclipse-workspace\\REST_API_boot\\src\\main\\resources\\static\\images";
	public final String upload_dir = new ClassPathResource("static/images").getFile().getAbsolutePath();
	
	public FileUploadHelper() throws IOException {
		
	}
	
	boolean f =false;
	public boolean uploadFile(MultipartFile file) {
		try {
			//read
			InputStream inputStream = file.getInputStream();
			byte data[] = new byte[inputStream.available()];
			inputStream.read(data);
			
			//write
			FileOutputStream fos = new FileOutputStream(upload_dir+File.separator+file.getOriginalFilename());
			fos.write(data);
			fos.close();
			f = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return f;
	}
}
