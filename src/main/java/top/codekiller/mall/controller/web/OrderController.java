package top.codekiller.mall.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import top.codekiller.mall.pojo.Order;
import top.codekiller.mall.pojo.Product;
import top.codekiller.mall.pojo.Shopping;
import top.codekiller.mall.service.order.OrderQueryService;
import top.codekiller.mall.service.order.OrderUpdateService;
import top.codekiller.mall.service.product.ProductQueryService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author codekiller
 * @date 2021/7/15 8:10
 * @Description TODO
 */
@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderQueryService orderQueryService;

    @Autowired
    private OrderUpdateService orderUpdateService;


    /**
    * @Description 添加订单
    * @date 2021/7/15 9:41
    * @param userName
    * @param request
    * @return java.lang.String
    */
    @GetMapping("list")
    public String list(String userName, HttpServletRequest request){
        List<Order> orders = this.orderQueryService.queryOrders(userName);
        request.setAttribute("retList",orders);
        request.setAttribute("userName",userName);
        return "/order/list";
    }

    /**
    * @Description 删除订单
    * @date 2021/7/15 9:41
    * @param id
    * @return java.lang.String
    */
    @GetMapping("/del/{id}")
    public String list(@PathVariable("id") String id){
        int res = this.orderUpdateService.delOrder(Long.valueOf(id).longValue());
        return "redirect:/order/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id")String id,HttpServletRequest request){
        List<Shopping> shoppings = this.orderQueryService.queryAllShoppingByOid(Long.valueOf(id).longValue());
        request.setAttribute("retList",shoppings);
        request.setAttribute("cid",id);
        return "/order/detail_list";
    }
}
