package ${basePkg}.${bizUnit}.bean;

import java.io.Serializable;
import java.util.Date;

/**
* @ClassName: ${model}Bean
* @Description: ${bizName}
* @author ${author}
* @date ${curTime}
*/

public class ${model}Bean implements Serializable {

    <#list columnList as a>
    /**
    * ${a.comment}
    **/
    private ${a.columnType} ${a.displayName};
    </#list>


    <#list columnList as a>
    public ${a.columnType} get${a.displayName ? cap_first}() {
        return ${a.displayName};
    }

    public void set${a.displayName ? cap_first}(${a.columnType} ${a.displayName}) {
        <#if a.columnType ? contains("String") >
        this.${a.displayName} = ${a.displayName} == null ? null : ${a.displayName}.trim();
        <#else >
        this.${a.displayName} = ${a.displayName};
        </#if>
    }

    </#list>
}