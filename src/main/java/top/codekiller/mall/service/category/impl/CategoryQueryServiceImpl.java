package top.codekiller.mall.service.category.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.codekiller.mall.mapper.CategoryMapper;
import top.codekiller.mall.pojo.Category;
import top.codekiller.mall.service.category.CategoryQueryService;

import java.util.List;

/**
 * @author codekiller
 * @date 2021/7/12 8:36
 * @Description 分类查询实现类
 */
@Service
public class CategoryQueryServiceImpl implements CategoryQueryService {
    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * @Description 查询所有分类
     * @date 2021/7/12 9:08
     * @return java.util.List<top.codekiller.mall.pojo.Category>
     */
    @Override
    public List<Category> queryAllCategoryList() {
        List<Category> categories = this.categoryMapper.selectList(null);
        categories.forEach(value->value.setId_(String.valueOf(value.getId())));
        return categories;
    }


    /**
     * @Description 通过id查询分类
     * @date 2021/7/12 10:59
     * @param id
     * @return top.codekiller.mall.pojo.Category
     */
    @Override
    public Category queryCategoryById(Long id) {
        Category category = this.categoryMapper.selectById(id);
        category.setId_(String.valueOf(category.getId()));
        return category;
    }

    /**
    * @Description 通过类别名称查询所有类别
    * @date 2021/7/14 11:47
    * @param category
    * @return java.util.List<top.codekiller.mall.pojo.Category>
    */
    @Override
    public List<Category> queryAllCategoryByName(String category) {
        List<Category> categories = this.categoryMapper.selectList(new QueryWrapper<Category>().lambda()
                .like(Category::getName, "%" + category + "%"));
        categories.forEach(value->value.setId_(String.valueOf(value.getId())));
        return categories;
    }
}
