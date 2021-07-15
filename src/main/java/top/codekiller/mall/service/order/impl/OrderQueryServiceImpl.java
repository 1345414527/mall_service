package top.codekiller.mall.service.order.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.codekiller.mall.mapper.OrderMapper;
import top.codekiller.mall.mapper.ShoppingMapper;
import top.codekiller.mall.pojo.Order;
import top.codekiller.mall.pojo.Shopping;
import top.codekiller.mall.service.order.OrderQueryService;

import java.util.List;

/**
 * @author codekiller
 * @date 2021/7/15 8:12
 * @Description 订单查询
 */
@Service
public class OrderQueryServiceImpl implements OrderQueryService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ShoppingMapper shoppingMapper;

    /**
    * @Description 模糊查询和全部查询订单
    * @date 2021/7/15 8:40
    * @param userName  
    * @return java.util.List<top.codekiller.mall.pojo.Order>
    */
    @Override
    public List<Order> queryOrders(String userName) {
        if(StringUtils.isBlank(userName)){
            List<Order> orders = this.orderMapper.selectList(null);
            orders.forEach(value->value.setId_(String.valueOf(value.getId())));
            return orders;
        }
        List<Order> orders = this.orderMapper.selectList(new QueryWrapper<Order>().lambda()
                .like(Order::getUserName, userName));
        orders.forEach(value->value.setId_(String.valueOf(value.getId())));
        return orders;
    }


    /**
    * @Description 通过订单id获取所有购买商品
    * @date 2021/7/15 9:55
    * @param id
    * @return java.util.List<top.codekiller.mall.pojo.Shopping>
    */
    @Override
    public List<Shopping> queryAllShoppingByOid(Long id) {
        List<Shopping> shoppings = this.shoppingMapper.selectAllShoopingByOid(id);
        return shoppings;
    }
}
