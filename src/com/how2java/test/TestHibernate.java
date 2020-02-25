package com.how2java.test;

import com.how2java.pojo.Category;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

import java.util.List;

public class TestHibernate {
    public static void main(String[] args) {

        SessionFactory sf = new Configuration().configure("com/how2java/pojo/hibernate.cfg.xml").buildSessionFactory();

        Session s = sf.openSession();
        s.beginTransaction();

        Category c =new Category();
        c.setName("c1");
        s.save(c);

        Product p = (Product) s.get(Product.class, 1);
        p.setCategory(c);
        s.update(p);



        s.getTransaction().commit();
        s.close();
        sf.close();
    }

}