package com.example.demo.model.mapper;

import com.example.demo.model.bean.Department;
import com.example.demo.model.bean.UserDept;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserDeptMapper extends Mapper<UserDept> {

    List<Department> findDeptByUserId(int userId);
}