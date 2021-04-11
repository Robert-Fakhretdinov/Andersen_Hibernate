package hibernate_many_to_many;

import hibernate_many_to_many.entity.Child;
import hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;
        try {
            /*session = sessionFactory.getCurrentSession();
            Child child_1 = new Child("Вася",10);
            Child child_2 = new Child("Оля",9);
            Child child_3 = new Child("Петя",8);
            Section section_1 = new Section("Футбол");
            section_1.addChildToSection(child_1);
            section_1.addChildToSection(child_2);
            section_1.addChildToSection(child_3);

            session.beginTransaction();
            session.save(section_1);
            session.getTransaction().commit();*/

            // **********************************************

            /*session = sessionFactory.getCurrentSession();
            Child child_1 = new Child("Игорь",10);

            Section section_1 = new Section("Волейбол");
            Section section_2 = new Section("Шахматы");
            Section section_3 = new Section("Лыжи");
            child_1.addSectionTOChild(section_1);
            child_1.addSectionTOChild(section_2);
            child_1.addSectionTOChild(section_3);

            session.beginTransaction();
            session.save(child_1);
            session.getTransaction().commit();*/

            // **********************************************

            /*session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Section section = session.get(Section.class,1);
            System.out.println(section);
            System.out.println(section.getChildList());
            session.getTransaction().commit();*/

            // **********************************************

            /*session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Child child = session.get(Child.class,1);
            System.out.println(child);
            System.out.println(child.getSectionList());
            session.getTransaction().commit();*/

            // **********************************************

            /*session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Section section = session.get(Section.class,1);
            session.delete(section);
            session.getTransaction().commit();*/

            // **********************************************

            /*session = sessionFactory.getCurrentSession();
            Section section_1 = new Section("Танцы");

            Child child_1 = new Child("Ринат",7);
            Child child_2 = new Child("Катя",11);
            Child child_3 = new Child("Володя",8);

            section_1.addChildToSection(child_1);
            section_1.addChildToSection(child_2);
            section_1.addChildToSection(child_3);

            session.beginTransaction();
            session.persist(section_1);
            session.getTransaction().commit();*/

            // **********************************************

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Section section = session.get(Section.class, 7);
            session.delete(section);

            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();

        }

    }
}
