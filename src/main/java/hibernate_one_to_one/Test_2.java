package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test_2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = factory.getCurrentSession();

            /*Employee employee = new Employee("Света","Савельева", "HR",800);
            Detail detail = new Detail("Питер",898544881,"света@mail.ru");
            detail.setEmployee(employee);
            employee.setDetail(detail);*/

            session.beginTransaction(); // открываем транзакцию
            Detail detail = session.get(Detail.class, 3);
            System.out.println(detail.getEmployee());

//            session.save(detail);
            session.getTransaction().commit(); // закрываем транзакцию

        } finally {
            session.close();
            factory.close();
        }
    }
}
