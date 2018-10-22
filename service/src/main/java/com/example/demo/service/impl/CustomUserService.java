//package com.example.demo.service.impl;
//
//import Department;
//import Role;
//import User;
//import DepartmentMapper;
//import RoleMapper;
//import UserDeptMapper;
//import UserMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
///**
// * 用于将用户权限交给 springsecurity 进行管控
// *
// * @author yankun
// */
//@Repository
//public class CustomUserService implements UserDetailsService {
//    @Autowired
//    private UserMapper userMapper;
//
//    @Autowired
//    private RoleMapper roleMapper;
//
//    @Autowired
//    protected DepartmentMapper departmentMapper;
//
//    @Autowired
//    protected UserDeptMapper userDeptMapper;
//
//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        User user = userMapper.findByUserName(userName);
//        if (user == null) {
//            throw new UsernameNotFoundException("用户名不存在");
//        }
//
//        List<Department> departments = userDeptMapper.findDeptByUserId(user.getId());
//
//        if (departments == null || departments.size()<= 0) {
//            throw new UsernameNotFoundException("用户组织不存在");
//        }
//
//        //用于添加用户的权限。只要把用户权限添加到authorities 就万事大吉。
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//
//        // 加载登陆用户拥有的角色
//        List<Role> roles = roleMapper.findByDeptId(departments.get(0).getId());
//
//        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//        GrantedAuthority authority;
//        if (roles != null && roles.size() > 0) {
//            for (Role role : roles) {
//                authority = new SimpleGrantedAuthority(role.getName());
//                grantedAuthorities.add(authority);
//            }
//        }
//        return new org.springframework.security.core.userdetails.User(user.getUserName(),
//                user.getPassword(), authorities);
//    }
//}