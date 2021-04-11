package hibernate_project;

import hibernate_project.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test_3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction(); // открываем транзакцию
            /*Employee employee = session.get(Employee.class,1);
            employee.setSalary(3000); // меняем зарплату*/

            session.createQuery("UPDATE Employee SET salary = 2500 WHERE name = 'Володя'").executeUpdate();
            session.getTransaction().commit(); // закрываем транзакцию

        } finally {
            factory.close();
        }
    }
}
