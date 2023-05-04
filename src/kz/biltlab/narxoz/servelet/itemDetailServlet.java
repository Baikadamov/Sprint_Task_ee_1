package kz.biltlab.narxoz.servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.biltlab.narxoz.db.DBConnection;
import kz.biltlab.narxoz.db.Items;

import java.io.IOException;

@WebServlet(value = "/details")
public class itemDetailServlet extends HttpServlet  {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int id = Integer.parseInt(request.getParameter("item_id"));

      Items item = DBConnection.getItem(id);

      request.setAttribute("item" , item);
      request.getRequestDispatcher("/details.jsp").forward(request,response);
  }

}
