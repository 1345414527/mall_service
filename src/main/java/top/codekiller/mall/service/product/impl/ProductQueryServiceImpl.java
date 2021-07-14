package top.codekiller.mall.service.product.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.codekiller.mall.mapper.ProductMapper;
import top.codekiller.mall.pojo.Product;
import top.codekiller.mall.service.product.ProductQueryService;

import java.util.List;

/**
 * @author codekiller
 * @date 2021/7/12 14:18
 * @Description TODO
 */
@Service
@Slf4j
public class ProductQueryServiceImpl implements ProductQueryService {


    @Autowired
    private ProductMapper productMapper;

    /**
    * @Description 查询所有商品
    * @date 2021/7/12 14:20
    * @return java.util.List<top.codekiller.mall.pojo.Product>
    */
    @Override
    public List<Product> queryAllProducts() {
        List<Product> products = this.productMapper.selectAllProducts();
        products.forEach(value->{
            value.setId_(String.valueOf(value.getId()));
            value.setCid_(String.valueOf(value.getCid()));
        });
        return products;
    }

    /**
    * @Description 通过类别查询所有商品
    * @date 2021/7/12 14:45
    * @param cid
    * @return java.util.List<top.codekiller.mall.pojo.Product>
    */
    @Override
    public List<Product> queryAllProductsByCid(Long cid) {
//        List<Product> products = this.productMapper.selectList(new QueryWrapper<Product>().lambda().eq(Product::getCid, cid));
        List<Product> products = this.productMapper.selectAllProductsByCid(cid);
        log.info("查询商品信息："+products.toString());
        products.forEach(value->{
            value.setId_(String.valueOf(value.getId()));
            value.setCid_(String.valueOf(value.getCid()));
        });
        return products;
    }

    /**
    * @Description 通过id查询商品
    * @date 2021/7/12 17:18
    * @param id
    * @return top.codekiller.mall.pojo.Product
    */
    @Override
    public Product queryProductById(Long id) {
//        Product product = this.productMapper.selectById(id);
        Product product = this.productMapper.selectProductById(id);
        product.setId_(String.valueOf(product.getId()));
        product.setCid_(String.valueOf(product.getCid()));
        return product;
    }
}
