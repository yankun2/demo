package com.example.demo.model.bean;


import com.example.demo.enum2.SexEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author yankun
 *
 * @date 2018年8月13日 16:28:54
 */
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "姓名不能为空",groups = {User2.class})
    @Column(name = "user_name")
    private String userName;


    @Column(name = "password")
    private String password;

    @NotNull(message = "性别不能为空")

    @Column(name = "sex")
    private SexEnum sex;

    @Column(name = "department_id")
    private Integer departmentId;

    private static final long serialVersionUID = 1L;


    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return department_id
     */
    public Integer getDepartmentId() {
        return departmentId;
    }


    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    /**
     * @param departmentId
     */
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public interface User2{

    }
}