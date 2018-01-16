package com.jusfoun.xyy.idl.${center}.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.jusfoun.xyy.idl.${center}.dao.${modelName}Bean;

/**
* @ClassName: ${modelName}Mapper
* @Description: ${bizName}数据库操作接口
* @author ${author}
* @date ${curTime}
*
*/
@Named("${modelName ? uncap_first}Mapper")
public interface ${modelName}Mapper {

    /**
    * @Method: insertSelective
    * @Description: 新增
    * @param 参数
    * @return 返回类型 int
    * @throws ${author}
    * @throws
    * @date ${curTime}
    **/
    int insertSelective(${modelName}Bean bean);

    /**
    * @Method: deleteByPrimaryKey
    * @Description: 按主键ID删除菜单
    * @param 参数
    * @return 返回类型
    * @throws ${author}
    * @throws
    * @date ${curTime}
    **/
    int deleteByPrimaryKey(<#list keyList as a>${a.columnType} ${a.displayName}<#if a_has_next>, </#if></#list>);

    /**
    * @Method: updateByPrimaryKeySelective
    * @Description: 更新
    * @param 参数
    * @return 返回类型 int
    * @throws ${author}
    * @throws
    * @date ${curTime}
    **/
    int updateByPrimaryKeySelective(${modelName}Bean bean);

    /**
    * @Method: selectByPrimaryKey
    * @Description: 根据主键查询
    * @param 参数
    * @return 返回类型 int
    * @throws ${author}
    * @throws
    * @date ${curTime}
    **/
    ${modelName}Bean selectByPrimaryKey(<#list keyList as a>${a.columnType} ${a.displayName}<#if a_has_next>, </#if></#list>);

    /**
    * @Method: selectAll
    * @Description: 查询所有
    * @param 参数
    * @return 返回类型 List
    * @throws ${author}
    * @throws
    * @date ${curTime}
    **/
    List<${modelName}Bean> selectAll();
}