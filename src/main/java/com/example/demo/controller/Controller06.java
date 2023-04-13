package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("sub06")
public class Controller06 {

	@RequestMapping("link1")
	public String method01() {
		System.out.println("link1 메소드 일함");
		return "forward:/sub06/link2";
	}
	
	
	
	@RequestMapping("link2")
	public String method02() {
		System.out.println("link2 메소드 일함");
		return "forward:/sub06/link3";
	}
	
	
	
	@RequestMapping("link3")
	public String method03() {
	System.out.println("link3 메소드 실행함");
	return "forward:/sub06/link4";
	}
	
	@RequestMapping("link4")
	public String method4(HttpServletRequest req, HttpServletResponse res) 
		throws Exception{
		
		System.out.println("link4 일함");
		
		String view = "/WEB-INF/views/abc.jsp";
		req.getRequestDispatcher(view).forward(req,res);
		return "forward:/sub06/link5";
	}
	
	
	@RequestMapping("link5")
	public String method5() {
		System.out.println("link5 at work");
		return "forward:/WEB-INF/views/abc.jsp";
	}
	
	@RequestMapping("link6")
	public String method6() {
		System.out.println("link6에서 일함");
		return "abc";
	}
	
	
	@RequestMapping("link7")
	public String method07() {
		System.out.println("link7 working");
//		return "forward:/WEB-INF/views/def.jsp";
		return "def";
	}
	
	//경로 :/sub6/link8
	
	@RequestMapping("link8")
	public String method8() {
		System.out.println("8번 메소드 ");
		// defalut view name : /sub6/link8
		return "/sub6/link8";
	
	}
	
	
	@RequestMapping("link9")
	public void method9() {
		System.out.println("9번 메소드 ");
		// defalut view name : /sub6/link9
		//		return "/sub6/link9";
		// 따로 view path 를 지정하지 않고 request 를 받으면 
		//요청받은 path가 default view name 이 되고 해당 이름의 파일을 찾음
	
	}
	@RequestMapping("link10")
	public String method10() {
	return null; // foward defalut view name
	}
	
//-------- link11 과 lin12 는 같은 동작(default view name{요청받은 requst 경로를 view파일 이름으로 찾음}) -----------------	
	@RequestMapping("link11")
	public String method11() {
//		return "forward:/WEB-INF/views/sub06/link11.jsp";
		return null;
		
		//아무것도 반환하지 않으면 요청한 주소 ex) http://localhost:8080/sub08/link6 로 요청을 했다면 
		// defaultpath/sub08/link6 경로로 view 파일을 찾아서 실행함 여기서 defaultpath는 src/main/resources/ 에 있는 application.properties 에서 설정가능
		//ex)spring.mvc.view.prefix= /WEB-INF/views/
	// 		 spring.mvc.view.suffix= .jsp  이렇게 설정하면 기본적으로 컬렉터의 return은 return "forward:/WEB-INF/views/에서 시작하고 
		// 아무것도 입력하지 않았으므로 return "forward:/WEB-INF/views/ + 요청경로로 파일을 찾는다

		
	}
	@RequestMapping("link12")
	public void method12() {
		
	}
// -*******---*******-*******-----*******---*******---*******----*******-------*******-*******-*******-*******-
	
	//경로 : /sub06/link13?name=park&age=33
	//method12 작성
	//1. request param 수집/가공
	// 2. business logic (생략)
	// 3. add attribute(생략)
	// 4. /WEB-INF/views/sub06/link13.jsp 로 포워드
	
	@RequestMapping("link13")
	public void method13(String name, int age) {
		System.out.println("이름은" + name +"나이는" +  age);
		// 위 sysout은 콘솔에 나타나는 거고 실제 클라이언트에 뿌려주는 view 파일은 WEB-INF/sub06/link13.jsp 경로에 위치해있다
		
	}
}
