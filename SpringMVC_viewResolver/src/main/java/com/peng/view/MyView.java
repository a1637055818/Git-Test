package com.peng.view;

import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 自定义视图
 * @author 16370
 * @create 2021-04-01 下午 8:44
 */
public class MyView implements View {
    /**
     * 返回的数据的内容类型
     * @return
     */
    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("之前保存的数据："+model);
        response.setContentType("text/html");
        response.getWriter().write("hhh<h3>即将到来</h3>");
    }
}
