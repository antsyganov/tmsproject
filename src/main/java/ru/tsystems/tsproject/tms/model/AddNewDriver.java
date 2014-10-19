package ru.tsystems.tsproject.tms.model;

import ru.tsystems.tsproject.tms.model.employee.ControlDrivers;
import ru.tsystems.tsproject.tms.model.entity.Driver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Anton on 19.10.2014.
 */
@WebServlet(name = "AddNewDriver")
public class AddNewDriver extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String patronymic = request.getParameter("patronymic");
        String licenseNumber = request.getParameter("licenseNumber");

        ControlDrivers controlDrivers = new ControlDrivers();

        if( controlDrivers.findOnLN(licenseNumber))
            out.println("Driver already exist");

        Driver newDriver = new Driver();
        newDriver.setFirstName(firstName);
        newDriver.setLastName(lastName);
        newDriver.setPatronymic(patronymic);
        newDriver.setLicenseNumber(licenseNumber);
        newDriver.setStatus("Not on shift");
        newDriver.setWagon(null);

        controlDrivers.addNewDriver(newDriver);

        out.println("New driver added!");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
