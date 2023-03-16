package homework.streams;

import homework.employee.Employee;
import homework.employee.Position;
import homework.employee.generator.EmployeeGenerator;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class MainForStreams {
    public static void main(String[] args) throws IOException {

        double answer = oddNumbersRatio(10_000);
        System.out.printf("Доля нечетных чисел в потоке - %f\n", answer);


        List<Employee> employees = EmployeeGenerator.generate();
//        for (Employee employee : employees) {
//            System.out.println(employee);
//        }
        Map<Position, BigDecimal> averageSalariesForAllPositions = averageSalaryOnPosition(employees);
        System.out.println(averageSalariesForAllPositions);

        Map<Position, Integer> countOfEmployeesOnEachPosition = numberOfEmployeesByPositions(employees);
        System.out.println(countOfEmployeesOnEachPosition);

    }

    /**
     * 1 Напишите метод, который будет генерировать поток случайных чисел заданного размера
     * (в смысле размер потока, например 10 000 чисел) и определять долю нечетных чисел в нем.
     **/

    public static double oddNumbersRatio(long streamSize) {
        Random random = new Random();
        IntStream stream = random.ints(streamSize);
        double answer = stream
                .filter(num -> num % 2 != 0)
                .count();
        return answer / streamSize;
    }

    /**
     * 2 Создайте метод, который будет принимать коллекцию с сотрудниками
     * (можно использовать класс Employee с урока, только создайте чуть больше объектов)
     * и на выходе выдавать мапу где ключом будет должность сотрудника, а значением - средняя заработная плата на этой должности.
     **/

    public static Map<Position, BigDecimal> averageSalaryOnPosition(List<Employee> list) {
        Map<Position, BigDecimal> map = new HashMap<>();

        Set<Position> positions = list.stream()
                .map(Employee::getPosition)
                .collect(Collectors.toSet());

        for (Position position : positions) {
            double average = list.stream()
                    .filter(e -> e.getPosition().equals(position))
                    .map(Employee::getSalary)
                    .mapToDouble(BigDecimal::doubleValue).average()
                    .getAsDouble();
            map.put(position, new BigDecimal(average).setScale(2, RoundingMode.HALF_UP));
        }

        return map;
    }

    /**
     * 3 Создайте метод, который будет принимать коллекцию с сотрудниками и на выходе выдавать мапу,
     * где ключом будет должность, а значением количество сотрудников, работающих в этой должности.
     **/

    public static Map<Position, Integer> numberOfEmployeesByPositions(List<Employee> list) {
        Map<Position, Integer> map = new HashMap<>();

        Set<Position> positions = list.stream()
                .map(Employee::getPosition)
                .collect(Collectors.toSet());

        for (Position position : positions) {
            long count = list.stream()
                    .filter(e -> e.getPosition().equals(position))
                    .count();
            map.put(position, (int) count);
        }

        return map;
    }


    /**
     * 4 Создайте метод, который будет принимать коллекцию с сотрудниками и на выходе выдавать мапу,
     * где ключами будут отрезки возрастов по 10 лет, типа 20 - 30, 30 - 40 и тп, а значением количество сотрудников
     * в этом возрастном диапазоне. Можно еще одну вариацию, в значение посчитать долю сотрудников в этом возрасте
     * относительно всех сотрудников
     **/

    public static Map<Integer, Integer> numberOfEmployeesByAge(List<Employee> list) {

        return new HashMap<>();
    }

}
