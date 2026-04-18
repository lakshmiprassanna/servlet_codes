package cse5b4;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/updateEmployeeServlet")
public class UpdateEmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String eidStr = request.getParameter("eid");
            String name = request.getParameter("ename");
            String salaryStr = request.getParameter("salary");
            String ageStr = request.getParameter("age");

            if (eidStr == null || name == null || salaryStr == null || ageStr == null ||
                eidStr.isEmpty() || name.isEmpty() || salaryStr.isEmpty() || ageStr.isEmpty()) {

                response.setContentType("text/html");
                response.getWriter().println("Error: Missing data!");
                return;
            }

            int eid = Integer.parseInt(eidStr);
            double salary = Double.parseDouble(salaryStr);
            int age = Integer.parseInt(ageStr);

            EmployeeDAO dao = new EmployeeDAO();
            dao.updateEmployee(eid, name, salary, age);

            // ✅ redirect to updated table page
            response.sendRedirect("getEmployeeServlet");

        } catch (Exception e) {
            response.setContentType("text/html");
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}