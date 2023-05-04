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

@WebServlet(value = "/saveItem")
public class itemSaveServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    int id = Integer.parseInt(request.getParameter("item_id"));
    String name = request.getParameter("item_name");
    String description = request.getParameter("item_description");
    String price = request.getParameter("item_price");

    double priceitem = Double.parseDouble(price);

    Items items = DBConnection.getItem(id);
    if(items!=null){
      items.setName(name);
      items.setPrice(priceitem);
      items.setDescription(description);
      DBConnection.updateItem(items);
      response.sendRedirect("/details?item_id="+id);
    }else{
      response.sendRedirect("/");
    }

  }

}
