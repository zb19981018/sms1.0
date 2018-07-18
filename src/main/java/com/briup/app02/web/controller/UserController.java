package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.User;
import com.briup.app02.service.IUserService;
import com.briup.app02.util.MsgResponse;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	@GetMapping("deleteUserById")
	public MsgResponse deleteUserById(long id){
		try {
			userService.deleteById(id);
			return MsgResponse.success("删除成功",null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@PostMapping("updateUser")
	public MsgResponse update(User user){
		try {
			userService.update(user);
			return MsgResponse.success("更新成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@PostMapping("saveUser")
	public MsgResponse save(User user){
		try {
			userService.save(user);
			return MsgResponse.success("保存成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@GetMapping("findAllUser")
	public MsgResponse findAll(){
		try {
			List<User> list=userService.findAll();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@GetMapping("findUserById")
	public MsgResponse findById(long id){
		try {
			User User=userService.findById(id);
			return MsgResponse.success("查询成功", User);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	

}
