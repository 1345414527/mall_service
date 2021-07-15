package top.codekiller.mall.controller.wechat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.codekiller.mall.pojo.Category;
import top.codekiller.mall.service.category.CategoryQueryService;
import top.codekiller.mall.service.category.CategoryUpdateService;
import top.codekiller.mall.utils.ControllerUtils;

import java.util.List;
import java.util.Map;

/**
 * @author codekiller
 * @date 2021/7/14 20:40
 * @Description 分类获取接口
 */
@RestController
@RequestMapping("/wechat/category")
public class CategoryWController {

    @Autowired
    private CategoryQueryService categoryQueryService;

    @GetMapping("/allCategories")
    public ResponseEntity<Map<String, Object>> queryAllCategories() {
        List<Category> categories = this.categoryQueryService.queryAllCategoryList();
        System.out.println(categories);
        if (categories != null) {
            Map<String, Object> res = ControllerUtils.getPublicBackValue(HttpStatus.OK.value(), "查询成功");
            res.put("categories",categories);
            return ResponseEntity.ok(res);
        }else{
           return ResponseEntity.ok(ControllerUtils.getPublicBackValue(HttpStatus.BAD_REQUEST.value(), "查询失败"));
        }
    }

}
