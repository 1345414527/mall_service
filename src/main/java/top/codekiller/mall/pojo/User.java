package top.codekiller.mall.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.JdbcType;
import org.springframework.format.annotation.DateTimeFormat;
import top.codekiller.mall.utils.NotNull;

import java.time.LocalDateTime;

/**
 * @author codekiller
 * @date 2021/7/11 14:11
 * @Description TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @TableId
    private Long id;

    @NotNull
    private String userName;

    @NotNull
    private String password;

    /**
     * 密码的盐值
     */
    @JsonIgnore
    private String salt;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @TableField(jdbcType = JdbcType.TIMESTAMP)
    public LocalDateTime created;

    /**
     * 版本，乐观锁
     */
    @JsonIgnore
    @Version
    private Long version;


}
