package test;

import entities.Order;
import entities.Ticket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestTicket {
    @Test
    void testGetterSetter(){
        Ticket ticket = new Ticket(new Order());

        Order order = new Order();
        ticket.setOrder(order);
        assertSame(ticket.getOrder(), order);
    }

    @Test
    void testContainer(){
        Order order = new Order();
        Ticket ticket = new Ticket(order);
        assertSame(ticket.getOrder(), order);
    }
}
