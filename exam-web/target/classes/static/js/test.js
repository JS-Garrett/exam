$(function($){
	$("#startExam").click(function(){
		var coursewareCode = "00000300308";
		var coursewareName = "测试";
		var accountId = "8080803565370a2b01653768d0010618";
		var accountName = "李文财";
		var classId = "80808035653705ac01653768dc6a0020";
		var sex = "1";
		var phoneNumber = "15915977777";
		var certificateType = "0";
		var certificateNumber = "440181198405267216";
		var examinationCardNumber = "1344011315500202";
		var systemCode = "pzy";
		var access_token;
		
		
		
		$.get("http://localhost:9005/server/oauth/token?grant_type=client_credentials&scope=select&client_id=client_1&client_secret=123456",function(tokendata){
			if(tokendata){
				access_token = tokendata.access_token;
			
				var paramJson = {
						"access_token": access_token,
						"coursewareCode": coursewareCode,
						"accountId": accountId,
						"accountName": accountName,
						"classId": classId,
						"sex": sex,
						"phoneNumber": phoneNumber,
						"certificateType": certificateType,
						"certificateNumber": certificateNumber,
						"examinationCardNumber": examinationCardNumber,
						"systemCode": systemCode,
					}
				
				$.post("/exam/canExam", paramJson, function(data){
					if(data.code=="00"){
						if(data.object.continued){//继续上一次断掉的考试
							var paramS = "?access_token="+access_token+"&coursewareId="+data.object.coursewareId+"&accountId="+accountId
							location.href = data.object.url+paramS
						}else{
							var paramStr = "?access_token="+access_token+"&coursewareId="+data.object.coursewareId+"&accountId="+accountId
							paramStr += "&accountName="+accountName+"&classId="+classId+"&sex="+sex+"&phoneNumber="+phoneNumber
							paramStr += "&certificateType="+certificateType+"&certificateNumber="+certificateNumber+"&examinationCardNumber="+examinationCardNumber
							paramStr += "&systemCode="+systemCode+"&coursewareName="+coursewareName
							location.href = data.object.url+paramStr
						}
					}
				})
			}
		})
		console.log(access_token);
	})
})
