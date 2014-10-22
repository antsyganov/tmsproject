package ru.tsystems.tsproject.tms.service;

import ru.tsystems.tsproject.tms.model.employee.ControlOrder;
import ru.tsystems.tsproject.tms.model.entity.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Anton on 19.10.2014.
 */
@WebServlet(name = "AddNewOrderServlet")
public class AddNewOrderServlet extends HttpServlet {
    private static ControlOrder controlOrder = new ControlOrder();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Order newOrder = new Order();

        controlOrder.addNewOrder(newOrder);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
