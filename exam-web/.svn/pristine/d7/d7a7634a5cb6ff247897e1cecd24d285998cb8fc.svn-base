package org.hnjk.service.impl;

import java.util.Iterator;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.hnjk.service.ExamPaperAnswerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.whalin.MemCached.MemCachedClient;

@Service
public class ExamPaperAnswerServiceImpl implements ExamPaperAnswerService {
	Logger logger = LoggerFactory.getLogger(ExamPaperAnswerServiceImpl.class);
	@Autowired
	private MemCachedClient memCachedClient;
	
	@Override
	public void saveAnswer(String paperId, String answerStr) {
		String temAnswerStr = answerStr;
		
		JSONObject jsonObj = JSONObject.parseObject(answerStr);
		
		String memCacheAnswerStr = memCachedClient.get(paperId)==null?null:memCachedClient.get(paperId).toString();
		
		if(!StringUtils.isBlank(memCacheAnswerStr)) {//此试卷存在上次的缓存标记
			JSONObject answerObj = JSONObject.parseObject(memCacheAnswerStr);
			Set<String> keySet = jsonObj.keySet();
			for (Iterator<String> iterator = keySet.iterator(); iterator.hasNext();) {
				String keyStr = (String) iterator.next();//新标记值的key
				answerObj.put(keyStr, jsonObj.get(keyStr));
			}
			temAnswerStr = JSONObject.toJSONString(answerObj);
		}
		
		memCachedClient.set(paperId, temAnswerStr);
		
		logger.info(memCachedClient.get(paperId).toString());
	}

	@Override
	public String getAnswerByPaperId(String paperId) {
		return memCachedClient.get(paperId)==null?"":memCachedClient.get(paperId).toString();
	}

	@Override
	public void saveMark(String paperId, String mark) {
		String temMarkStr = mark;
		
		JSONObject jsonObj = JSONObject.parseObject(mark);
		
		String memCacheMarkStr = memCachedClient.get(paperId+"_mark")==null?null:memCachedClient.get(paperId+"_mark").toString();
		
		if(!StringUtils.isBlank(memCacheMarkStr)) {//此试卷存在上次的缓存标记
			JSONObject markObj = JSONObject.parseObject(memCacheMarkStr);
			Set<String> keySet = jsonObj.keySet();
			for (Iterator<String> iterator = keySet.iterator(); iterator.hasNext();) {
				String keyStr = (String) iterator.next();//新标记值的key
				markObj.put(keyStr, jsonObj.get(keyStr));
			}
			temMarkStr = JSONObject.toJSONString(markObj);
		}
		
		memCachedClient.set(paperId+"_mark", temMarkStr);
		
		logger.info(memCachedClient.get(paperId+"_mark").toString());
		
	}

	@Override
	public String getMarkQuestionsByPaperId(String paperId) {
		return memCachedClient.get(paperId+"_mark")==null?"":memCachedClient.get(paperId+"_mark").toString();
	}

}
