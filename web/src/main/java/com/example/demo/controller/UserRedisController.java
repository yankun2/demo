package com.example.demo.controller;

import com.example.demo.enum2.SexEnum;
import com.example.demo.bean.User;
import com.example.demo.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.*;
import java.util.Set;


/**
 * @author yankun
 *
 * @date 2018年8月13日 16:28:54
 */

@Api(tags="userRedis测试类",value="userRedis测试类")
@Controller
@RequestMapping("useredis")
public class UserRedisController {

    @Autowired
    private IUserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 获取用户
     * @param request
     * @param response
     */
    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "query")
    @RequestMapping(value = "getUser", method = RequestMethod.GET)
    public void getUser(HttpServletRequest request, HttpServletResponse response){
        User user = new User();
        user.setId(111);
        redisTemplate.opsForValue().set("bb",user);

       //BeanCopier.create().copy();
    }

    /**
     * 保存用户数据
     * @param
     * @param
     */
    @ApiOperation(value = "保存用户数据" , notes = "保存最新的用户数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName",value = "用户名",dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password",value = "用户密码",dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sex2",value = "用户性别",dataType = "int", paramType = "query")
    })
    @RequestMapping(value = "saveUser",method = RequestMethod.POST)
    public String saveUser(@ApiIgnore HttpServletRequest request ,@ApiIgnore Integer sex2, @ApiIgnore User user){
        //user.set

        String sex21 = request.getParameter("sex2");

        Object sex22 = request.getAttribute("sex2");
        user.setSex(SexEnum.byCode(sex2));
       int i =  userService.saveUser(user);
        System.out.println(i);
        return i+"";
    }


    @ApiOperation(value="获取用户详细信息", notes="根据用户名来获取用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",dataType = "int",value = "用户ID", paramType = "query"),
            @ApiImplicitParam(name = "userName",value = "用户名",dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password",value = "用户密码",dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "findByUserName",method = RequestMethod.GET)
    public void findByUserName(HttpServletRequest request, HttpServletResponse response, @ApiIgnore @Valid User user){

        userService.findByUserName(user.getUserName());
    }


    public static void main(String[] args) {
        User u = new User();
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();

        Validator validator = vf.getValidator();
        Set<ConstraintViolation<User>> set = validator.validate(u);
        for (ConstraintViolation<User> constraintViolation : set) {
            System.out.println(constraintViolation.getMessage());
        }
    }


}
