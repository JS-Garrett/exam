package org.hnjk.controller;

import java.util.List;

import org.hnjk.entity.ResCoursewareObject;
import org.hnjk.service.ResCoursewareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/resource/courseware")
public class ResCoursewareController {
	
	@Autowired
	private ResCoursewareService resCoursewareService;
	
	@GetMapping(value="/getId/{coursewareCode}")
	public String getCoursewareIdByCoursewareCode(@PathVariable(value="coursewareCode", required=true) String coursewareCode) {
		String coursewareId = resCoursewareService.getCoursewareIdByCoursewareCode(coursewareCode);
		
		return coursewareId;
	}
	
	/**
	 * 查询课件列表
	 * @param pageable pageNumber pageSize
	 * @param queryCondition
	 * @return
	 */
	@GetMapping(value="/list")
	public List<ResCoursewareObject> getCoursewareList(@RequestParam(value="queryCondition", required=false) String queryCondition, @RequestParam(value="page", defaultValue="0") int page, @RequestParam(value="size", defaultValue="10") int size) {
		Pageable pageable = PageRequest.of(page,size);
		List<ResCoursewareObject> objs = resCoursewareService.getCoursewareList(queryCondition, pageable);
		return objs;
	}
}
