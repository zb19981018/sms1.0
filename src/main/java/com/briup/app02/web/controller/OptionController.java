package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Option;
import com.briup.app02.service.IOptionService;
import com.briup.app02.util.MsgResponse;

@RestController
@RequestMapping("/option")
public class OptionController {
	@Autowired
	private IOptionService optionService;
	@GetMapping("deleteOptionById")
	public MsgResponse deleteOptionById(long id){
		try {
			optionService.deleteById(id);
			return MsgResponse.success("删除成功",null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@PostMapping("updateOption")
	public MsgResponse update(Option Option){
		try {
			optionService.update(Option);
			return MsgResponse.success("更新成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@PostMapping("saveOption")
	public MsgResponse save(Option Option){
		try {
			optionService.save(Option);
			return MsgResponse.success("保存成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@GetMapping("findAllOption")
	public MsgResponse findAll(){
		try {
			List<Option> list=optionService.findAll();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@GetMapping("findOptionById")
	public MsgResponse findById(long id){
		try {
			Option option=optionService.findById(id);
			return MsgResponse.success("查询成功", option);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	

}


