package com.peng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 *
 *  SpringMVC除了在方法上传入原生的request、
 *  session外还能怎样把数据传输给页面
 *
 *  1.可以在方法处传入Map，或者Model或者ModelMap
 *  给这些参数里面保存的所有数据都会放在请求域中，可以在页面获取
 *  关系：Map、Model、ModelMap：
 *  最终都是BindingAwareModelMap在工作
 *  相当于BindingAwareModelMap中保存的数据都在请求域中
 *
 *  Map(interface)          Model(interface(spring))
 *      ||                          //
 *      ||                         //
 *      \/                        //
 *  ModelMap(class)              //
 *                 \\           //
 *                  \\         //
 *                   ExtendedModelMap
 *                       ||
 *                       \/
 *                   BindingAwareModelMap
 *
 *
 * 2.方法的返回值可以为ModelAndView类型：
 *      既包含视图信息(页面地址)也包含模型数据(给页面带的数据)
 *      数据是方法请求域中
 *
 * 3.SpringMVC提供了一种可以临时给Session域中保存数据的方式
 *  使用注解@SessionAttribute(只能标在类上)
 *  @SessionAttributes("msg")
 *  给BindingAwareModelMap中保存的数据,
 *  或者给ModelAndView中的数据
 *  同时给session中放一份
 *  value指定保存数据是要给session中放的key
 *  value = "msg"：只要保存的是这种key的数据,给Session中也放一份
 *  types = String.class:只要保存的是这种类型的数据，给Session中也放一份
 *
 *  后来推荐@SessionAttributes就别用了，可能会引发一场
 *  给session放数据使用原生API：
 * @author 16370
 * @create 2021-04-01 下午 12:32
 */
//@SessionAttributes(value = "msg",types = String.class)
@Controller
public class OutputController {
    public static final String SUCCESS="success";


    /**
     * 返回值是ModelAndView;可以为页面携带上数据
     * @return
     */
    @RequestMapping("/handle04")
    public ModelAndView handle04(){
        //之前的返回值就叫视图名，
        // 视图名视图解析器会帮我们最终拼串得到真实页面地址
        ModelAndView mv = new ModelAndView(SUCCESS);
        mv.addObject("msg", "你好ModelAndView");
        return mv;
    }

    @RequestMapping("/handle01")
    public String handle01(Map<String,Object>map){
        System.out.println(map.getClass());
        map.put("msg", "你好啊");
        return SUCCESS;
    }

    /**
     * Model:一个几口
     * @param model
     * @return
     */
    @RequestMapping("/handle02")
    public String handle02(Model model){
        System.out.println(model.getClass());
        model.addAttribute("msg", "hello");
        return SUCCESS;
    }

    @RequestMapping("/handle03")
    public String handle03(ModelMap modelMap){
        System.out.println(modelMap.getClass());
        modelMap.addAttribute("msg", "hello");
        return SUCCESS;
    }
}
