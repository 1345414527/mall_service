package top.codekiller.mall.controller.wechat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.codekiller.mall.pojo.Product;
import top.codekiller.mall.service.product.ProductQueryService;
import top.codekiller.mall.utils.ControllerUtils;

import java.util.List;
import java.util.Map;

/**
 * @author codekiller
 * @date 2021/7/14 20:40
 * @Description 商品获取接口
 */
@RestController
@RequestMapping("/wechat/product")
public class ProductWController {
    @Autowired
    private ProductQueryService productQueryService;

    @GetMapping("/products/{cid}")
    public ResponseEntity<Map<String,Object>> queryProductByCid(@PathVariable("cid")String cid){
        List<Product> products = this.productQueryService.queryAllProductsByCid(Long.valueOf(cid).longValue());
        if(products!=null){
            Map<String, Object> res = ControllerUtils.getPublicBackValue(HttpStatus.OK.value(), "查询商品成功");
            res.put("products",products);
            return ResponseEntity.ok(res);
        }else{
            return ResponseEntity.ok(ControllerUtils.getPublicBackValue(HttpStatus.BAD_REQUEST.value(),"查询商品失败"));
        }
    }


}
