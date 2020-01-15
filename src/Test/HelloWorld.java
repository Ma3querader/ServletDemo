package Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: panyusheng
 * @Date: 2020/1/15 15:14
 * @Version 1.0
 */
public class HelloWorld extends HttpServlet{
    private String message;
    public void init() throws ServletException
    {
        // Do required initialization
        message = "Hello World123";
    }
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {
        // Set response content type
        response.setContentType("text/html");
        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
    }
    public void destroy()
    {
        // do nothing.
    }
}
