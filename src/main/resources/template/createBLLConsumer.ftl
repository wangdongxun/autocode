
    <!-- ${bizName} -->
    <bean id="${modelName ? uncap_first}Mapper" class="com.taobao.hsf.app.spring.util.HSFSpringConsumerBean" init-method="init">
        <property name="interfaceName" value="com.jusfoun.xyy.idl.${center}.dao.${modelName}Mapper" />
        <property name="version" value="1.0.0" />
        <property name="group" value="axp01_${r"${lable}"}" />
    </bean>
</beans>