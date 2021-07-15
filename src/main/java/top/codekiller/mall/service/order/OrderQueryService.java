package top.codekiller.mall.service.order;

import top.codekiller.mall.pojo.Order;
import top.codekiller.mall.pojo.Shopping;

import java.util.List;

/**
 * @author codekiller
 * @date 2021/7/15 8:12
 * @Description TODO
 */
public interface OrderQueryService {

    public List<Order> queryOrders(String userName);

    public List<Shopping> queryAllShoppingByOid(Long id);
}
