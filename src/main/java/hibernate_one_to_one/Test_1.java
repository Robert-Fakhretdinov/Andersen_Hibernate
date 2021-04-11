package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test_1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = factory.getCurrentSession();
            /*Employee employee = new Employee("Вася","Иванов", "HR",600);
            Detail detail = new Detail("Питер",896554881,"вася@mail.ru");
            employee.setDetail(detail);*/


            session.beginTransaction(); // открываем транзакцию
            Employee employee = session.get(Employee.class,2);
            session.delete(employee); // благодаря @OneToOne(cascade = CascadeType.ALL) удаляется Employee и Detail
//            session.save(employee);
            session.getTransaction().commit(); // закрываем транзакцию

        } finally {
            session.close();
            factory.close();
        }
    }
}
