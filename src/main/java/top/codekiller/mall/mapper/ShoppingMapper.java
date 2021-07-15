package top.codekiller.mall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.codekiller.mall.pojo.Shopping;

import java.util.List;

/**
 * @author codekiller
 * @date 2021/7/14 21:33
 * @Description TODO
 */
public interface ShoppingMapper extends BaseMapper<Shopping> {


    @Select("select shopping.*,product.name as productName,product.price as price from `mall_shopping` as shopping " +
            "left join `mall_product` as product on shopping.product_id=product.id where shopping.order_id =  ${id} ;")
    List<Shopping> selectAllShoopingByOid(@Param("id") Long id);
}
