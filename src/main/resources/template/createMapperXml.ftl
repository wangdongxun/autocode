<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.jusfoun.xyy.idl.${center}.dao.${modelName}Mapper">
    <resultMap id="BaseResultMap" type="com.jusfoun.xyy.idl.${center}.dao.${modelName}Bean">
        <constructor >
            <#list keyList as a>
            <idArg column="${a.columnName}" jdbcType="${a.jdbcType}" javaType="java.lang.${a.columnType}" />
            </#list>
            <#list columnList as a>
            <#if a.isKey='N'><arg column="${a.columnName}" jdbcType="${a.jdbcType}" javaType="<#if a.columnType='Date'>java.util.${a.columnType}<#else>java.lang.${a.columnType}</#if>" /></#if>
            </#list>
        </constructor>
    </resultMap>
    <sql id="Base_Column_List" >
        <#list columnList as a>${a.columnName}<#if a_has_next>,</#if></#list>
    </sql>

    <insert id="insertSelective" parameterType="com.jusfoun.xyy.idl.${center}.dao.${modelName}Bean" >
        insert into ${tableName}
        <trim prefix="(" suffix=")" suffixOverrides="," >
        <#list columnList as a><#if a.isKey='N'>
            <if test="${a.displayName} != null" >
            ${a.columnName},
            </if>
        </#if></#list>
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides="," >
        <#list columnList as a><#if a.isKey='N'>
            <if test="${a.displayName} != null" >
            ${r"#"}{${a.displayName},jdbcType=${a.jdbcType}},
            </if>
        </#if></#list>
        </trim>
    </insert>
    <delete id="deleteByPrimaryKey" parameterType="java.lang.Long" >
        delete from ${tableName} where <#list keyList as a> ${a.columnName} = ${r"#"}{${a.displayName},jdbcType=${a.jdbcType}}</#list>
    </delete>
    <update id="updateByPrimaryKeySelective" parameterType="com.jusfoun.xyy.idl.${center}.dao.${modelName}Bean" >
        update ${tableName}
        <set >
        <#list columnList as a><#if a.isKey='N'>
            <if test="${a.displayName} != null" >
            ${a.columnName} = ${r"#"}{${a.displayName},jdbcType=${a.jdbcType}},
            </if>
        </#if></#list>
        </set>
        where <#list keyList as a> ${a.columnName} = ${r"#"}{${a.displayName},jdbcType=${a.jdbcType}}</#list>
    </update>
    <select id="selectByPrimaryKey" resultMap="BaseResultMap" parameterType="java.lang.Long" >
        select
        <include refid="Base_Column_List" />
        from ${tableName}
        where <#list keyList as a> ${a.columnName} = ${r"#"}{${a.displayName},jdbcType=${a.jdbcType}}</#list>
    </select>
    <select id="selectAll" resultMap="BaseResultMap" parameterType="java.lang.Long" >
        select  * from ${tableName}
    </select>
</mapper>
