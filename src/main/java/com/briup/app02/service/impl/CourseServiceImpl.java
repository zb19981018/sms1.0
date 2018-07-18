package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Course;
import com.briup.app02.dao.CourseMapper;
import com.briup.app02.service.ICourseService;

@Service

public class CourseServiceImpl implements ICourseService {
	@Autowired
	private CourseMapper courseMapper;
	@Override
	public List<Course> findAll() throws Exception{
		List<Course> list=courseMapper.findAll();
		return list;
		
	}
	@Override
	public Course findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return courseMapper.findById(id);
	}
	@Override
	public void deleteById(long id) throws Exception {
		Course Course=courseMapper.findById(id);
		if(Course !=null){
			courseMapper.deleteById(id);
		}else{
			throw new Exception("要删除的Course不存在");
		}
		
	}
	@Override
	public void save(Course Course) throws Exception {
		courseMapper.save(Course);
		
	}
	@Override
	public void update(Course Course) throws Exception {
		courseMapper.update(Course);
		
	}

}
