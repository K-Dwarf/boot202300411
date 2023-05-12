package com.example.demo.component;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.security.access.prepost.PreAuthorize;

@Component
public class SecurityUtill {

	
		public boolean checkBoardWriter(Authentication authentication, String id) {
			
			System.out.println("게시물 작성자 확인 메소드");
			
			System.out.println(id);
//			System.out.println(authentication.getName());
//		    System.out.println(authentication.getPrincipal());
//			
			return true;
		}
}
