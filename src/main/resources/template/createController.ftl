package ${basePkg}.${bizUnit}.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ${basePkg}.controller.BaseController;
import ${basePkg}.dto.ResultInfo;
import ${basePkg}.dto.${bizUnit}.${model}Dto;
import ${basePkg}.service.${bizUnit}.${model}Service;

/**
* @ClassName: ${model}Controller
* @Description: ${bizName}控制器
* @author ${author}
* @date ${curTime}
*/
@Controller
public class ${model}Controller extends BaseController{

    @Autowired
    private ${model}Service ${model?uncap_first}Service;

    /**
    * 新增
    **/
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResultInfo add(@RequestBody ${model}Dto dto) throws Exception{
        ${model?lower_case}Service.add(dto);
        return ResultInfo.success();
    }

    /**
    * 更新
    **/
    @ResponseBody
    @RequestMapping(value = "/upd", method = RequestMethod.POST)
    public ResultInfo upd(@RequestBody ${model}Dto dto) throws Exception{
        ${model?lower_case}Service.upd(dto);
        return ResultInfo.success();
    }

    /**
    * 列表
    **/
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResultInfo list(@RequestBody ${model}Dto dto) throws Exception{
        return ResultInfo.success(${model?lower_case}Service.list(dto));
    }
}
