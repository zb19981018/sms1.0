package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Clazz;
import com.briup.app02.dao.ClazzMapper;
import com.briup.app02.dao.extend.ClazzVMMapper;
import com.briup.app02.service.IClazzService;
import com.briup.app02.vm.ClazzVM;


@Service

public class ClazzServiceImpl implements IClazzService {
	@Autowired
	private ClazzMapper clazzMapper;
	@Autowired
	
	private ClazzVMMapper clazzVMMapper;
		
	
	@Override
	public List<Clazz> findAll() throws Exception {
		return clazzMapper.findAll();
	}

	@Override
	public List<ClazzVM> findAllClazzVM() throws Exception {
		return clazzVMMapper.findAllClazzVM();
	}



	
	@Override
	public Clazz findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return clazzMapper.findById(id);
	}
	@Override
	public void deleteById(long id) throws Exception {
		Clazz clazz=clazzMapper.findById(id);
		if(clazz !=null){
			clazzMapper.deleteById(id);
		}else{
			throw new Exception("要删除的Clazz不存在");
		}
		
	}
	@Override
	public void save(Clazz clazz) throws Exception {
		clazzMapper.save(clazz);
		
	}
	@Override
	public void update(Clazz clazz) throws Exception {
		clazzMapper.update(clazz);
		
	}

}
