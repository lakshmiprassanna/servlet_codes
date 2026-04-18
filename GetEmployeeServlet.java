package cse5b4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/getEmployeeServlet")
public class GetEmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        EmployeeDAO dao = new EmployeeDAO();
        List<Employee> list = dao.getEmployees();

        //out.println("<h1>Employee Management System</h1>");
        out.println("<h2>Name: MADHUMITHA</h2>");
        out.println("<h3>Roll No: 24WH1A05B4</h3>");
        //out.println("<hr>");

        out.println("<h2>Employee Details</h2>");
        out.println("<table border='1'>");
        out.println("<tr><th>ID</th><th>Name</th><th>Salary</th><th>Age</th></tr>");

        for (Employee e : list) {
            out.println("<tr>");
            out.println("<td>" + e.getEid() + "</td>");
            out.println("<td>" + e.getEname() + "</td>");
            out.println("<td>" + e.getSalary() + "</td>");
            out.println("<td>" + e.getAge() + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
    }
}