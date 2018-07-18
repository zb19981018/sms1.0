package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Answer;
import com.briup.app02.dao.AnswerMapper;
import com.briup.app02.service.IAnswerService;

@Service

public class AnswerServiceImpl implements IAnswerService {
	@Autowired
	private AnswerMapper answerMapper;
	@Override
	public List<Answer> findAll() throws Exception{
		List<Answer> list=answerMapper.findAll();
		return list;
		
	}
	@Override
	public Answer findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return answerMapper.findById(id);
	}
	@Override
	public void deleteById(long id) throws Exception {
		Answer answer=answerMapper.findById(id);
		if(answer !=null){
			answerMapper.deleteById(id);
		}else{
			throw new Exception("要删除的Answer不存在");
		}
		
	}
	@Override
	public void save(Answer answer) throws Exception {
		answerMapper.save(answer);
		
	}
	@Override
	public void update(Answer answer) throws Exception {
		answerMapper.update(answer);
		
	}

}
