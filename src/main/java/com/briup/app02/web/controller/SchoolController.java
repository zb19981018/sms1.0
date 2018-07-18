package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.School;
import com.briup.app02.service.ISchoolService;
import com.briup.app02.util.MsgResponse;

@RestController
@RequestMapping("/school")
public class SchoolController {
	@Autowired
	private ISchoolService schoolService;
	@GetMapping("deleteSchoolById")
	public MsgResponse deleteSchoolById(long id){
		try {
			schoolService.deleteById(id);
			return MsgResponse.success("删除成功",null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@PostMapping("updateSchool")
	public MsgResponse update(School School){
		try {
			schoolService.update(School);
			return MsgResponse.success("更新成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@PostMapping("saveSchool")
	public MsgResponse save(School School){
		try {
			schoolService.save(School);
			return MsgResponse.success("保存成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@GetMapping("findAllSchool")
	public MsgResponse findAll(){
		try {
			List<School> list=schoolService.findAll();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@GetMapping("findSchoolById")
	public MsgResponse findById(long id){
		try {
			School School=schoolService.findById(id);
			return MsgResponse.success("查询成功", School);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	

}


