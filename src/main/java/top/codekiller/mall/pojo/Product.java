package top.codekiller.mall.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.sun.xml.internal.ws.developer.Serialization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.JdbcType;
import org.springframework.format.annotation.DateTimeFormat;
import top.codekiller.mall.utils.NotNull;

import java.time.LocalDateTime;

/**
 * @author codekiller
 * @date 2021/7/12 14:13
 * @Description TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Serialization
public class Product {
    @TableId
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @TableField(exist = false)
    private String id_;

    private String name;

    @NotNull
    private Integer price;

    @NotNull
    private Integer num;
    private String logo;

    @NotNull
    private Integer hot;
    private Long cid;

    @TableField(exist = false)
    private String cid_;

    @TableField(exist = false)
    private String cName;

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
