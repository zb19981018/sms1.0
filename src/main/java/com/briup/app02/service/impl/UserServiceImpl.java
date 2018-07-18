package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.User;
import com.briup.app02.dao.UserMapper;
import com.briup.app02.service.IUserService;

@Service

public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper userMapper;
	@Override
	public List<User> findAll() throws Exception{
		List<User> list=userMapper.findAll();
		return list;
		
	}
	@Override
	public User findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.findById(id);
	}
	@Override
	public void deleteById(long id) throws Exception {
		User User=userMapper.findById(id);
		if(User !=null){
			userMapper.deleteById(id);
		}else{
			throw new Exception("要删除的User不存在");
		}
		
	}
	@Override
	public void save(User user) throws Exception {
		userMapper.save(user);
		
	}
	@Override
	public void update(User user) throws Exception {
		userMapper.update(user);
		
	}

}

