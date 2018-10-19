package com.example.demo.util;


import com.example.demo.model.bean.User;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * @Description: excel校验
 * @Author: yankun
 * @Date: 2018-08-28 15:36
 */
public class ExcelValid {


    /**
     * 校验注解上面的内容，不通过的返回提示
     * @param obj    校验的bean
     * @param groups 校验的分组接口类
     * @return
     */
    public static Set<ConstraintViolation<Object>> excelValid(Object obj, Class<?>... groups){
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();
        return validator.validate(obj,groups);
    }

    /**
     * 校验注解上面的内容，不通过的返回提示
     * @param obj    校验的bean
     * @param groups 校验的分组接口类
     * @return
     */
    public static String excelValid4Str(Object obj, Class<?>... groups){
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();
        StringBuffer retrunMsg = new StringBuffer();
        Set<ConstraintViolation<Object>> set = validator.validate(obj,groups);
        for (ConstraintViolation<Object> constraintViolation : set) {
            retrunMsg.append(constraintViolation.getMessage()).append(";");
            //System.out.println(constraintViolation.getMessage() + "---" + constraintViolation.toString());
        }
        return retrunMsg.toString();
    }





    public static void main(String[] args) {
        User u = new User();
        u.setUserName("222");
        User u2 = new User();

        System.out.println(excelValid(u));

        System.out.println("2222");

        System.out.println(excelValid(u2));

        System.out.println("3333");
        System.out.println(excelValid(u2, User.User2.class));

    }
}
