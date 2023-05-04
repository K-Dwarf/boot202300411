package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.PostConstruct;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.ObjectCannedACL;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Controller
@RequestMapping("sub32")
public class Controller32 {

	@Value("${aws.accessKeyId}")
	private String accessKey;
	
	@Value("${aws.secretAccessKey}")
	private String secretKey;
	
	@Value("${aws.s3.bucketName}")
	private String bucketName;

	
	
	
	private S3Client s3;
	@PostConstruct
	public void init () {
		AwsCredentials credentials = AwsBasicCredentials.create(accessKey, secretKey);
		AwsCredentialsProvider provider = StaticCredentialsProvider.create(credentials);
		Region region = Region.AP_NORTHEAST_2; //(서울 지역 코드번호가 ap_NORTHEAST_2;)
		
	this.s3 = S3Client.builder()
            .credentialsProvider(provider)    
			.region(region)
            .build();
	
	}
	
	
	
	@GetMapping("link1")
	public void method1() {
			
		// 파일 생성
		String key = "test/myFile.txt"; // 파일 경로와 파일 이름을 결정하는 역할
		String content = "새로운 파일 내용"; // 파일 내용 
			
		// s3에 파일 업로드
	      PutObjectRequest objectRequest = PutObjectRequest.builder()

	    		  .bucket(bucketName)
	    		  .acl(ObjectCannedACL.PUBLIC_READ) // 올린 파일 모두가 볼 수 있는 권한
	                .key(key)
	                .build();


	      s3.putObject(objectRequest, software.amazon.awssdk.core.sync.RequestBody.fromBytes(content.getBytes()));
	}
	
	
	
	@GetMapping("link2")
	public void method2() {
		
		String key = "test/myFile.txt";
		
		
		
		DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
				.bucket(bucketName)
				.key(key)
				.build();
		
		s3.deleteObject(deleteObjectRequest);
		
	}
		

	@GetMapping("link3")
	public void method3() {
		// 파일 업로드 가능한 폼있는 뷰로 포워드
		
		
	}
@PostMapping("link4")
public void method4(@RequestParam("files") MultipartFile[] files)throws Exception {
	// aws s3 업로드
	for(MultipartFile file: files) {
		if(file.getSize() > 0) {
			String key = "test/" + file.getOriginalFilename(); // 파일 경로와 파일 이름을 결정하는 역할
			
			PutObjectRequest por = PutObjectRequest.builder()
					.key(key)
					.acl(ObjectCannedACL.PUBLIC_READ)
					.bucket(bucketName)
					.build();
			
			s3.putObject(por, RequestBody.fromInputStream(file.getInputStream(), file.getSize()));
		}
	}
}
	
	
	
	@PostMapping("link5")
	
	public void method5(String fileName) {
		String key = "test/" + fileName;
		
		DeleteObjectRequest dor = DeleteObjectRequest.builder()
				.key(key)
				.bucket(bucketName)
				.build();
			System.out.println(dor);
				s3.deleteObject(dor);
		
	
	
	}
	
	
	
		
		
		
	
	
	
}
