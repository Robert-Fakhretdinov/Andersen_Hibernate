package hibernate_project;

import hibernate_project.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test_1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            Employee employee = new Employee("Володя", "Лавров", "APPLE", 2000);

            session.beginTransaction(); // открываем транзакцию
            session.save(employee); // это команда INSERT
            session.getTransaction().commit(); // закрываем транзакцию

            int id = employee.getId();
            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee empl = session.get(Employee.class, id); // преобразуем строку из таблицы БД в объект
            session.getTransaction().commit();
            System.out.println(empl);



        } finally {
            factory.close();
        }
    }
}
