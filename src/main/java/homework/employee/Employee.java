package homework.employee;

import java.math.BigDecimal;
import java.util.Objects;


public class Employee {

    private String name;
    private String lastName;
    private Integer age;
    private BigDecimal salary;
    private Position position;


    public Employee() {

    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, String lastName, Integer age, BigDecimal salary, Position position) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return name + ", " + lastName + ", " + age + ", " + salary + ", " + position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        return Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
