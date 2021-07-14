package top.codekiller.mall.service.product;

import top.codekiller.mall.pojo.Product;

import java.util.List;

/**
 * @author codekiller
 * @date 2021/7/12 14:18
 * @Description TODO
 */
public interface ProductQueryService {

    /**
    * @Description 获取所有商品
    * @date 2021/7/12 14:20
    * @return
    */
    public List<Product>  queryAllProducts();

    /**
    * @Description 通过类别查询所有商品
    * @date 2021/7/12 14:44
    * @param cid
    * @return java.util.List<top.codekiller.mall.pojo.Product>
    */
    public List<Product> queryAllProductsByCid(Long cid);

    /**
    * @Description 通过id查询商品
    * @date 2021/7/12 17:18
    * @param id
    * @return top.codekiller.mall.pojo.Product
    */
    public Product queryProductById(Long id);
}
