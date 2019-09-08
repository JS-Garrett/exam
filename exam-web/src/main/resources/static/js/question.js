var canChoice = true;
var timer=null;
$(function($) {
	//默认显示第一个
	var global_first_question_index_id = $(".left-container .question_module:first .question-index-block:first").attr("id");
	var global_last_question_index_id = $(".left-container .question_module:last .question-index-block:last").attr("id");
	var question_content_id = global_first_question_index_id.replace("q_","c_");
	$(".right-container #"+question_content_id).removeClass("question_hide");
	$(".right-container #"+question_content_id).addClass("question_show");
	$(".left-container .question_module:first .question-index-block:first").css({"border": "1px solid red"});
	var current_question_index_id = global_first_question_index_id;
	
	var answer = new Map();
	var mark = new Map();
	
	
	//答题卡选择的题目
	$(".left-container .question-index-block").click(function(){
		//获取题目内容ID
		current_question_index_id = this.id;//当前选择的题目ID
		var question_content_id = current_question_index_id.replace("q_","c_");
		
		$(".left-container").find(".question-index-block").css({"border": ""});
		$(this).css({"border": "1px solid red"});
		
		$(".right-container #"+question_content_id).siblings().not(".control_button").removeClass("question_show");
		$(".right-container #"+question_content_id).siblings().not(".control_button").addClass("question_hide");
		
		$(".right-container #"+question_content_id).removeClass("question_hide").addClass("question_show");
		
		$(".right-container #"+question_content_id +" .question_num").text($("#"+this.id+" div").text()+"、");
		
		if(current_question_index_id==global_first_question_index_id){
			$(".right-container .prev").attr("disabled","disabled");
			$(".right-container .next").removeAttr("disabled");
		}else if(current_question_index_id==global_last_question_index_id){
			$(".right-container .next").attr("disabled","disabled");
			$(".right-container .prev").removeAttr("disabled");
		}else{
			$(".right-container .prev").removeAttr("disabled");
			$(".right-container .next").removeAttr("disabled");
		}
	});
	
	//上一题
	$(".right-container .prev").click(function(){
		var question_type_first_index_id = $("#"+current_question_index_id).parent().children(".question-index-block").first().attr("id");
		var pre_question_index_id,pre_question_content_id;
		//隐藏当前显示的题目，显示上一题
		if(current_question_index_id==global_first_question_index_id){//判断当前显示的题目是否是第一题型类的第一个
			alert("当前是第一个题目！");
			return;
		}else if(current_question_index_id==question_type_first_index_id){//判断当前显示的题目是否是当前题型类的第一个
			pre_question_index_id = $("#"+current_question_index_id).parent().prev().children(".question-index-block").last().attr("id");
		}else{//选择自己前面的一个
			pre_question_index_id = $("#"+current_question_index_id).prev().attr("id");
		}
		$("#"+current_question_index_id).css({"border": ""});
		pre_question_content_id = pre_question_index_id.replace("q_","c_");
		var current_question_content_id = current_question_index_id.replace("q_","c_");
		$("#"+current_question_content_id).removeClass("question_show").addClass("question_hide");
		$("#"+pre_question_content_id).removeClass("question_hide").addClass("question_show");
		$("#"+pre_question_content_id +" .question_num").text($("#"+pre_question_index_id+" div").text()+"、");
		current_question_index_id = pre_question_index_id;
		
		$("#"+current_question_index_id).css({"border": "1px solid red"});
		
		if(pre_question_index_id==global_first_question_index_id){
			$(this).attr("disabled","disabled");
		}else{
			$(".right-container .next").removeAttr("disabled");
		}
	})
	
	//标记
	$(".right-container .mark").click(function(){
		 var current_question_id = current_question_index_id.replace("q_","");
		 
		 var cmarked = $("#"+current_question_index_id+" .innerMarked").val();
		 if(cmarked=="1"){
			 mark.set(current_question_id,"0");
			 $("#"+current_question_index_id+" div").removeClass("question-index-block-oranage-color").addClass("question-index-block-grey-color");
			 $("#"+current_question_index_id+" .innerMarked").val("0")
		 }else{
			 if(mark.get(current_question_id)==undefined || mark.get(current_question_id)=="" || mark.get(current_question_id)=="0") {
				 mark.set(current_question_id,"1");
				 $("#"+current_question_index_id+" div").addClass("question-index-block-oranage-color").removeClass("question-index-block-grey-color");
				 $("#"+current_question_index_id+" .innerMarked").val("1")
			 }else{
				 mark.set(current_question_id,"0");
				 $("#"+current_question_index_id+" div").removeClass("question-index-block-oranage-color").addClass("question-index-block-grey-color");
				 $("#"+current_question_index_id+" .innerMarked").val("0")
			 }
		 }
		 
		 var mapStr = MapTOJson(mark);
		 var access_token = $("#access_token").val();	
		 var paperId = $("#paperId").val();
		 $.post("/exam/mark",{"paperId":paperId,"mark":mapStr,"access_token":access_token});
	})
	
	//下一题
	$(".right-container .next").click(function(){
		var question_type_last_index_id = $("#"+current_question_index_id).parent().children(".question-index-block").last().attr("id");
		var next_question_index_id,next_question_content_id;
		//隐藏当前显示的题目，显示下一题
		if(current_question_index_id==global_last_question_index_id){//判断当前显示的题目是否是最后一题型类的最后一个
			alert("当前是最后一个题目！");
			return;
		}else if(current_question_index_id==question_type_last_index_id){//判断当前显示的题目是否是当前题型类的最后一个
			next_question_index_id = $("#"+current_question_index_id).parent().next().children(".question-index-block").first().attr("id");
		}else{//选择自己后面的一个
			next_question_index_id = $("#"+current_question_index_id).next().attr("id");
		}
		$("#"+current_question_index_id).css({"border": ""});
		next_question_content_id = next_question_index_id.replace("q_","c_");
		var current_question_content_id = current_question_index_id.replace("q_","c_");
		$("#"+current_question_content_id).removeClass("question_show").addClass("question_hide");
		$("#"+next_question_content_id).removeClass("question_hide").addClass("question_show");
		$("#"+next_question_content_id +" .question_num").text($("#"+next_question_index_id+" div").text()+"、");
		current_question_index_id = next_question_index_id;
		$("#"+current_question_index_id).css({"border": "1px solid red"});
		if(next_question_index_id==global_last_question_index_id){
			$(this).attr("disabled","disabled");
		}else{
			$(".right-container .prev").removeAttr("disabled");
		}
	})
	
	//做题选择答案
	$(".right-container .option_block").click(function(){
		if(!canChoice) return;
		$("#"+current_question_index_id +" div").css({"background": "#33ff99"});
		
		//获取题目类型
		var current_question_content_id = current_question_index_id.replace("q_","c_");
		var question_type = $("#"+current_question_content_id).attr("type");
		
		var current_question_id = current_question_index_id.replace("q_","");
		var current_question_option_id = this.id.replace("o_","");
		
		if("1"==question_type){//单选题 只能选一个
			$(this).children(".option_dot").addClass("option_selected");
			$(this).siblings().children(".option_dot").removeClass("option_selected");
			if(answer.get(current_question_id) == current_question_option_id){//取消选择
				current_question_option_id = "";
				$("#"+current_question_index_id+" div").css({"background": "#EAEAEA"});
				$(this).children(".option_dot").removeClass("option_selected");
			}
			answer.set(current_question_id,current_question_option_id);
		}else if("2"==question_type){//多选题
			var current_question_option_array = answer.get(current_question_id)?answer.get(current_question_id).split(','):[];
			if(current_question_option_array.indexOf(current_question_option_id)==-1){//答案不在答案中， 未选择
				current_question_option_array.push(current_question_option_id);
				$(this).children(".option_dot").addClass("option_selected");
			}else{//如果答案之前被选择，再次点击取消选择
				current_question_option_array.splice(current_question_option_array.indexOf(current_question_option_id),1);
				if(current_question_option_array.length==0){
					$("#"+current_question_index_id+" div").css({"background": "#EAEAEA"});
				}
				$(this).children(".option_dot").removeClass("option_selected");
			}
			current_question_option_id = current_question_option_array.toString();
			answer.set(current_question_id,current_question_option_id);
			
		}else if("3"==question_type){//判断题
			$(this).children(".option_dot").addClass("option_selected");
			$(this).siblings().children(".option_dot").removeClass("option_selected");
			if(answer.get(current_question_id) == current_question_option_id){//取消选择
				current_question_option_id = "";
				$("#"+current_question_index_id+" div").css({"background": "#EAEAEA"});
				$(this).children(".option_dot").removeClass("option_selected");
			}
			answer.set(current_question_id,current_question_option_id);
		}
		
		var mapStr = MapTOJson(answer);
		var access_token = $("#access_token").val();
		var paperId = $("#paperId").val();
		$.post("/exam/saveAnswer",{"paperId":paperId,"answer":mapStr,"access_token":access_token});
	})
	
	$("#submitExamPaper").click(function(){
		if(confirm("确定要提交试卷吗？")){
			clearInterval(timer);//清除计时
			reviewExamPaper();
		}
	})
	
	//倒计时
	var time = $("#remainTime").val();
	resetTime(time, show, oper);
});

