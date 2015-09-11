package com.sparsh.learning.hibernate.client;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sparsh.learning.hibernate.model.Address;
import com.sparsh.learning.hibernate.model.Employee;
import com.sparsh.learning.hibernate.util.HibernateUtil;

/**
 * @author prashant.swamy
 *
 */
public class HibernateHQLClient {

    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();

            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            // SaveNewObjects(session);

            // 1. HQL All records
            System.out.println("\n---------- 1 ----------");
            Query query = session.createQuery("from Employee as e");
            List<Employee> employees = query.list();

            for (Employee employee : employees) {
                System.out.println(employee);
                System.out.println(employee.getAddress());
            }

            // 2. HQL 1 record
            System.out.println("\n---------- 2 ----------");
            query = session.createQuery("from Employee as e where e.id=:id");
            query.setLong("id", 4);
            Employee employee = (Employee) query.uniqueResult();
            System.out.println(employee);

            // 3. Get method
            System.out.println("\n---------- 3 ----------");
            employee = (Employee) session.get(Employee.class, 5l);
            System.out.println(employee);

            // 4. Load method
            System.out.println("\n---------- 4 ----------");
            employee = (Employee) session.load(Employee.class, 5l);
            System.out.println(employee);

            // 5. Get method
            System.out.println("\n---------- 5 ----------");
            employee = (Employee) session.get(Employee.class, 6l);
            System.out.println(employee);

            // 6. Load method
            try {
                System.out.println("\n---------- 6 ----------");
                employee = (Employee) session.load(Employee.class, 6l);
                System.out.println(employee);
            } catch (Exception e) {
                System.out.println("Load returned error.");
            }

            transaction.commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }

    /**
     * @param session
     */
    private static void SaveNewObjects(final Session session) {
        Employee employee = new Employee("Prashant Swamy", 12345.92);

        session.save(employee);

        Address address = new Address("Petals Wakad", "411014", "Pune");
        address.setEmployee(employee);

        session.save(address);
    }
}
