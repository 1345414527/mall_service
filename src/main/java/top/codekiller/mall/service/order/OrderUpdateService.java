package top.codekiller.mall.service.order;

import top.codekiller.mall.pojo.Order;

/**
 * @author codekiller
 * @date 2021/7/14 21:22
 * @Description 订单更新服务
 */
public interface OrderUpdateService {

    /**
    * @Description 新增订单
    * @date 2021/7/15 9:39
    * @param order
    * @return int
    */
    public int insertOrder(Order order);

    /**
    * @Description 删除订单
    * @date 2021/7/15 9:39
    * @param id
    * @return int
    */
    public int delOrder(Long id);
}
