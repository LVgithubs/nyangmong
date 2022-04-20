// 즐겨찾기
		// $(".btn-favlist").click(function() {
		// 	alert("상품을 즐겨찾기에 추가하였습니다.");
		// });

var productId = $("#productId").val();
var userid = $("#login_userid").val();
        
$(".btn-favlist").click(function() {
			
			$.ajax({
				
				type : "post",
				url : "/favlist/" + productId,
				data : {
					productId : productId
				},
				dataType : "text",
				success : function(result) {
					
					if (result.trim() == 'add_success') {
						var check = confirm("즐겨찾기에 등록되었습니다.");
						if (check) {
							location.assign("/user/{id}/favlist" + userid);
						}
					} else if (result.trim() == 'already_existed') {
						alert("이미 즐겨찾기에 등록된 상품입니다.");
					}
				}
			});
		});