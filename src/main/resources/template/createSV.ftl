package ${basePkg}.service.${bizUnit};

import java.util.List;
import ${basePkg}.dto.${bizUnit}.${model}Dto;
import ${basePkg}.bean.${bizUnit}.${model}Dean;

/**
* @ClassName: ${model}Service
* @Description: ${bizName}服务
* @author ${author}
* @date ${curTime}
*/
public interface ${model}Service {
    /**
	 * 增加
	 */
	void add(${model}Dto dto) throws Exception;

	/**
	 * 更新
	 */
	void upd(${model}Dto dto) throws Exception;

	/**
	 * 列表
	 */
	List<${model}Bean> list(${model}Dto dto) throws Exception;
}