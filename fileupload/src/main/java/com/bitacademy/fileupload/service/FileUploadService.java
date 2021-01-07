package com.bitacademy.fileupload.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	private static final String SAVE_PATH = "/mysite-uploads";
	private static final String URL_BASE = "/images";
	
	public String restore(MultipartFile multipartFile) {
		String url ="";
		
		try {
			String originFilename = multipartFile.getOriginalFilename();
			String extName = originFilename.substring(originFilename.lastIndexOf('.')+1);
			String saveFilename = genSaveFilename(extName);
			Long fileSize = multipartFile.getSize();
			
			System.out.println("############ " + originFilename);
			System.out.println("############ " + saveFilename);
			System.out.println("############ " + fileSize);
		
		
			byte[] fileDate = multipartFile.getBytes();
			OutputStream os = new FileOutputStream(SAVE_PATH+ "/"+ saveFilename);
			os.write(fileDate);
			os.close();
			
			url = URL_BASE + "/" +saveFilename;
			
		} catch (IOException e) {
			throw new RuntimeException("file upload error:" + e);
		}
		
		return url;
	}

	private String genSaveFilename(String extName) {
		String filename = "";
		
		Calendar calenaer = Calendar.getInstance();
		filename += calenaer.get(Calendar.YEAR);
		filename += calenaer.get(Calendar.MONTH);
		filename += calenaer.get(Calendar.DATE);
		filename += calenaer.get(Calendar.HOUR);
		filename += calenaer.get(Calendar.MINUTE);
		filename += calenaer.get(Calendar.SECOND);
		filename += calenaer.get(Calendar.MILLISECOND);
		
		filename += ("."+ extName);
		return filename;
	}

}
