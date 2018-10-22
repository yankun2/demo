package com.example.demo.mapper;

import com.example.demo.bean.Department;
import com.example.demo.bean.UserDept;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserDeptMapper extends Mapper<UserDept> {

    List<Department> findDeptByUserId(int userId);
}