package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Qq;
import com.briup.app02.dao.QqMapper;
import com.briup.app02.service.IQqService;

@Service

public class QqServiceImpl implements IQqService {
	@Autowired
	private QqMapper qqMapper;
	@Override
	public List<Qq> findAll() throws Exception{
		List<Qq> list=qqMapper.findAll();
		return list;
		
	}
	@Override
	public Qq findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return qqMapper.findById(id);
	}
	@Override
	public void deleteById(long id) throws Exception {
		Qq Qq=qqMapper.findById(id);
		if(Qq !=null){
			qqMapper.deleteById(id);
		}else{
			throw new Exception("要删除的Qq不存在");
		}
		
	}
	@Override
	public void save(Qq qq) throws Exception {
		qqMapper.save(qq);
		
	}
	@Override
	public void update(Qq qq) throws Exception {
		qqMapper.update(qq);
		
	}

}
