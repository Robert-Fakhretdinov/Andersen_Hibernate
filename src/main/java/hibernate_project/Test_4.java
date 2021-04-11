package hibernate_project;

import hibernate_project.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test_4 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction(); // открываем транзакцию
            /*Employee employee = session.get(Employee.class, 5);
            session.delete(employee);*/

            session.createQuery("DELETE Employee WHERE name = 'Володя'").executeUpdate();


            session.getTransaction().commit(); // закрываем транзакцию

        } finally {
            factory.close();
        }
    }
}
