package top.codekiller.mall.service.category.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.codekiller.mall.mapper.CategoryMapper;
import top.codekiller.mall.pojo.Category;
import top.codekiller.mall.service.category.CategoryUpdateService;

import java.time.LocalDateTime;

/**
 * @author codekiller
 * @date 2021/7/12 9:09
 * @Description TODO
 */
@Service
public class CategoryUpdateServiceImpl implements CategoryUpdateService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
    * @Description 插入新分类
    * @date 2021/7/12 9:11
    * @param name
    * @return int
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertCategory(String name) {
        Category category = new Category();
        category.setId(null);
        category.setName(name);
        category.setCreated(LocalDateTime.now());
        return this.categoryMapper.insert(category);
    }

    /**
    * @Description 删除分类
    * @date 2021/7/12 10:05
    * @param id
    * @return int
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delCategory(Long id) {
        return this.categoryMapper.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateCategoryById(Long id, String name) {
        Category category = new Category();
        category.setId(id);
        category.setName(name);
        return this.categoryMapper.updateById(category);
    }
}
