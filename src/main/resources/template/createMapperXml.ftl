<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${basePkg}.dao.mapper.${bizUnit}.${model}Mapper">
    <sql id="Base_Column_List" >
        <#list columnList as a>${a.columnName}<#if a_has_next>,</#if></#list>
    </sql>

    <insert id="add" parameterType="${basePkg}.bean.${bizUnit}.${model}Bean" >
        insert into ${table ? lower_case}
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

    <update id="upd" parameterType="${basePkg}.bean.${bizUnit}.${model}Bean" >
        update ${table ? lower_case}
        <set >
        <#list columnList as a><#if a.isKey='N'>
            <if test="${a.displayName} != null" >
            ${a.columnName} = ${r"#"}{${a.displayName},jdbcType=${a.jdbcType}},
            </if>
        </#if></#list>
        </set>
        <trim prefix="where " suffixOverrides=" and " >
            <#list columnList as a>
                <if test="${a.displayName} != null" >
                ${r"#"}{${a.displayName},jdbcType=${a.jdbcType}} and
                </if>
            </#list>
        </trim>
    </update>

    <select id="list" resultType="${basePkg}.bean.${bizUnit}.${model}Bean" parameterType="${basePkg}.dto.${bizUnit}.${model}Dto" >
        select
        <include refid="Base_Column_List" />
        from ${table ? lower_case}
        <trim prefix="where " suffixOverrides=" and " >
            <#list columnList as a>
                <if test="${a.displayName} != null" >
                ${r"#"}{${a.displayName},jdbcType=${a.jdbcType}} and
                </if>
            </#list>
        </trim>
    </select>
</mapper>
