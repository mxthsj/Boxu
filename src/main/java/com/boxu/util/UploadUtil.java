package com.boxu.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class UploadUtil {

	public static String load(MultipartFile imgd) {
		String originalFilename = imgd.getOriginalFilename();
		UUID uuid = UUID.randomUUID();
		String img = uuid.toString()+"_"+originalFilename;
		Properties pro = new Properties();
		InputStream inputStream = UploadUtil.class.getClassLoader().getResourceAsStream("file.properties");
		try {
			pro.load(inputStream);
			String property = pro.getProperty("path");
			imgd.transferTo(new File(property, img));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}


}
