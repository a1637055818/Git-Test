package com.peng.view;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * @author 16370
 * @create 2021-04-01 下午 8:41
 */
public class MyTuPianResolver implements ViewResolver, Ordered {

    private  Integer order;


    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {

        //根据视图名返回视图对象
        if (viewName.startsWith("tupian:")){
            return new MyView();
        }else {
            //如果不能处理，返回null即可
            return null;
        }

    }

    /**
     *
     * @return
     */
    @Override
    public int getOrder() {
        return order;
    }

    //改变视图解析器的视图优先级
    public void setOrder(Integer order){
        this.order=order;
    }
}
