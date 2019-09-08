$(function($){
	$("input[type='checkbox']").click(function(){
		var test = $(this).prop("checked")
		if(test){
			$("button").removeAttr("disabled");
		}else{
			$("button").attr("disabled","disabled");
		}
	})
})