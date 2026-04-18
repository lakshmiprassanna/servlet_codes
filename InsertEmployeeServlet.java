package cse5b4;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/insertEmployeeServlet")
public class InsertEmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            String idStr = request.getParameter("eid");
            String name = request.getParameter("ename");
            String salaryStr = request.getParameter("salary");
            String ageStr = request.getParameter("age");

            if (idStr == null || name == null || salaryStr == null || ageStr == null ||
                idStr.isEmpty() || name.isEmpty() || salaryStr.isEmpty() || ageStr.isEmpty()) {

                out.println("Error: Missing data!");
                return;
            }

            int eid = Integer.parseInt(idStr);
            double salary = Double.parseDouble(salaryStr);
            int age = Integer.parseInt(ageStr);

            EmployeeDAO dao = new EmployeeDAO();
            dao.insertEmployee(eid, name, salary, age);

            out.println("<h3>Employee Inserted Successfully!</h3>");

        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}