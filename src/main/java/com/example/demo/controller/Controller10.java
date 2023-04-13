package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Dto04;

@Controller
@RequestMapping("sub10")
public class Controller10 {

	@RequestMapping("link1")
	public void method1(@RequestParam String name) {
//			//String name =request.getParmeter("name");
	}

	/*
	 * 클라이언트로부터 넘어온 name 파라미터를 String 타입의 name 변수로 바인딩합니다. 예를 들어 /link1?name=John과
	 * 같은 요청에서 name 파라미터를 받아올 수 있습니다.
	 */

	@RequestMapping("link2")
	public void method2(@ModelAttribute Dto04 dto) {

		/*
		 * Dto04 dto = new Dto04();
		 * 
		 * dto.setName(request.getParameter("name"));
		 * dto.setAge(Integer.parseInt(request.getParameter("age")));
		 * 
		 * request.setAttribute("dto04",dto)
		 */

		/*
		 * Dto04 클래스를 사용하여 클라이언트로부터 전달된 여러 파라미터를 객체에 담아서 처리합니다. 요청 파라미터 중에서 Dto04 클래스에
		 * 있는 필드와 이름이 일치하는 것들을 자동으로 객체에 매핑합니다. 예를 들어 /link2?name=John&age=30과 같은 요청에서
		 * name과 age 파라미터를 Dto04 객체의 필드로 바인딩합니다.
		 */

	}

	@RequestMapping("link4")
	public String method03(String model, double price, Dto04 obj, @ModelAttribute("homtown") String model1) {

		
		System.out.println(model1.length());
		
		

		return "sub9/link4";
	}

	@RequestMapping("link5")
	public void method05() {
		// 1. request param 수집/가공

		// 2. business logic
		// data를 생성,(create), 읽기(read, 수정, 삭제) 삭제(delete),
		// crud

		// 3. add attribute

		// 4. forward

	}

}
