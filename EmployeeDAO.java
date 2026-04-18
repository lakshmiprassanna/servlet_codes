package cse5b4;

import java.sql.*;
import java.util.*;

public class EmployeeDAO {

    static Connection getDBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/24wh1a05b4?serverTimezone=UTC",
                "root",
                "WJ28@krhps"
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Employee> getEmployees() {

        List<Employee> list = new ArrayList<>();

        try {
            Connection con = getDBConnection();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM Employee");

            while (rs.next()) {
                Employee e = new Employee(
                    rs.getInt("eid"),
                    rs.getString("ename"),
                    rs.getDouble("salary"),
                    rs.getInt("age")
                );
                list.add(e);
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void insertEmployee(int eid, String ename, double salary, int age) {
        try {
            Connection con = getDBConnection();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO Employee VALUES (?,?,?,?)"
            );

            ps.setInt(1, eid);
            ps.setString(2, ename);
            ps.setDouble(3, salary);
            ps.setInt(4, age);

            ps.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee(int eid, String ename, double salary, int age) {
        try {
            Connection con = getDBConnection();

            PreparedStatement ps = con.prepareStatement(
                "UPDATE Employee SET ename=?, salary=?, age=? WHERE eid=?"
            );

            ps.setString(1, ename);
            ps.setDouble(2, salary);
            ps.setInt(3, age);
            ps.setInt(4, eid);

            ps.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int eid) {
        try {
            Connection con = getDBConnection();

            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM Employee WHERE eid=?"
            );

            ps.setInt(1, eid);

            ps.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}