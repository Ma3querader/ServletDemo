package Test;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: panyusheng
 * @Date: 2020/1/19 17:42
 * @Version 1.0
 */
public class Ser2 extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        // 取出ServletContext的某个属性
        //1.首先获取到ServletContext
        ServletContext servletContext = this.getServletContext();
        //2.取出属性
        String name = (String)servletContext.getAttribute("name");
        out.println("name="+name);
    }
}
