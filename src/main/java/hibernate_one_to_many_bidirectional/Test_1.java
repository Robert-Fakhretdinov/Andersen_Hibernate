package hibernate_one_to_many_bidirectional;


import hibernate_one_to_many_bidirectional.entity.Department;
import hibernate_one_to_many_bidirectional.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test_1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;

        try {
            /*session = factory.getCurrentSession();
            Department department = new Department("IT",5000,500);
            Employee employee_1 = new Employee("Света", "Гончарова",1000);
            Employee employee_2 = new Employee("Оля", "Беккер",1200);
            Employee employee_3 = new Employee("Роберт", "Родригес",2500);
            department.addEmployeeToDepartment(employee_1);
            department.addEmployeeToDepartment(employee_2);
            department.addEmployeeToDepartment(employee_3);

            session.beginTransaction(); // открываем транзакцию
            session.save(department);
            session.getTransaction().commit(); // закрываем транзакцию*/

            // **********************************************

            session = factory.getCurrentSession();

            session.beginTransaction(); // открываем транзакцию
            Department department = session.get(Department.class,3);
            System.out.println(department);
            System.out.println(department.getList());
            session.getTransaction().commit(); // закрываем транзакцию

        } finally {
            session.close();
            factory.close();
        }
    }
}
