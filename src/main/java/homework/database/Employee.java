package homework.database;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
public class Employee {

    private String name;
    private String lastName;
    private Integer age;
    private BigDecimal salary;
    private String position;


    public Employee() {

    }

    public Employee(String name, String lastName, Integer age, BigDecimal salary, String position) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        this.position = position;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", position='" + position + '\'' +
                ", age=" + age +
                '}';
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
