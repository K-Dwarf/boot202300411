package com.example.demo.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Controller
@RequestMapping("sub29")
public class Controller29 {

	
	// 경로 : /sub29/link1?name=son&age=33 Get 방식은 쿼리스트링에 붙어서 넘김
	@GetMapping("link1")
	public void method1() {
		 // /sub29/link1.jsp
		
	}
	
	// 포스트 방식은 따로 포스트 몸통에 붙여서 넘김 
	@PostMapping("link2")
	public void method2(@RequestParam("myfile") MultipartFile file) {
		System.out.println(file.getSize());
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
	}
	
	
	@GetMapping("link3")
	public void method3() {
		// 파일 Input 이 있는 form 을 포함한 뷰로 포워드
	}
	
	
	// 여러개의 파일을 전송시 MultipartFile 을 배열 형식으로 
	@PostMapping("link4")
	public void method4(@RequestParam("files") MultipartFile[] file) {
		for(MultipartFile f :file) {
		System.out.println(f.getOriginalFilename());
		System.out.println(f.getSize() + " byte");
	}
	}
	
	
	
	@GetMapping("link5")
	public void method5() {
		
	}
	
	
	@PostMapping("link6")
	public void method6(@RequestParam("files") MultipartFile[] files) {
		for (MultipartFile fs:files) {
			System.out.println(fs.getOriginalFilename());
		}
	}
	
	
	
	// -------------------------- http://localhost:8080/sub29/link7 ---------------------------------------
	@GetMapping("link7")
	public void method7() {
		
	}
	
	@Data
	static class Sub29Dto{
		private String name;
		private Integer age;
	}
	
	
	@PostMapping("link8")
	public void method8(
			Sub29Dto dto,
			String name,
			Integer age,
			@RequestParam("files") MultipartFile[] files) {
		for (MultipartFile fs:files) {
			System.out.println(fs.getOriginalFilename());
			System.out.println(name);
			System.out.println(age + "세");
			}
	}
	
	@GetMapping("link9")
	public void method9() {
		
	}
	
// -----------------------------http://localhost:8080/sub29/link8 END ------------------------------------	
	
	@PostMapping("link10")
	public void method10(@RequestParam("files")MultipartFile file) {
		
		String targetFileName = "copy_" + file.getOriginalFilename(); // 받아온 파일 이름지정
		String uploadPath = "C:/workstation/"; // 저장경로
		String fullPath = uploadPath + targetFileName;
		
		
		
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
	


	
	@PostMapping("link11")
	public void method11(@RequestParam("files")MultipartFile file) throws Exception {
		
		File target = new File("C:/workstation/" + file.getOriginalFilename());
		file.transferTo(target);
		// MultipartFile 객체를 target객체로 전송함
	}
}
