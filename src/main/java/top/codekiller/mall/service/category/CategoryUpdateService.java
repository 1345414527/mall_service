package top.codekiller.mall.service.category;

/**
 * @author codekiller
 * @date 2021/7/12 9:08
 * @Description 分类更新，插入服务类
 */
public interface CategoryUpdateService {

    /**
    * @Description 插入新分类
    * @date 2021/7/12 9:11
    * @param name
    * @return int
    */
    public int insertCategory(String name);

    /**
    * @Description 删除分类
    * @date 2021/7/12 10:05
    * @param id
    * @return int
    */
    public int delCategory(Long id);

    public int updateCategoryById(Long id,String name);
}
