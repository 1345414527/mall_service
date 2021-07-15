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
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import top.codekiller.mall.utils.NotNull;

import java.time.LocalDateTime;

/**
 * @author codekiller
 * @date 2021/7/14 20:18
 * @Description 订单商品表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shopping {
    @TableId
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long orderId;


    @JsonSerialize(using = ToStringSerializer.class)
    private Long productId;

    @TableField(exist = false)
    private String productName;

    @TableField(exist = false)
    private Integer price;

    @Length(min = 1)
    @TableField(value="`count`")
    private int count;


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
