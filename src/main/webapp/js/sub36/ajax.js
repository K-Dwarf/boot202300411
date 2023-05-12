$("#btn1").click(function(){
	
	const obj = {
		name: "정대만",
		age: 40
	}
	
	$.ajax("/sub36/link1",{
		method: "post",
		contentType: "application/json",
		data:JSON.stringify(obj)
	})
});



$("#btn2").click(function(){
	
	const jim = {
		name:"JIM",
		email:"to@karry",
		score: 25,
		married: true		
	
	}
	
	$.ajax("/sub36/link2",{
		method: "post",
		contentType: "application/json",
		data:JSON.stringify(jim)
	})
});

$("#btn3").click(function(){
	const data = {
		name: "carry",
		hobby:[
			"game",
			"baseball",
			"music"
			]
		
	};
	
	$.ajax("/sub36/link3",{
		method: "post",
		contentType: "application/json",
		data:JSON.stringify(data)
	})
});


$("#btn4").click(function(){
	const data={
		name: "GTFO",
		price: 35000,
		goty : true
		
	};
	
	$.ajax("/sub36/link4",{
		method: "post",
		contentType: "application/json",
		data:JSON.stringify(data)
	})
});


$("#btn5").click(function(){
	const data = {
		title : "java",
		publisher : "한빛",
		writer :{
			name : "정숙이",
			age : 23
		} 
	}
	$.ajax("/sub36/link5",{
		method:"post",
		contentType: "application/json",
		data:JSON.stringify(data)
	})	;
})


$("#btn6").click(function(){
	const data = {
		city:"mexico",
		price:32000,
		etc:{
			name:"spiderman",
			email:"avengers@ironman",
			score:56000,
			married:false
		}
		
	}
	$.ajax("/sub36/link6",{
		method:"post",
		contentType: "application/json",
		data:JSON.stringify(data)
	})	;
})




$("#btn7").click(function() {
	const data =
		[
			{ name: "nikollai", age: 33 },
			{ name: "dragon", age: 1512523 },
			{ name: "huntur", age: 21 }
		]
	$.ajax("/sub36/link7", {
		method: "post",
		contentType: "application/json",
		data: JSON.stringify(data)
	})
});


$("#btn8").click(function() {
	
	const name = $("#inputName").val();
	const age = $("#inputAge").val();
	
	const data = {
		name:name,
		age:age
	}
	
	$.ajax("/sub36/link1",{
	method: "post",	
	contentType: "application/json",
	data: JSON.stringify(data)
	})
});


$("#btn9").click(function() {
	
	const name = $("#name").val();
	const  email = $("#email").val();
	const  score = $("#score").val();
	const  married = $("#married").is(":checked");
	
	const data = {
		name: name,
		email :email,
		score :score,
		married :married

	}
	
	$.ajax("/sub36/link9",{
	method: "post",	
	contentType: "application/json",
	data: JSON.stringify(data)
	})
});

	




