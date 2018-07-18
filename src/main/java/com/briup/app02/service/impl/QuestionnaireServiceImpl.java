package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Questionnaire;
import com.briup.app02.dao.QuestionnaireMapper;
import com.briup.app02.service.IQuestionnaireService;

@Service

public class QuestionnaireServiceImpl implements IQuestionnaireService {
	@Autowired
	private QuestionnaireMapper questionnaireMapper;
	@Override
	public List<Questionnaire> findAll() throws Exception{
		List<Questionnaire> list=questionnaireMapper.findAll();
		return list;
		
	}
	@Override
	public Questionnaire findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return questionnaireMapper.findById(id);
	}
	@Override
	public void deleteById(long id) throws Exception {
		Questionnaire Questionnaire=questionnaireMapper.findById(id);
		if(Questionnaire !=null){
			questionnaireMapper.deleteById(id);
		}else{
			throw new Exception("要删除的Questionnaire不存在");
		}
		
	}
	@Override
	public void save(Questionnaire questionnaire) throws Exception {
		questionnaireMapper.save(questionnaire);
		
	}
	@Override
	public void update(Questionnaire questionnaire) throws Exception {
		questionnaireMapper.update(questionnaire);
		
	}

}
