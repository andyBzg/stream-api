package homework.database;


import java.math.BigDecimal;
import java.sql.SQLException;

import static homework.database.DatabaseService.*;

public class MainForDatabase {
    public static void main(String[] args) throws SQLException {
        // Создайте класс Employee или используйте тот, что мы создавали для уроков по StreamAPI.
        // Создайте класс сервис, который бы обеспечивал связь этого класса
        // с таблицей в базе данных: вставки новых сотрудников, редактирование данных сотрудника,
        // удаление сотрудника, чтение одного сотрудника по айди,
        // чтение списка сотрудников по какому нибудь фильтру.

        try {
            connectToDB();
            createDB();
//            insert("Alexandr", "Pushkin", 33, new BigDecimal(3000), "Driver");
//            insert("Vasya", "Pupkin", 37, new BigDecimal(2000), "Manager");
//            insert("Ivan", "Ivanov", 45, new BigDecimal(2500), "Director");
//            insert("Ján", "Ĩtor", 40, new BigDecimal(5000), "Janitor");
//            update(2, "Eugen", "Onegin");
//            update(4,"Mad", "Max");
//            deleteById(1);
//            searchById(2);
            showEmployeesOlderThan(40);
//            readDB();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }


    }
}
