$("#btn1").click(function() {
	$.ajax("/sub39/link1", {
		success: function() {
			console.log("성공")
		},
		error: function() {
			console.log("faile")
		},
		complete: function() {
			console.log("성공하든 실패하든")
		}
	});

})


$("#btn2").click(function() {
	$.ajax("/sub39/link2", {
		success: function() {
			console.log("성공")
		},
		error: function() {
			console.log("faile")
		},
		complete: function() {
			console.log("성공하든 실패하든")
		}
	});

})


$("#btn3").click(function() {
	$.ajax("/sub39/link3", {
		success: function() {
			console.log("성공")
		},
		error: function() {
			console.log("faile")
		},
		complete: function() {
			console.log("성공하든 실패하든")
		}
	});

})
$("#btn4").click(function() {
	$.ajax("/sub39/link4", {
		success: function() {
			console.log("성공")
		},
		error: function() {
			console.log("faile")
		},
		complete: function() {
			console.log("성공하든 실패하든")
		}
	});

})


$("#btn6").click(function() {


	$.ajax("/sub39/link3")
		.done(function() {
			console.log("done 메소드 사용, 성공")
		})
		.fail(function() {
			console.log("fail 메소드 사용, 실패")
		})
		.always(function() {
			console.log("always 메소드 사용, 성공이든 실패든 실행")
		});
});


$("#btn7").click(function() {


	$.ajax("/sub39/link2")
		.done(function() {
			console.log("done 메소드 사용, 성공")
		})
		.fail(function() {
			console.log("fail 메소드 사용, 실패")
		})
		.always(function() {
			console.log("always 메소드 사용, 성공이든 실패든 실행")
		});
});




$("#btn8").click(function() {


	$.ajax("/sub39/link3")
		.done(function() {
			console.log("done 메소드 사용, 성공")
		})
		.fail(function() {
			console.log("fail 메소드 사용, 실패")
		})
		.always(function() {
			console.log("always 메소드 사용, 성공이든 실패든 실행")
		});
});


$("#mybutton").click(function() {
	$.ajax("/sub39/link3").then(
		function() {
			console.log("성공");
		},
		function() {
			console.log("실패");
		}
	).always(function() {
		console.log("완료");
	});
});

$("#btn9").click(function() {


	$.ajax("/sub39/link9")
		.done(function(data) {
			console.log("done 메소드 사용, 성공")
			console.log(data)
		})
		.fail(function() {
			console.log("fail 메소드 사용, 실패")
		})
		.always(function() {
			console.log("always 메소드 사용, 성공이든 실패든 실행")
		});
});



$("#btn10").click(function() {
	$.ajax("/sub39/link10", {
		success: function(data) {
			console.log("성공")
			console.log(data)
		}
	});
});

$("#btn11").click(function() {
	$.ajax("/sub39/link11", {
		success: function(data) {
			$("#res11").text(data.name + " age = " + data.age);
		}
	});
});

$("#btn12").click(function(){
	
	$.ajax("/sub39/link12",{
		success:function(data){
			console.log(data.address);
			console.log(data.city);
			console.log(data.phone);
			$("#res12").text(data.address + data.city + data.phone)
		}
		
	})
})


$("#btn13").click(function(){
$.ajax("/sub39/link13",{
	success:function(data){
		const list = $("#res13 ul");
		list.empty();
		for(let i = 0; i < data.length; i++){
				list.append('<li>' + data[i] + '</li>');
			}
		}
	})

})




$("#btn14").click(function() {
	const cid = $("#categoryIdInput").val();
	
	$.ajax("/sub39/link14?cid=" + cid, {
		success: function(data) {
			// console.log(data);
			$("#res14").empty();
			for (let i = 0; i < data.length; i++) {
				$("#res14").append(data[i].productName + "<br>");
			}
		}
	})
})

$("#btn15").click(function() {
	const cid = $("#categoryIdInput").val();
	
	$.ajax("/sub39/link14?cid=" + cid, {
		success: function(data) {
			// console.log(data);
			$("#res15").empty();
			$("#res15").append(`
				<table class="table">
					<thead>
						<tr>
							<th>
								상품명
							</th>
							<th>
								가격
							</th>
						</tr>
					</thead>
				</table>
			`);
			$("#res15 > .table").append("<tbody />");
			for (let i = 0; i < data.length; i++) {
				$("#res15 tbody")
					.append(`
						<tr>
							<td>
								${data[i].productName}
							</td>
							<td>
								${data[i].price}
							</td>
						</tr>
					`);
			}
		}
	})
})







