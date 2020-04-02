package com.jason.base;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: Jason
 * @Date: 2020/1/1 16:34
 * @Description:
 */
public interface CrudMapper<T> extends BaseMapper {

    /**
     * 根据ID查询单条数据
     * @param id
     * @return
     */
    T selectById(String id);

    /**
     * 根据ID查询单条数据
     * @param t
     * @return
     */
    T selectById(T t);


    /**
     * 条件查询，如需分页，请设置分页对象
     * @param t
     * @return
     */
    List<T> select(T t);


    /**
     * 查询所有
     * @return
     */
    List<T> selectAll();

    int insert(T t);

    int update(T t);


    /**
     * 逻辑删除
     * @param t
     * @return
     */
    int delete(T t);


    /**
     * 逻辑删除
     * @param id
     * @return
     */
    int delete(String id);


    /**
     * 根据ids查询出所有关联对象
     * @param ids
     * @return
     */
    List<T> joinCollectionByIds(@Param("ids") String ids);
}
