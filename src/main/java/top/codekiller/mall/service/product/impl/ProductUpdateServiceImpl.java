package top.codekiller.mall.service.product.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.codekiller.mall.mapper.ProductMapper;
import top.codekiller.mall.pojo.Product;
import top.codekiller.mall.service.product.ProductUpdateService;

import java.time.LocalDateTime;

/**
 * @author codekiller
 * @date 2021/7/12 15:16
 * @Description TODO
 */
@Service
public class ProductUpdateServiceImpl implements ProductUpdateService {
    @Autowired
    private ProductMapper productMapper;

    /**
    * @Description 通过id删除商品
    * @date 2021/7/13 8:11
    * @param id
    * @return int
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delProductById(Long id) {
        int res = this.productMapper.deleteById(id);
        return res;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertProduct(Product product) {
        product.setCreated(LocalDateTime.now());
        product.setId(null);
        product.setCid(Long.valueOf(product.getCid_()).longValue());

        //进行数据修正
        product.setPrice(Math.abs(product.getPrice()));
        product.setNum(Math.abs(product.getNum()));

        return this.productMapper.insert(product);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateProduct(Product product) {
        //进行数据修正
        product.setPrice(Math.abs(product.getPrice()));
        product.setNum(Math.abs(product.getNum()));
        product.setId(Long.valueOf(product.getId_()).longValue());

        return this.productMapper.updateById(product);
    }
}
