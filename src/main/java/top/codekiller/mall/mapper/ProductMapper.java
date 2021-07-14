package top.codekiller.mall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.codekiller.mall.pojo.Product;

import java.util.List;

/**
 * @author codekiller
 * @date 2021/7/12 14:16
 * @Description TODO
 */
public interface ProductMapper extends BaseMapper<Product> {

    @Select("select mall_product.*,mall_category.name as cName from mall_product " +
            "left join mall_category on mall_product.cid = mall_category.id;")
    public List<Product> selectAllProducts();


    @Select("select mall_product.*,mall_category.name as cName from mall_product " +
            "left join mall_category on mall_product.cid = mall_category.id " +
            "where mall_product.cid = #{cid};")
    public List<Product> selectAllProductsByCid(@Param("cid") Long cid);

    @Select("select mall_product.*,mall_category.name as cName from mall_product " +
            "left join mall_category on mall_product.cid = mall_category.id " +
            "where mall_product.id = #{id};")
    public Product selectProductById(@Param("id")Long id);
}
