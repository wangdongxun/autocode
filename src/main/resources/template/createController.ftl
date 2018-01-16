package ${basePkg}.${bizUnit}.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.core.JsonParseException;

import ${basePkg}.dto.ResultInfo;
import ${basePkg}.controller.BaseController;
import ${basePkg}.dto.${bizUnit}.${model}Dto;
import ${basePkg}.service.${bizUnit}.${model}Service;
import ${basePkg}.tools.JsonUtils;

/**
* @ClassName: ${model}Controller
* @Description: ${bizName}控制器
* @author ${author}
* @date ${curTime}
*/
@Controller
public class ${model}Controller extend BaseController{

    @Autowired
    private ${model}Service ${model?lower_case}Service;

    /**
    * 新增
    **/
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResultInfo add(@RequestBody ${model}Dto dto) {
        ${model?lower_case}Service.add(dto);
        return null;
    }

    /**
    * 更新
    **/
    @ResponseBody
    @RequestMapping(value = "/upd", method = RequestMethod.POST)
    public ResultInfo upd(@RequestBody ${model}Dto dto) {
        ${model?lower_case}Service.add(dto);
        return null;
    }

    /**
    * 列表
    **/
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResultInfo list(@RequestBody ${model}Dto dto) {
        ${model?lower_case}Service.list(dto);
        return null;
    }
}
