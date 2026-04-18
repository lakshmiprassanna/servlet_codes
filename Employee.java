package cse5b4;

public class Employee {

    private int eid;
    private String ename;
    private double salary;
    private int age;

    public Employee(int eid, String ename, double salary, int age) {
        this.eid = eid;
        this.ename = ename;
        this.salary = salary;
        this.age = age;
    }

    public int getEid() {
        return eid;
    }

    public String getEname() {
        return ename;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }
}