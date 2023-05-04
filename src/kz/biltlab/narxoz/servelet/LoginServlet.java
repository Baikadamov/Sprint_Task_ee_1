package kz.biltlab.narxoz.servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kz.biltlab.narxoz.db.DBConnection;
import kz.biltlab.narxoz.db.Items;
import kz.biltlab.narxoz.db.Users;

import java.io.IOException;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("/login.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String email = request.getParameter("email");
    String password = request.getParameter("password");

    Users users = DBConnection.getUser(email);
    if(users!=null && users.getPassword().equals(password)){
      HttpSession session = request.getSession();
      session.setAttribute("currentUser",users);
      response.sendRedirect("/profile");
    }else {
      response.sendRedirect("/login?error");
    }
  }




}
