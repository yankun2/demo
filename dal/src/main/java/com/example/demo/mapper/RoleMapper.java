package com.example.demo.mapper;

import com.example.demo.bean.Role;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoleMapper extends Mapper<Role> {
    /**
     * 根据组织id获取对应的权限
     * @param id
     * @return
     */
    List<Role> findByDeptId(int id);
}