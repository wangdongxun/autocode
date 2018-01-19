package ${basePkg}.dao.mapper.${bizUnit};

import java.util.List;
import java.util.Map;

import javax.inject.Named;

import ${basePkg}.bean.${bizUnit}.${model}Dean;
import ${basePkg}.dto.${bizUnit}.${model}Dto;

/**
* @ClassName: ${model}Mapper
* @Description: ${bizName}数据库操作接口
* @author ${author}
* @date ${curTime}
*
*/
@Named("${model ? uncap_first}Mapper")
public interface ${model}Mapper {

    /**
    * 增加
    */
    int add(${model}Dto dto);

    /**
    * 更新
    */
    int upd(${model}Bean bean);

    /**
    * 列表
    */
    List<${model}Bean> list(${model}Dto dto);
}