var show = function(str){
	$("#countTime").text(str);
}

var oper = function(){
	reviewExamPaper();
}

function reviewExamPaper(){
	canChoice = false;
	$("#submitExamPaper").css({"background-color":"#EAEAEA"})
	$("#submitExamPaper").attr("disabled","disabled");
	var access_token = $("#access_token").val();
	var paperId = $("#paperId").val();
	$.post("/exam/inspect", {"paperId":paperId,"access_token":access_token }, function(data){
		console.log(data);
		if(data.code=="00"){
			alert("提交"+data.msg);
			$.each(data.object.result, function(i, question){
				var questionIndex,correctAnswer,choiceAnswer,isCorrect;
				for(var key in question){
					if(key=="id"){
						questionIndex = question[key];
					}
					
					if(key=="correct_answer"){
						correctAnswer = question[key];
					}
					
					if(key=="choice_answer"){
						choiceAnswer = question[key];
					}
					
					if(key=="isCorrect"){
						isCorrect = question[key];
					}
				}
				
				//标记正确错误答案
				if(isCorrect=="1"){
					$("#q_"+questionIndex+" div").css({"background": "#00CD00"});
				}else {
					$("#q_"+questionIndex+" div").css({"background": "#FF0000"});
				}
				
				//题目选项前面显示正确标志
				var correct_arr = correctAnswer.split(",");
				var choice_arr;
				if(choiceAnswer!=undefined && choiceAnswer!="") choice_arr = choiceAnswer.split(",");
				$.each(correct_arr, function(j, option){
					var questionContentIdx = "c_"+questionIndex;
					var optionId = "o_"+option;
					$("#"+questionContentIdx+" #"+optionId+" .choice_flag").append("<img src='/images/correct.png' style='float: left;' />");
				})
				
				//题目选项前面显示错误标志
				$.each(choice_arr, function(x, opt){
					if($.inArray(opt, correct_arr)==-1){//如果选择的答案不在正确答案中
						var questionContentIdx = "c_"+questionIndex;
						var optionId = "o_"+opt;
						$("#"+questionContentIdx+" #"+optionId+" .choice_flag").append("<img src='/images/error.png' style='float: left;' />");
					};
				})
				
			});
			$(".show_score").text("本次得分："+data.object.score);
		}else if(data.code=="01") {
			alert(data.msg+"无法进行提交!");
		}
	})
	return;
}

//单纯分钟和秒倒计时
function resetTime(time, show, oper){
	var s=Number(time);//剩余总的考试时间(分钟转秒)
	var hours = "00";
	var minutes = "00";
	var seconds = "00";
	function countDown(){
		s--;
		if(s==0){
			hours = "00";
			minutes = '00';
			seconds = '00';
			clearInterval(timer);
			oper();//表单提交
		}else{
			var h = Math.floor(s/3600);
			hours = h>=9?h:"0"+h;
			var m = Math.floor((s-h*3600)/60);
			minutes = m>9?m:"0"+m;
			var ss = s-h*3600-m*60;
			seconds = ss>9?ss:"0"+ss;
		}
		show(hours+":"+minutes+":"+seconds);
	}
	timer=setInterval(countDown,1000);
}