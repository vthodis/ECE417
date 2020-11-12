package hibernate.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
 
import hibernate.entity.Item;
import hibernate.util.HibernateUtils;
 
@WebServlet("/GetDataServlet")
public class GetDataServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
 
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
      SessionFactory factory = HibernateUtils.getSessionFactory();
      Session session = factory.openSession();
 
      Query query = session.createQuery("from Item");
 
      List<Item> items = query.list();

      session.close();
     
      request.setAttribute("items", items);
 
      request.getRequestDispatcher("itemsDetails.jsp").forward(request, response);        
    }
}