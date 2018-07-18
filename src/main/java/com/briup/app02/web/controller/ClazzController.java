package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Clazz;
import com.briup.app02.service.IClazzService;
import com.briup.app02.util.MsgResponse;
import com.briup.app02.vm.ClazzVM;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(description="班级相关接口")
@RestController
@RequestMapping("/clazz")
public class ClazzController {
	@Autowired
	private IClazzService clazzService;
	@ApiOperation(value="查询所有班级",
			notes="只能查询出班级的基本信息，并且级联查询到年级和班主任")
	
	@GetMapping("deleteClazzById")
	public MsgResponse deleteClazzById(long id){
		try {
			clazzService.deleteById(id);
			return MsgResponse.success("删除成功",null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@PostMapping("updateClazz")
	public MsgResponse update(Clazz Clazz){
		try {
			clazzService.update(Clazz);
			return MsgResponse.success("更新成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@PostMapping("saveClazz")
	public MsgResponse save(Clazz Clazz){
		try {
			clazzService.save(Clazz);
			return MsgResponse.success("保存成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@GetMapping("findAllClazzVM")
	public MsgResponse findAllClazzVM(){
		try {
			List<ClazzVM> list=clazzService.findAllClazzVM();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	// http://ip:port/clazz/findAllClazz
		@ApiOperation(value="查询所有班级"
				,notes="只能查询出班级的基本信息，无法级联查询到年级和班主任")
		@GetMapping("findAllClazz")
		public MsgResponse findAllClazz(){
			try {
				List<Clazz> list = clazzService.findAll();
				return MsgResponse.success("success", list);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
	
	@GetMapping("findClazzById")
	public MsgResponse findById(long id){
		try {
			Clazz clazz=clazzService.findById(id);
			return MsgResponse.success("查询成功", clazz);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	

}

