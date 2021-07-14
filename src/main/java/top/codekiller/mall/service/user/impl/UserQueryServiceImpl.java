package top.codekiller.mall.service.user.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.codekiller.mall.mapper.UserMapper;
import top.codekiller.mall.pojo.User;
import top.codekiller.mall.service.user.UserQueryService;
import top.codekiller.mall.utils.CodecUtils;

/**
 * @author codekiller
 * @date 2021/7/11 14:37
 * @Description TODO
 */
@Service
public class UserQueryServiceImpl implements UserQueryService {

    @Autowired
    private UserMapper userMapper;

    /**
    * @Description 查询用户
    * @date 2021/7/11 15:16
    * @param userName
    * @param password
    * @return top.codekiller.mall.pojo.User
    */
    @Override
    public User queryUser(String userName, String password) {
        if(StringUtils.isBlank(userName)|| StringUtils.isBlank(password)){
            return null;
        }

        //获取用户信息
        User user = this.userMapper.selectOne(new QueryWrapper<User>().lambda()
                                                .eq(User::getUserName, userName));

        //获取盐
        String slat=user.getSalt();

        //将输入的密码和盐进行加密
        password= CodecUtils.md5Hex(password,slat);


        //两个密码进行匹配
        if(StringUtils.equals(password,user.getPassword())){
            return user;
        }

        return null;
    }

    /**
    * @Description 登录
    * @date 2021/7/11 15:16
    * @param userName
    * @param password
    * @return int
    */
    @Override
    public Long login(String userName,String password) {
        User user = queryUser(userName, password);
        return user==null?0L:user.getId();
    }


    /**
    * @Description 通过id查询用户
    * @date 2021/7/11 17:00
    * @param id
    * @return top.codekiller.mall.pojo.User
    */
    @Override
    public User queryUserById(Long id) {
        return this.userMapper.selectById(id);
    }
}
