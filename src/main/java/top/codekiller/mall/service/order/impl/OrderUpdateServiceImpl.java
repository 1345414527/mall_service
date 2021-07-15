package top.codekiller.mall.service.order.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.codekiller.mall.mapper.OrderMapper;
import top.codekiller.mall.mapper.ProductMapper;
import top.codekiller.mall.mapper.ShoppingMapper;
import top.codekiller.mall.pojo.Order;
import top.codekiller.mall.pojo.Product;
import top.codekiller.mall.pojo.Shopping;
import top.codekiller.mall.service.order.OrderUpdateService;

import java.time.LocalDateTime;

/**
 * @author codekiller
 * @date 2021/7/14 21:23
 * @Description 订单更新服务
 */
@Service
@Slf4j
public class OrderUpdateServiceImpl implements OrderUpdateService {


    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ShoppingMapper shoppingMapper;

    @Autowired
    private ProductMapper productMapper;

    /**
    * @Description 新增订单
    * @date 2021/7/15 9:40
    * @param order
    * @return int
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertOrder(Order order) {
        order.setId(null);
        order.setCreated(LocalDateTime.now());
        int res = this.orderMapper.insert(order);
        if(res==0){
            return res;
        }
        log.info(order.toString());
        //新增订单具体商品
        for (Product product : order.getProducts()) {
            Shopping shopping = new Shopping();
            shopping.setId(null);
            shopping.setOrderId(order.getId());
            shopping.setCount(product.getCount());
            shopping.setCreated(LocalDateTime.now());
            shopping.setProductId(product.getId());
            res = this.shoppingMapper.insert(shopping);
            if(res==0){
                return res;
            }
            product.setNum(product.getNum()-product.getCount());
            if(product.getCid_()!=null){
                product.setCid(Long.valueOf(product.getCid_()).longValue());
            }
            res = this.productMapper.updateById(product);
            if(res==0){
                return res;
            }
        }
        return res;
    }

    /**
    * @Description 删除订单
    * @date 2021/7/15 9:40
    * @param id  
    * @return int
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delOrder(Long id) {
        int res = this.orderMapper.deleteById(id);
        return res;
    }
}
