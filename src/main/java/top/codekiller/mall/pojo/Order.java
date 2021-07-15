package top.codekiller.mall.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.JdbcType;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import top.codekiller.mall.utils.NotNull;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author codekiller
 * @date 2021/7/14 20:21
 * @Description 订单表
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @TableId
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @TableField(exist = false)
    private String id_;

    private String userName;


    @NotBlank
    private String address;

    @NotBlank
    private String mobile;

    private int total;

    private String note;

    @TableField(exist = false)
    private List<Product> products;

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
