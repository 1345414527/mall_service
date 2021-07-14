package top.codekiller.mall.service.category;

import top.codekiller.mall.pojo.Category;

import java.util.List;

/**
 * @author codekiller
 * @date 2021/7/12 8:35
 * @Description TODO
 */
public interface CategoryQueryService {

    /**
    * @Description 查询所有分类
    * @date 2021/7/12 9:08
    * @return java.util.List<top.codekiller.mall.pojo.Category>
    */
    public List<Category> queryAllCategoryList();

    /**
    * @Description 通过id查询分类
    * @date 2021/7/12 10:59
    * @param id
    * @return top.codekiller.mall.pojo.Category
    */
    public Category queryCategoryById(Long id);

    /**
    * @Description 通过类别名称查询所有类别
    * @date 2021/7/14 11:46
    * @param category
    * @return java.util.List<top.codekiller.mall.pojo.Category>
    */
    public List<Category> queryAllCategoryByName(String category);
}
