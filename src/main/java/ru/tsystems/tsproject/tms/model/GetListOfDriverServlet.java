package ru.tsystems.tsproject.tms.model;

import ru.tsystems.tsproject.tms.model.employee.ControlDrivers;
import ru.tsystems.tsproject.tms.model.entity.Driver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Anton on 19.10.2014.
 */
@WebServlet(name = "GetListOfDriverServlet")
public class GetListOfDriverServlet extends HttpServlet {
    private static ControlDrivers controlDrivers = new ControlDrivers();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Driver> driverList = controlDrivers.getListDriver();
    }
}
