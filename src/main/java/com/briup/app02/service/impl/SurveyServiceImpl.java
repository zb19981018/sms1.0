package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Survey;
import com.briup.app02.dao.SurveyMapper;
import com.briup.app02.service.ISurveyService;

@Service

public class SurveyServiceImpl implements ISurveyService {
	@Autowired
	private SurveyMapper surveyMapper;
	@Override
	public List<Survey> findAll() throws Exception{
		List<Survey> list=surveyMapper.findAll();
		return list;
		
	}
	@Override
	public Survey findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return surveyMapper.findById(id);
	}
	@Override
	public void deleteById(long id) throws Exception {
		Survey Survey=surveyMapper.findById(id);
		if(Survey !=null){
			surveyMapper.deleteById(id);
		}else{
			throw new Exception("要删除的Survey不存在");
		}
		
	}
	@Override
	public void save(Survey survey) throws Exception {
		surveyMapper.save(survey);
		
	}
	@Override
	public void update(Survey survey) throws Exception {
		surveyMapper.update(survey);
		
	}

}

