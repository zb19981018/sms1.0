package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Grade;
import com.briup.app02.dao.GradeMapper;
import com.briup.app02.service.IGradeService;

@Service

public class GradeServiceImpl implements IGradeService {
	@Autowired
	private GradeMapper gradeMapper;
	@Override
	public List<Grade> findAll() throws Exception{
		List<Grade> list=gradeMapper.findAll();
		return list;
		
	}
	@Override
	public Grade findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return gradeMapper.findById(id);
	}
	@Override
	public void deleteById(long id) throws Exception {
		Grade Grade=gradeMapper.findById(id);
		if(Grade !=null){
			gradeMapper.deleteById(id);
		}else{
			throw new Exception("要删除的Grade不存在");
		}
		
	}
	@Override
	public void save(Grade Grade) throws Exception {
		gradeMapper.save(Grade);
		
	}
	@Override
	public void update(Grade Grade) throws Exception {
		gradeMapper.update(Grade);
		
	}

}

