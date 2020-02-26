package com.how2java.test;

import com.how2java.pojo.Category;
import com.how2java.pojo.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestHibernate {
    public static void main(String[] args) {

        SessionFactory sf = new Configuration().configure("com/how2java/pojo/hibernate.cfg.xml").buildSessionFactory();

        Session s = sf.openSession();
        s.beginTransaction();

        //增加3个用户
        Set<User> users = new HashSet();
        for (int i = 0; i < 3; i++) {
            User u =new User();
            u.setName("user"+i);
            users.add(u);
            s.save(u);
        }

        //产品1被用户1,2,3购买
        Product p1 = (Product) s.get(Product.class, 1);

        p1.setUsers(users);
        s.save(p1);



        s.getTransaction().commit();
        s.close();
        sf.close();
    }

}