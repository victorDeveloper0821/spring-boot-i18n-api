package idv.victor.i18nDemo.controller;

import idv.victor.i18nDemo.req.dto.DataReqDTO;
import idv.victor.i18nDemo.utils.LanguageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api")
public class HelloController {

    /**
     * 用於操作 i18n 相關函數
     */
    @Autowired
    private LanguageUtil languageUtil;

    @RequestMapping(value = "/hello", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String hello(){
        return languageUtil.getMessage("hello");
    }

    @RequestMapping(value = "/data", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String dataMessage(@RequestBody DataReqDTO reqDTO){
        return languageUtil.getMessage("data.message.args", reqDTO.getParam1(), reqDTO.getParam2());
    }

    @RequestMapping(value = "/hello/{name}", method = {RequestMethod.GET})
    @ResponseBody
    public String helloWithName(@PathVariable("name") String name){
        return languageUtil.getMessage("hello.args",name);
    }

}
