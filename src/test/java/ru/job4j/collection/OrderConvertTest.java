package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class OrderConvertTest {

    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3sfe"), is(new Order("3sfe", "Dress")));
    }

    @Test
    public void whenListOf3ThenMapOf2() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("33rr", "Dress"));
        orders.add(new Order("33rr", "Dress"));
        orders.add(new Order("55rr", "Jacket"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        int result = map.size();
        assertThat(result, is(2));
    }
}