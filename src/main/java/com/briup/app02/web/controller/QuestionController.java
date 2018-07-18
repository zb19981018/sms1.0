package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Question;
import com.briup.app02.service.IQuestionService;
import com.briup.app02.util.MsgResponse;

@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private IQuestionService questionService;
	@GetMapping("deleteQuestionById")
	public MsgResponse deleteQuestionById(long id){
		try {
			questionService.deleteById(id);
			return MsgResponse.success("删除成功",null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@PostMapping("updateQuestion")
	public MsgResponse update(Question Question){
		try {
			questionService.update(Question);
			return MsgResponse.success("更新成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@PostMapping("saveQuestion")
	public MsgResponse save(Question Question){
		try {
			questionService.save(Question);
			return MsgResponse.success("保存成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@GetMapping("findAllQuestion")
	public MsgResponse findAll(){
		try {
			List<Question> list=questionService.findAll();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@GetMapping("findQuestionById")
	public MsgResponse findById(long id){
		try {
			Question Question=questionService.findById(id);
			return MsgResponse.success("查询成功", Question);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	

}

