package com.tmall.service;

import com.tmall.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> list();

    void add(Order order);

    void delete(int id);

    void update(Order order);

    Order get(int id);

    String waitPay = "waitPay";
    String waitDelivery = "waitDelivery";
    String waitConfirm = "waitConfirm";
    String waitReview = "waitReview";
    String finish = "finish";
    String delete = "delete";

}
