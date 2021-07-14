package top.codekiller.mall.service.user;

/**
 * @author codekiller
 * @date 2021/7/11 15:19
 * @Description 用户新增，更新服务
 */
public interface UserUpdateService {
    /**
     * @Description 注册
     * @date 2021/7/11 15:15
     * @param userName
     * @param password
     * @return int
     */
    public int register(String userName,String password);
}
