$("#button1").click(function() {
	$.ajax("/sub35/link1", { method: "post" });
});

$("#button2").click(function() {
	$.ajax("/sub35/link2", { method: "post" });
});



$("#button3").click(function() {
	$.ajax("/sub35/link3", {
		method: "post",
		data: "name=zeratul"
	});
});



$("#button4").click(function() {
	$.ajax("/sub35/link4", {
		method: "post",
		data: "address=Sinandress&price=300.3"
	});
});



$("#button5").click(function() {
	$.ajax("/sub35/link5", {
		method: "post",
		data: "name=zz&score=32&email=re@re"
	});
});


$("#button6").click(function() {
	$.ajax("/sub35/link6", {
		method: "post",
		data: "address=MokPo&product=sword&price=32500"
	});
});

$("#button7").click(function() {
	const obj = { name: "zimmy" };
	$.ajax("/sub35/link7", {
		method: "post",
		data: JSON.stringify(obj),
		contentType: "application/json"
	});
});

$("#button8").click(function() {
	const data = {
		address: "seoul",
		name: "박지성"
	};
	$.ajax("/sub35/link8", {
		method: "post",
		contentType: "application/json",
		data: JSON.stringify(data)
	});
});

$("#button9").click(function() {
	$.ajax("/sub35/link9", {
		method: "post",
		contentType: "application/json",
		data: `{"age": 14, "name": "cha", "married": true}`
	});
});

$("#button10").click(function() {
	$.ajax("/sub35/link10", {
		method: "post",
		contentType: "application/json",
		data: `{"address": null, "age": 30, "name": "손흥민"}`
	})
})

$("#button11").click(function() {
	$.ajax("/sub35/link11", {
		method: "post",
		contentType: "application/json",
		data: `{"book": {"title": "java", "price": 300}, "address": "seoul"}`
	})
})

$("#button12").click(function() {
	$.ajax("/sub35/link12", {
		method: "post",
		contentType: "application/json",
		data: `{"food":["pizza", "coke", "coffee"], "store": "피자스쿨"}`
	})
})

$("#button13").click(function() {
	$.ajax("/sub35/link13", {
		method: "post",
		contentType: "application/json",
		data: ["pizza", "coke", "coffee"]
	})
})

$("#button14").click(function() {
	const data = [
		{
			name: "zeratul",
			position: "딜러"
		},
		{
			name: "짐레이너",
			position: "호구"
		}
	]

	$.ajax("/sub35/link14", {
		method: "post",
		contentType: "application/json",
		data: JSON.stringify(data)
	});
});













