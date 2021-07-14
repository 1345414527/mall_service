package top.codekiller.mall.controller.web;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.codekiller.mall.pojo.Product;
import top.codekiller.mall.service.product.ProductQueryService;
import top.codekiller.mall.service.product.ProductUpdateService;
import top.codekiller.mall.utils.NotNullUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author codekiller
 * @date 2021/7/12 14:18
 * @Description TODO
 */
@Controller
@RequestMapping("/product")
public class ProductController extends BaseController {

    @Autowired
    private ProductQueryService productQueryService;

    @Autowired
    private ProductUpdateService productUpdateService;

    @RequestMapping("/list")
    public String list(HttpServletRequest request){
        List<Product> products = this.productQueryService.queryAllProducts();
        request.setAttribute("retList",products);
        return "/product/list";
    }

    /**
    * @Description 根据类别id查询商品
    * @date 2021/7/12 14:50
    * @param cid
    * @param request
    * @return java.lang.String
    */
    @RequestMapping("/list/{cid}")
    public String listByCId(@PathVariable("cid")Long cid, HttpServletRequest request){
        List<Product> products = this.productQueryService.queryAllProductsByCid(Long.valueOf(cid).longValue());
        System.out.println(products);
        request.setAttribute("retList",products);
        request.setAttribute("cid",String.valueOf(cid));
        return "/product/list";
    }

    @RequestMapping("/del/{id}/{cid}")
    public String delById(@PathVariable("id")Long id,@PathVariable("cid")Long cid){
        int res = this.productUpdateService.delProductById(id);
        return "redirect:/product/list/"+cid;
    }

    @GetMapping("/add")
    public String add(String id,String cid, HttpServletRequest request){
        request.setAttribute("cid",cid.replaceAll(",",""));
        if(StringUtils.isNotBlank(id)) {
            request.setAttribute("product", this.productQueryService.queryProductById(Long.valueOf(id).longValue()));
            System.out.println(request.getAttribute("product"));
        }

        return "/product/add";
    }

    @PostMapping("/add")
    public String post(Product product, HttpServletResponse response){
        if(NotNullUtil.isBlank(product)){
            return jsAlert("请完善商品信息!",("/product/add?id="+(StringUtils.isNotBlank(product.getId_())?product.getId_():"")+"&cid="+product.getCid_()),response);
        }
       if(StringUtils.isNotBlank(product.getId_())){
           //更新
           this.productUpdateService.updateProduct(product);
       }else{
           //插入
           this.productUpdateService.insertProduct(product);
       }

       return "redirect:/product/list/"+product.getCid_();
    }

    @RequestMapping("/update/{id_}/{cid_}")
    public String update(@PathVariable("id_")String id,@PathVariable("cid_")String cid){
        return "redirect:/product/add/?id="+id+"&cid="+cid;
    }

}
