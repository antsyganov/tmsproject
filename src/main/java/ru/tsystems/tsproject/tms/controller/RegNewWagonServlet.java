package ru.tsystems.tsproject.tms.controller;

import ru.tsystems.tsproject.tms.model.employee.ControlWagon;
import ru.tsystems.tsproject.tms.model.entity.Wagon;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Anton on 19.10.2014.
 */
//@WebServlet(name = "RegNewWagonServlet")
public class RegNewWagonServlet extends HttpServlet {
    private static ControlWagon controlWagon = new ControlWagon();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String regNumber = request.getParameter("regNumber");
        String numberOfDriver = request.getParameter("numberOfDriver");
        String classCapacity = request.getParameter("classCapacity");

        int nod = Integer.getInteger(numberOfDriver);

        Wagon wagon = new Wagon();
        wagon.setRegNumber(regNumber);
        wagon.setNumberOfDriver(nod);
        wagon.setClassCapacity(classCapacity);
        wagon.setOrderNumber(null);
        wagon.setListOfDrivers(null);


        //Проверим существует ли фура стаким ргистрационным номером
        if( controlWagon.findOnRN(regNumber) )
            out.println("Wagon already exist!");
        //Если нет, то создаем новую
        controlWagon.addNewWagon(wagon);




        out.println("New 'Zapis' created");
        //Driver nd = new Driver();
        /*Entities driver = new Driver();
        Entities wagon = new Wagon();
        Entities order = new Order();*/
        out.println("<h1>OK1</h1>");



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
