package ru.geekbrains.lesson5;

import java.util.ArrayList;
import java.util.List;

public class LessonFiveMain {
    private static List<Employee> employees;

    static {
        employees = new ArrayList<>();

        employees.add(new Employee("Dima Kravchenko", "Mechanical Engineer",
                "kravchenko@mail.ru", "+3-050-223-23-34", 2900, 34));
        employees.add(new Employee("Igor Kulgachov", "Mechanical Engineer",
                "kulgachov88@gmail.com", "+7-978-827-65-99", 3200, 32));
        employees.add(new Employee("Pavel Nevar", "Electrical Engineer",
                "nevar@gmail.com", "+7-978-323-35-93", 3000, 32));
        employees.add(new Employee("Vitaliy Prislupskiy", "Senior Engineer",
                "v.prislupskiy@telemenia.com", "+3-050-222-32-99", 3500, 40));
        employees.add(new Employee("Sergey Shataluk", "Senior Electrical Engineer",
                "shataliuk@telemenia.com", "+3-098-255-66-99", 3400, 52));
    }

    private static void print(int age) {
        for (Employee employee : employees) {
            if (employee.getAge() >= age) {
                employee.printEmployeeInfo();
            }
        }
    }

    public static void main(String[] args) {
        print(40);
    }


}
