package top.codekiller.mall.controller.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.codekiller.mall.pojo.User;
import top.codekiller.mall.service.user.UserQueryService;
import top.codekiller.mall.service.user.UserUpdateService;
import top.codekiller.mall.utils.ControllerUtils;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

/**
 * @author codekiller
 * @date 2021/7/11 14:37
 * @Description TODO
 */
@Controller
@Slf4j
public class UserController {
    @Autowired
    private UserQueryService userQueryService;

    @Autowired
    private UserUpdateService userUpdateService;

    /**
    * @Description 登录
    * @date 2021/7/11 17:06
    * @param userName  
    * @param password  
    * @return java.lang.String
    */
    @RequestMapping("/login")
    public String login(String userName,String password){
        Long res = userQueryService.login(userName, password);
        return res!=0?"redirect:/main?id="+res:"redirect:/index.html?msg="+BaseController.getUTF8Param("用户名或密码错误");
    }

    /**
    * @Description 注册
    * @date 2021/7/11 17:07
    * @param userInfo
    * @return void
    */
    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> register(@RequestBody User userInfo){
        int res = userUpdateService.register(userInfo.getUserName(),userInfo.getPassword());
        if(res==1){
            return ResponseEntity.ok(ControllerUtils.getPublicBackValue(HttpStatus.OK.value(), "注册成功"));
        }else{
            return ResponseEntity.ok(ControllerUtils.getPublicBackValue(HttpStatus.BAD_REQUEST.value(), "注册失败"));
        }
    }

    /**
    * @Description 去到主界面
    * @date 2021/7/11 17:07
    * @param id
    * @param request
    * @return java.lang.String
    */
    @RequestMapping("/main")
    public String main(Long id, HttpServletRequest request){
        User user = this.userQueryService.queryUserById(id);
        if(user==null){
            return "redirect:/index.html?msg="+BaseController.getUTF8Param("用户名或密码错误");
        }
        request.setAttribute("userName",user.getUserName());
        return "/main";
    }

    /**
    * @Description 退出
    * @date 2021/7/11 17:07
    * @return java.lang.String
    */
    @RequestMapping("/exit")
    public String exit(HttpServletRequest request){
        request.removeAttribute("userName");
        return "redirect:/index.html";
    }


}
