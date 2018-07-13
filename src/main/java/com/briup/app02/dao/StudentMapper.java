package com.briup.app02.dao;

import java.util.List;


import com.briup.app02.bean.Student;

public interface StudentMapper {
	// 查询所有学生信息
	List<Student> findAll();
	
	// 通过id查询学生信息
	Student findById(long id);
	/*
	Student insert(@Param("id")long id,@Param("name")String name,@Param("age")Integer age); 
	Student updateById(@Param("id")long id,@Param("name")String name,@Param("age")Integer age);
	*/
	void save(Student student);
	void update(Student student);
	void deleteById(long id);
}
