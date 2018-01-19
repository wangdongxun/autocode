package ${basePkg}.service.impl.${bizUnit};

import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${basePkg}.bean.${bizUnit}.${model}Bean;
import ${basePkg}.dto.${bizUnit}.${model}Dto;


/**
* @ClassName: ${model}ServiceImpl
* @Description: ${bizName}服务实现
* @author ${author}
* @date ${curTime}
*/
@Service("${model}Service")
public class ${model}ServiceImpl implements ${model}Service {

    @Autowired
    private ${model}Mapper mapper;

    /**
    * 增加
    */
    @Override
    public void add(${model}Dto dto) throws Exception{
        ${model}Bean bean = new ${model}Bean();
        BeanUtils.copyProperties(dto, bean);
        int result=mapper.add(bean);
        if(result!=1){
            throw new BizException(ErrorCode.sys_db);
        }
    }

    /**
    * 更新
    */
    public void upd(${model}Dto dto) throws Exception{
        ${model}Bean bean = new ${model}Bean();
        BeanUtils.copyProperties(dto, bean);
        int result=mapper.upd(bean);
        if(result!=1){
            throw new BizException(ErrorCode.sys_db);
        }

    }

    /**
    * 列表
    */
    public List<${model}Bean> list(${model}Dto dto) throws Exception{
        return mapper.list(dto);
    }
}