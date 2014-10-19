package ru.tsystems.tsproject.tms.model;

import ru.tsystems.tsproject.tms.model.employee.ControlWagon;
import ru.tsystems.tsproject.tms.model.entity.Wagon;

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
@WebServlet(name = "GetListOfWagon")
public class GetListOfWagon extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ControlWagon controlWagon = new ControlWagon();
        List<Wagon> listWagon = controlWagon.getListWagon();
        //сюда возможно вписать распределение по полям
    }
}
