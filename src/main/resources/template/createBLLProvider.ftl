
    <!-- ${bizName} -->
    <bean id="${modelName ? uncap_first}Provider" class="com.taobao.hsf.app.spring.util.HSFSpringProviderBean" init-method="init">
        <property name="serviceInterface" value="com.jusfoun.xyy.idl.${center}.service.${modelName}" />
        <property name="target" ref="${modelName ? uncap_first}" />
        <property name="serviceVersion" value="1.0.0" />
        <property name="serviceGroup" value="axp01_${r"${lable}"}" />
        <property name="clientTimeout" value="3000" />
    </bean>
</beans>