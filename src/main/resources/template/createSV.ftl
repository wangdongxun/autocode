package ${basePkg}.service.${bizUnit}.${model}Service;

import ${basePkg}.dto.${bizUnit}.${model}Dto;

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
	void add(${model}Dto dto) throw Exception;

	/**
	 * 更新
	 */
	void upd(${model}Dto dto) throw Exception;

	/**
	 * 列表
	 */
	List<${model}Dto> list(${model}Dto dto) throw Exception;
}