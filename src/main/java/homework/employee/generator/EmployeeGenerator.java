package homework.employee.generator;

import homework.employee.Employee;
import homework.employee.Position;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EmployeeGenerator {

    private static final String INPUT_FILE_PATH = "src/main/resources/names.txt";
    private int ageFrom;
    private int ageTo;
    private int salaryFrom;
    private int salaryTo;


    public EmployeeGenerator(int ageFrom, int ageTo, int salaryFrom, int salaryTo) {
        this.ageFrom = ageFrom;
        this.ageTo = ageTo;
        this.salaryFrom = salaryFrom;
        this.salaryTo = salaryTo;
    }


    public List<Employee> generate() {

        File file = new File(INPUT_FILE_PATH);
        Random random = new Random();
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parsedName = line.split(" ");
                if (checkParametersForPositivity()) {
                    Employee employee = new Employee(
                            parsedName[0],
                            parsedName[1],
                            random.nextInt(ageFrom, ageTo),
                            new BigDecimal(random.nextInt(salaryFrom, salaryTo)),
                            Position.getRandomPosition()
                    );
                    employees.add(employee);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return employees;
    }

    private boolean checkParametersForPositivity() {
        return ageFrom >= 0 && ageTo >= 0 && salaryFrom >= 0 && salaryTo >= 0;
    }
}
