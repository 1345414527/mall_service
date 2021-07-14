package top.codekiller.mall.service.product;

import top.codekiller.mall.pojo.Product;

/**
 * @author codekiller
 * @date 2021/7/12 15:15
 * @Description TODO
 */
public interface ProductUpdateService {

    public int delProductById(Long id);

    public int insertProduct(Product product);

    public int updateProduct(Product product);
}
