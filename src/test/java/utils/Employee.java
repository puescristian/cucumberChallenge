package utils;

import lombok.Data;

@Data
public class Employee {
    private String lastName;
    private String user;
    private String name;
    private String middleName;
    private String pass;

    public Employee() {
        String middleName = String.valueOf(Math.random()).substring(2, 5);
        this.pass = "Automation123";
        this.name = "employee";
        this.user = "employee_" + middleName;
        this.middleName = middleName;
        this.lastName = "automation";
    }

    public Employee(String name, String middleName, String lastName) {
        this.pass = "Automation123";
        this.name = name;
        this.user = name + middleName;
        this.middleName = middleName;
        this.lastName = lastName;
    }


}
