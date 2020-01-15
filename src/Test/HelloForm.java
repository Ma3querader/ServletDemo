package Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class HelloForm extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        // 设置响应内容类型
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        PrintWriter out = response.getWriter();
        String title = "读取复选框数据";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<table width=\"100%\" border=\"1\" align=\"center\">\n" +
                "<tr bgcolor=\"#949494\">\n" +
                "<th>参数名称</th><th>参数值</th>\n" +
                "</tr>\n");

        Enumeration<String> parameterNames = request.getParameterNames();

        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            out.print("<tr><td>" + name + "</td>\n<td>");
            String[] parameterValues = request.getParameterValues(name);
            // 读取单个值的数据
            if (parameterValues.length == 1) {
                String paramValue = parameterValues[0];
                if (paramValue.length() == 0)
                    out.println("<i>No Value</i>");
                else
                    out.println(paramValue);
            } else {
                // 读取多个值的数据
                out.println("<ul>");
                for (int i = 0; i < parameterValues.length; i++) {
                    out.println("<li>" + parameterValues[i]);
                }
                out.println("</ul>");
            }
        }
        out.println("</tr>\n</table>\n</body></html>");


    }
    

    // Method to handle POST method request.
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}