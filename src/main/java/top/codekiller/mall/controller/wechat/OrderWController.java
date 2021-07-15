package top.codekiller.mall.controller.wechat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.codekiller.mall.pojo.Order;
import top.codekiller.mall.service.order.OrderUpdateService;
import top.codekiller.mall.utils.ControllerUtils;

import java.util.Map;

/**
 * @author codekiller
 * @date 2021/7/14 21:22
 * @Description 订单接口
 */
@RestController
@RequestMapping("/wechat/order")
public class OrderWController {

    @Autowired
    private OrderUpdateService orderUpdateService;

    @PostMapping(value = "/addOrder")
    public ResponseEntity<Map<String,Object>> addOrder(@RequestBody Order order){
        int res = this.orderUpdateService.insertOrder(order);
        if(res==1){
            return ResponseEntity.ok(ControllerUtils.getPublicBackValue(HttpStatus.OK.value(),"新增成功"));
        }else{
            return ResponseEntity.ok(ControllerUtils.getPublicBackValue(HttpStatus.OK.value(),"新增失败"));
        }
    }

}
