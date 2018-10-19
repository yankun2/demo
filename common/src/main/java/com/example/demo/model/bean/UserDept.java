package com.example.demo.model.bean;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @author yankun
 *
 * @date 2018年8月13日 16:28:54
 */
@Table(name = "user_dept")
public class UserDept implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

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
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return department_id
     */
    public Integer getDepartmentId() {
        return departmentId;
    }

    /**
     * @param departmentId
     */
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}