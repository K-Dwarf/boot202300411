package com.example.demo.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("mysub")
public class MyController06 {
	
	@GetMapping("mylink06")
	public void method1() {
		
		
	}
	
	
	@PostMapping("mylink07")
	
		
		public void method2(@RequestParam("piles")MultipartFile file) {
			
			String targetFileName = "copy_" + file.getOriginalFilename(); // 받아온 파일 이름지정
			String uploadPath = "C:/workstation/"; // 저장경로
			String fullPath = uploadPath + targetFileName;
		System.out.println("넘어옴");

			try(
					InputStream fis = file.getInputStream();
					BufferedInputStream bis = new BufferedInputStream(fis);
					FileOutputStream fos = new FileOutputStream(fullPath);
					BufferedOutputStream bos = new BufferedOutputStream(fos)){
				
					byte[] datas = new byte[1024];
					int len = 0;
					while((len = bis.read(datas)) != -1) {
						bos.write(datas,0,len);
					}
					
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
			
			
	}
	


