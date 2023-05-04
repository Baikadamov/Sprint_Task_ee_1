package kz.biltlab.narxoz.servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.biltlab.narxoz.db.DBConnection;
import kz.biltlab.narxoz.db.DBManager;
import kz.biltlab.narxoz.db.Items;
import kz.biltlab.narxoz.db.Tasks;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


@WebServlet(value = "/home.html")
public class HomeServlet extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    response.setContentType("text/html");
    ArrayList<Items> items =DBConnection.getItems();

    request.setAttribute("items",items);
    request.getRequestDispatcher("/index.jsp").forward(request,response);




  }
}
