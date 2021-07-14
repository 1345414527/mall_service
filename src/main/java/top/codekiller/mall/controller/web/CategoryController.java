package top.codekiller.mall.controller.web;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.codekiller.mall.pojo.Category;
import top.codekiller.mall.service.category.CategoryQueryService;
import top.codekiller.mall.service.category.CategoryUpdateService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author codekiller
 * @date 2021/7/12 8:37
 * @Description 分类控制器
 */
@Controller
@RequestMapping("/category")
public class CategoryController extends BaseController{
    @Autowired
    private CategoryQueryService categoryQueryService;

    @Autowired
    private CategoryUpdateService categoryUpdateService;


    /**
    * @Description 查询所有分类
    * @date 2021/7/12 9:13
    * @param request
    * @return java.lang.String
    */
    @RequestMapping("/list")
    public String list(HttpServletRequest request){
        List<Category> categories = this.categoryQueryService.queryAllCategoryList();
        request.setAttribute("category", "");
        request.setAttribute("retList",categories);
        return "/category/list";
    }

    /**
    * @Description 通过类别名称模糊查询
    * @date 2021/7/14 14:11
    * @param category
    * @param request
    * @return java.lang.String
    */
    @RequestMapping("/lists")
    public String list(String category,HttpServletRequest request){
        List<Category> categories = this.categoryQueryService.queryAllCategoryByName(category);
        request.setAttribute("category",category);
        request.setAttribute("retList",categories);
        return "/category/list";
    }

    /**
    * @Description 新增分类
    * @date 2021/7/12 9:13
    * @param name
    * @return java.lang.String
    */
    @PostMapping("/add")
    public String add(String name, String id_, HttpServletResponse response){
        if(StringUtils.isBlank(name)){
            return jsAlert("请输入类别名称！",
                    ("/category/add"+(StringUtils.isNotBlank(id_)?"?id="+Long.valueOf(id_).longValue():"")),
                    response);
        }

        int res;
        if(StringUtils.isBlank(id_)){
            res = this.categoryUpdateService.insertCategory(name);
        }else{
            res = this.categoryUpdateService.updateCategoryById(Long.valueOf(id_).longValue(),name);
        }
        return "redirect:/category/list";
    }


    /**
    * @Description 转发页面
    * @date 2021/7/12 10:31
    * @return java.lang.String
    */
    @GetMapping("/add")
    public String add(){
        return "/category/add";
    }

    /**
    * @Description 删除分类
    * @date 2021/7/12 10:04
    * @param id_
    * @return java.lang.String
    */
    @RequestMapping("/del")
    public String del(String id_){
        System.out.println(id_);
        System.out.println(Long.valueOf(id_).longValue());
        this.categoryUpdateService.delCategory(Long.valueOf(id_).longValue());
        return "redirect:/category/list";
    }

    @RequestMapping("/update")
    public String update(String id_,HttpServletRequest request){
        Category category = this.categoryQueryService.queryCategoryById(Long.valueOf(id_).longValue());
        request.setAttribute("category",category);
        if(category!=null) {
            return "/category/add";
        }
        return "redirect:/category/list";
    }




}
