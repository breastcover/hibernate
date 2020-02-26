package com.how2java.pojo;

import lombok.Data;

import java.util.Set;

@Data
public class User {
    int id;
    String name;
    Set<Product> products;
}
