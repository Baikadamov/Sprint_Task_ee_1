package kz.biltlab.narxoz.servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.biltlab.narxoz.db.DBConnection;
import kz.biltlab.narxoz.db.Items;

import java.io.IOException;

@WebServlet(value = "/addItem")
public class itemAddServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    response.setContentType("text/html");
    String name = request.getParameter("item_name");
    String description = request.getParameter("item_description");
    String price = (request.getParameter("item_price"));

    double itemprice = Double.parseDouble(price);

    Items items = new Items();
    items.setName(name);
    items.setDescription(description);
    items.setPrice(itemprice);

    DBConnection.addItem(items);

    response.sendRedirect("/");

  }

}
