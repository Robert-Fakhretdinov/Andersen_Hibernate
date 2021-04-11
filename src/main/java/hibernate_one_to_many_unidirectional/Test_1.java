package hibernate_one_to_many_unidirectional;



import hibernate_one_to_many_unidirectional.entity.Department;
import hibernate_one_to_many_unidirectional.entity.Employee;
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
            Department department = new Department("HR",3000,300);
            Employee employee_1 = new Employee("Наташа", "Цветикова",900);
            Employee employee_2 = new Employee("Олег", "Шустров",1200);
            department.addEmployeeToDepartment(employee_1);
            department.addEmployeeToDepartment(employee_2);

            session.beginTransaction(); // открываем транзакцию
            session.save(department);
            *//*Department department = session.get(Department.class,1);
            System.out.println(department);
            System.out.println(department.getList());*//*
            session.getTransaction().commit(); // закрываем транзакцию*/

            // *************************************

            session = factory.getCurrentSession();
            session.beginTransaction(); // открываем транзакцию

            Department department = session.get(Department.class,2);
            session.delete(department);

            session.getTransaction().commit(); // закрываем транзакцию

        } finally {
            session.close();
            factory.close();
        }
    }
}
