package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Qq;
import com.briup.app02.service.IQqService;
import com.briup.app02.util.MsgResponse;

@RestController
@RequestMapping("/qq")
public class QqController {
	@Autowired
	private IQqService qqService;
	@GetMapping("deleteQqById")
	public MsgResponse deleteQqById(long id){
		try {
			qqService.deleteById(id);
			return MsgResponse.success("删除成功",null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@PostMapping("updateQq")
	public MsgResponse update(Qq Qq){
		try {
			qqService.update(Qq);
			return MsgResponse.success("更新成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@PostMapping("saveQq")
	public MsgResponse save(Qq Qq){
		try {
			qqService.save(Qq);
			return MsgResponse.success("保存成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@GetMapping("findAllQq")
	public MsgResponse findAll(){
		try {
			List<Qq> list=qqService.findAll();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@GetMapping("findQqById")
	public MsgResponse findById(long id){
		try {
			Qq Qq=qqService.findById(id);
			return MsgResponse.success("查询成功", Qq);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	

}

