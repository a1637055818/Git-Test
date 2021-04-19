package servlet;

import bean.Student;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 16370
 * @create 2021-03-28 下午 6:57
 */
public class AjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student stu1 = new Student("zhifei", "zhifei@qq.com", 22);
        Student stu2 = new Student("zhifei", "zhifei@qq.com", 22);
        Student stu3 = new Student("zhifei", "zhifei@qq.com", 22);

        List<Student> list=new ArrayList<>();
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);

        Gson gson = new Gson();
        String json = gson.toJson(list);

        System.out.println(json);

        resp.getWriter().write(json);

    }
}
