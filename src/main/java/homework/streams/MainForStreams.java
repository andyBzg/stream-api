package homework.streams;

import homework.employee.Employee;
import homework.employee.Position;
import homework.employee.generator.EmployeeGenerator;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainForStreams {
    public static void main(String[] args) throws IOException {

        double answer = oddNumbersRatio(10_000);
        System.out.printf("Доля нечетных чисел в потоке - %f\n", answer);


        List<Employee> employees = EmployeeGenerator.generate();
        System.out.println(employees.size());

        Map<Position, BigDecimal> averageSalariesForAllPositions = averageSalaryOnPosition(employees);
        System.out.println(averageSalariesForAllPositions);

        Map<Position, Integer> countOfEmployeesOnEachPosition = numberOfEmployeesByPositions(employees);
        System.out.println(countOfEmployeesOnEachPosition);

        Map<String, Integer> range = numberOfEmployeesByAge(employees);
        System.out.println(range);

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

    public static Map<String, Integer> numberOfEmployeesByAge(List<Employee> list) {

        String str1 = "Age 20 - 30 ";
        String str2 = "Age 31 - 40";
        String str3 = "Age 41 - 50";
        String str4 = "Age 51 - 60";
        String str5 = "Age 61 - 70";
        String str6 = "Age 71 - 80";

        List<String> range = List.of(str1, str2, str3, str4, str5, str6);

        Map<String, Integer> map = new HashMap<>();

        for (String str : range) {
            List<Integer> parsedInt = Arrays.stream(str1.split("-"))
                    .map(s -> s.replaceAll("[^0-9]", ""))
                    .map(Integer::valueOf)
                    .toList();
            long count = list.stream()
                    .filter(e -> e.getAge() >= parsedInt.get(0) && e.getAge() <= parsedInt.get(1))
                    .count();
            map.put(str, (int) count);
        }

        return map;
    }

}
