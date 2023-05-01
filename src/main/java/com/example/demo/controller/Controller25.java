package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("sub25")
public class Controller25 {
	
	
	@RequestMapping(path = "link1", method = RequestMethod.GET) // path(value) get,post방식으로 보낸것에 답변하겠다
	public void method1() {
		System.out.println("/sub25/link1 에서 메소드 일함");
		
	}
	// @RequestMapping(value = "link2",method = RequestMethod.GET) 아래 @GetMapping("link2")와 같은 일을 함
	@GetMapping("link2")
	public void method2() {
		System.out.println("/sub25/link2 GET 에서 메소드 일함");
	}
	
	
	// @RequestMapping(value = "link2",method = RequestMethod.POST) 아래 @GetMapping("link2")
	@PostMapping("link3")
	public void method3() {
		System.out.println("/sub25/link2 GET 에서 메소드 일함");
	}
	
	// /sub25/link4/abc
	// / sub25/link4/def    {var1} 에 def 가 들어간다
	@GetMapping("link4/{var1}")
	public void method4(@PathVariable("var1") String p1) {
		System.out.println("var1:" + p1);
	}
	
	
	// /sub25/link5/zeratul/32500  id에 zeratul이 age에 32500이 들어가게됨
	
	@GetMapping("link5/{id}/{age}")
	public void method5(@PathVariable("id")String id,
			@PathVariable("age")int age) {
		System.out.println(id + "," + age);
	}
	
	//sub25/link6/id/3/name/son
	@GetMapping("link6/id/{var1}/name/{var2}")
	public void method6(@PathVariable("var1")String id,@PathVariable("var2")String name){
		System.out.println(id + "," + name);
	}
	
	@GetMapping("link7")
	public String method7() {
		return "hello"; // /WEB-INf/view/hello.jsp 포워드됨
	}
	
	// redirect
	@GetMapping("link8")
	public String method8() {
		return "redirect:/sub25/link7"; // link7로 리다이렉트하여 넘김
	}
	
	@GetMapping("link9")
	public String method9(Model model) {
		model.addAttribute("attr1","value1");
		return "redirect:link10"; // 리다이렉트해서 넘기는건 Model이 아니라 RedirectAttributes사용해야함
	}
	
	@GetMapping("link10")
	public void method10() {
		
	}
	
	@GetMapping("link11")
	public String method11(RedirectAttributes rda) {
		rda.addFlashAttribute("attr1","redirect attribute");
		return "redirect:link10";
	}
	
	@GetMapping("link12")
	public String method12(RedirectAttributes adr) {
	   
		adr.addFlashAttribute("list",List.of("zera","tulr")); 
		//***** 모델 attribute 를 만들어서 13으로 넘겨주는 작업 *****
		
	    return "redirect:/sub25/link13";
	    }
	
	@GetMapping("link13")
	public void method13() {
	 
	}
	
	@GetMapping("link14")
	public String method14(RedirectAttributes rda) {

		// 목적지의 Model Attribute 로 붙여서 보냄
		// rda.addFlashAttribute(null,rda);
		
		
		rda.addAttribute("address","seoul"); //쿼리 스트링으로 붙어서 목적지로 보냄
		// /sub25/link14로 요청이 들어오면 ?address=seoul 을 붙임
		
		return "redirect:link15";
	}
	
	
	// ************** ************** ************** ************** **************
	
	// /sub25/link15 요청 보내면 link16의 email과 location에 값이 들어가도록
	@GetMapping("link15")
	public String method15(RedirectAttributes rda) {
		rda.addAttribute("email","rlagkals3135@naver.com");
		rda.addAttribute("location","인천북구강남한강깊숙한곳");
		
		return "redirect:link16";
	}
		
	
	@GetMapping("link16")
	public void method16(@RequestParam("email")	String email,
			@RequestParam("location")String location	) {
		System.out.println("email:" + email);
		System.out.println("location:" + location);
	}
	// ************** ************** ************** ************** ************** 
	// 클라이언트에서 파라미터 받아서 
	
	@GetMapping("link17")
	public String method17(RedirectAttributes rda, 
            @RequestParam("email") String email,
            @RequestParam("location") String location) {
rda.addAttribute("email", email);
rda.addAttribute("location", location);
	    return "redirect:link18";
	}

	@GetMapping("link18")
	public void method18(@ModelAttribute("email") String email,
	                     @ModelAttribute("location") String location) {
	    System.out.println("email:" + email);
	    System.out.println("location:" + location);
	}
	//  ********* ********* ********* ********* ********* ********* ********* *********
	
	/*RedirectAttributes는 스프링에서 제공하는 클래스로, 리다이렉트를 수행할 때 데이터를 전달할 수 있는 기능을 제공합니다.

rda.addAttribute()와 rda.addFlashAttribute()는 둘 다 리다이렉트 시에 데이터를 전달하는 메소드입니다. 
하지만 이 둘은 다르게 동작합니다.

rda.addAttribute(): 리다이렉트한 URL 뒤에 Query String을 추가하여 데이터를 전달합니다.
 따라서 URL이 길어질 수 있습니다. 또한, URL이 노출되기 때문에 보안상 취약점이 존재할 수 있습니다.
 
rda.addFlashAttribute(): 세션에 데이터를 저장하고, 리다이렉트된 페이지에서는 한 번만 사용할 수 있습니다. 
따라서 URL이 길어지지 않고, 보안상도 안전합니다. */
}
