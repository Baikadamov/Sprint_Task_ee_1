package kz.biltlab.narxoz.servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.biltlab.narxoz.db.DBConnection;
import kz.biltlab.narxoz.db.DBManager;

import java.io.IOException;

@WebServlet(value = "/deleteItem")
public class deleteItemServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    int id = Integer.parseInt(request.getParameter("id"));
    DBConnection.deleteItem(id);

    response.sendRedirect("/");

  }


}
