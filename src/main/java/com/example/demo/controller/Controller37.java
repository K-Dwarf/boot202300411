package com.example.demo.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.controller.Controller37.Dto1;
import com.example.demo.controller.Controller37.Dto2;

import lombok.Data;

@Controller
@RequestMapping("sub37")
public class Controller37 {

	
	@GetMapping("ajax1")
	public void view() {
		
	}
	
	// @ResponseBody
	// ResponseEntity<B>
	
	
	@GetMapping("link1")
	public ResponseEntity method1() {
		ResponseEntity res = new ResponseEntity(HttpStatusCode.valueOf(500));
		return res;
	}
	
	
	@GetMapping("link2")
	public ResponseEntity method2() {
		ResponseEntity res = ResponseEntity.ok().build();
		return res;
	}
	
	@GetMapping("link3")
	public ResponseEntity method3() {
		ResponseEntity res = ResponseEntity.notFound().build();
		
		return res;
	}
	
	@GetMapping("link4")
	public ResponseEntity method4() {
		HttpHeaders header = new HttpHeaders();
		header.add("myheader1", "my-value1");
		header.add("myheader2", "my-value2");
		ResponseEntity res = new ResponseEntity(header,HttpStatusCode.valueOf(200));
		return res;
	}
	
	@GetMapping("link5")
	public ResponseEntity<String> method5() {
		
		ResponseEntity<String> res = new ResponseEntity<>("hello response",HttpStatusCode.valueOf(200));
		return res;
	}
	
	@GetMapping("link6")
	public ResponseEntity<String> method6(){
		return ResponseEntity.ok("hello response 222");
	}
	
	// 현재 날짜를 RequestBody에 뿌림
	@GetMapping("link7")
	public ResponseEntity<String> method7() {
		 String currentDate = LocalDate.now().toString();
		    ResponseEntity<String> res = new ResponseEntity<>(currentDate, HttpStatus.OK);
		    return res;
	}

	@GetMapping("link8")
		@ResponseBody
		public String method8() {

	String dateTime = LocalDate.now().toString();
	return dateTime;
	
}
	@GetMapping("link9")
	@ResponseBody
	public String method9() {
		return LocalTime.now().toString();
	}
	
	@GetMapping("link10")
	@ResponseBody
	public String method10() {
		String data = """
				{"name": "lee", "age": 30}
				""";
		
		return data;
	}
	
	@GetMapping("link11")
	public ResponseEntity method11() {
		String data = """
				{"name": "lee", "age": 30}
				""";
		
		HttpHeaders header = new HttpHeaders();
		header.set("Content-Type", "application/json");
		
		return new ResponseEntity(data, header, 200);
	}
	
	@GetMapping("link12")
	@ResponseBody // + Map,JavaBean 이면 json String 변환 
				  //AND Content-Type : application/json 로 셋팅
	public Map method12() {
		
		Map<String,Object>map = new HashMap<>();
		map.put("name", "zeratul");
		map.put("age",523);
		
		return map;
	}
	
	
	
	@GetMapping("link13")
	@ResponseBody
	public Map method13() {
		Map<String,Object>map = new HashMap<>();
		map.put("address","seoul");
		map.put("price", 42800);
		
		return map;
			
	}
	
	
	@GetMapping("link14")
	@ResponseBody
	public Map<String,Object>method14(){
		
		var data = new HashMap<String,Object>();
		
		data.put("region", "카톨릭");
		data.put("membernumber", 5660086);
		data.put("god'snum", "only");
		data.put("weapon", List.of("cross","gun"));
		
		return data;
	}
	
	
	static class Dto1{
		public String getName() {
			return "some";
		}
		public Integer getAge() {
			return 123;
		}
		
		
	}
	@GetMapping("link15")
	@ResponseBody
	public Dto1 method15() {
		Dto1 data = new Dto1();
		
		return data;
	}
	
	@Data
	static class Dto2{
		private String city;
		private Double score;
		private boolean cap;
	}
	
	
	@GetMapping("link16")
	@ResponseBody
	public Dto2 method16() {
		Dto2 data = new Dto2();
		
		data.setCity("jeju");
		data.setScore(3.3);
		data.setCap(true);
		
		return data; // {"city":"jeju","score":3.3,"cap":true
				
	}
	
	@GetMapping("link17")
	@ResponseBody
	public List<String> method17() {
		
		return List.of("java","css","html");

	}
	
	@GetMapping("link18")
	@ResponseBody
	public List<Map<String,Object>> method18() {
		
		return List.of(Map.of("name","무안"),
				Map.of("name","영광"),
				Map.of("name","굴비"));
	}
	
	
	
	static class Dto3 {
		public String getCity() {
			return "jeju";
		}
		public Double getScore() {
			return 3.3;
		}
		public Boolean isCap() {
			return true;
		}
		public List<String> getFood() {
			return List.of("pizza", "chicken", "burger");
		}
		public Dto1 getSub1() {
			return new Dto1();
		}
		public Map<String, Object> getSub2() {
			return Map.of("model", List.of("abc", "def"), "price", 3.14);
		}
	}
	
	
	
	@GetMapping("link19")
	@ResponseBody
	public List<Dto3> method19() {
		return List.of(new Dto3(), new Dto3());
	}				

}




