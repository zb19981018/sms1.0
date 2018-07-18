package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Survey;
import com.briup.app02.service.ISurveyService;
import com.briup.app02.util.MsgResponse;

@RestController
@RequestMapping("/survey")
public class SurveyController {
	@Autowired
	private ISurveyService surveyService;
	@GetMapping("deleteSurveyById")
	public MsgResponse deleteSurveyById(long id){
		try {
			surveyService.deleteById(id);
			return MsgResponse.success("删除成功",null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@PostMapping("updateSurvey")
	public MsgResponse update(Survey survey){
		try {
			surveyService.update(survey);
			return MsgResponse.success("更新成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@PostMapping("saveSurvey")
	public MsgResponse save(Survey survey){
		try {
			surveyService.save(survey);
			return MsgResponse.success("保存成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@GetMapping("findAllSurvey")
	public MsgResponse findAll(){
		try {
			List<Survey> list=surveyService.findAll();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@GetMapping("findSurveyById")
	public MsgResponse findById(long id){
		try {
			Survey Survey=surveyService.findById(id);
			return MsgResponse.success("查询成功", Survey);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	

}

