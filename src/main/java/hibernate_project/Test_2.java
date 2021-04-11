package hibernate_project;

import hibernate_project.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

// Для получения объектов из БД используется HQL (Hibernate Query Language)
public class Test_2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction(); // открываем транзакцию

            /*List<Employee> employees = session.createQuery("from Employee")
                    .getResultList(); // создаем запрос для получения всех работников с помощью метода "createQuery"
                                      // и получаем результат с помощью метода "getResultList"*/

            List<Employee> employees = session.createQuery("FROM Employee WHERE name = 'Robert'").getResultList();

            for (Employee employee : employees) {
                System.out.println(employee);
            }

            session.getTransaction().commit(); // закрываем транзакцию

        } finally {
            factory.close();
        }
    }
}
