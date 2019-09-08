package org.hnjk.remote.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("courseware-service")
public interface CoursewareResourceService {
	@GetMapping(value="/resource/courseware/getId/{coursewareCode}")
	public String getCoursewareIdByCode(@PathVariable(value="coursewareCode", required=true) String coursewareCode);
}
