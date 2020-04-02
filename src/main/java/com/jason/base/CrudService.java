package com.jason.base;

import com.jason.util.SqlSessionFactoryUtil;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @Auther: Jason
 * @Date: 2020/1/6 17:05
 * @Description:
 */
public abstract class CrudService<M extends CrudMapper<T>,T extends DataEntity<T>> {

    protected M mapper;

    public CrudService(){
        Type type = getClass().getGenericSuperclass();
        Class<M> clazz = (Class<M>)((ParameterizedType) type).getActualTypeArguments()[0];
        mapper = SqlSessionFactoryUtil.getMapper(clazz);
    }

    /**
    * @author Jason
    * @date 2020/1/6 17:10
    * @params [id]
    * @return T
    * 根据ID查询单条信息
    */
    public T selectById(String id){
        return mapper.selectById(id);
    }

    /**
    * @author Jason
    * @date 2020/1/6 17:10
    * @params [t]
    * @return T
     * 根据ID查询单条信息
    */
    public T selectById(T t){
        return mapper.selectById(t);
    }


    /**
    * @author Jason
    * @date 2020/1/6 17:11
    * @params [t]
    * @return java.util.List<T>
    * 查询列表
    */
    public List<T> select(T t){
        return mapper.select(t);
    }


    /**
    * @author Jason
    * @date 2020/1/6 17:12
    * @params []
    * @return java.util.List<T>
     *     查询全部信息
    */
    public List<T> selectAll(){
        return mapper.selectAll();
    }


    public Page<T> selectByPage(Page<T> page,T t){
        t.setPage(page);
        return page.setList(mapper.select(t));
    }


    /**
    * @author Jason
    * @date 2020/1/6 17:16
    * @params [t]
    * @return int
     * 新增或修改
    */
    public int save(T t){
        if(t.isNewData()){
            t.preInsert();
            return mapper.insert(t);
        }else{
            t.preUpdate();
            return mapper.update(t);
        }
    }


    /**
    * @author Jason
    * @date 2020/1/6 17:16
    * @params [t]
    * @return int
     * 根据ID删除数据
    */
    public int delete(T t){
        return mapper.delete(t);
    }


    /**
    * @author Jason
    * @date 2020/1/6 17:17
    * @params [id]
    * @return int
     * 根据ID删除数据
    */
    public int delete(String id){
        return mapper.delete(id);
    }
}
