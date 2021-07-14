package top.codekiller.mall.service.user.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.codekiller.mall.mapper.UserMapper;
import top.codekiller.mall.pojo.User;
import top.codekiller.mall.service.user.UserUpdateService;
import top.codekiller.mall.utils.CodecUtils;

import java.time.LocalDateTime;

/**
 * @author codekiller
 * @date 2021/7/11 15:20
 * @Description 用户更新，注册服务
 */
@Service
public class UserUpdateServiceImpl implements UserUpdateService {

    @Autowired
    private UserMapper userMapper;

    /**
    * @Description 注册用户
    * @date 2021/7/11 15:23
    * @param userName
    * @param password
    * @return int
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int register(String userName, String password) {
        //先进行查询，看看用户名有没有重复
        User existUser=null;
        existUser=this.userMapper.selectOne(new QueryWrapper<User>().lambda().eq(User::getUserName,userName));
        if(existUser!=null){
            return -1;
        }

        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        //生成盐
        String salt= CodecUtils.generateSalt();
        if(StringUtils.isBlank(salt)){
            return 0;
        }
        user.setSalt(salt);


        //对密码加密并且加盐
        String psw=CodecUtils.md5Hex(user.getPassword(),salt);
        if(StringUtils.isBlank(psw)){
            return 0;
        }
        user.setPassword(psw);

        //新增用户
        user.setId(null);
        user.setCreated(LocalDateTime.now());
        this.userMapper.insert(user);

        return 1;
    }
}
