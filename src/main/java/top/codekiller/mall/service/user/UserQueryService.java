package top.codekiller.mall.service.user;

import top.codekiller.mall.pojo.User;

/**
 * @author codekiller
 * @date 2021/7/11 14:37
 * @Description TODO
 */
public interface UserQueryService {


    /**
    * @Description 查询用户
    * @date 2021/7/11 15:15
    * @param userName
    * @param password
    * @return top.codekiller.mall.pojo.User
    */
    public User queryUser(String userName, String password);

    /**
    * @Description 登录
    * @date 2021/7/11 15:15
    * @param userName
    * @param password
    * @return int
    */
    public Long login(String userName,String password);

    /**
    * @Description 通过id查询用户
    * @date 2021/7/11 17:00
    * @param id
    * @return top.codekiller.mall.pojo.User
    */
    public User queryUserById(Long id);




}
