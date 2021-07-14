package top.codekiller.mall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.catalina.mbeans.UserMBean;
import org.apache.ibatis.annotations.Mapper;
import top.codekiller.mall.pojo.User;

/**
 * @author codekiller
 * @date 2021/7/11 10:58
 * @Description TODO
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
