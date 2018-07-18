package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Course;
import com.briup.app02.service.ICourseService;
import com.briup.app02.util.MsgResponse;

@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private ICourseService courseService;
	@GetMapping("deleteCourseById")
	public MsgResponse deleteCourseById(long id){
		try {
			courseService.deleteById(id);
			return MsgResponse.success("删除成功",null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@PostMapping("updateCourse")
	public MsgResponse update(Course Course){
		try {
			courseService.update(Course);
			return MsgResponse.success("更新成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@PostMapping("saveCourse")
	public MsgResponse save(Course Course){
		try {
			courseService.save(Course);
			return MsgResponse.success("保存成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@GetMapping("findAllCourse")
	public MsgResponse findAll(){
		try {
			List<Course> list=courseService.findAll();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@GetMapping("findCourseById")
	public MsgResponse findById(long id){
		try {
			Course course=courseService.findById(id);
			return MsgResponse.success("查询成功", course);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	

}
