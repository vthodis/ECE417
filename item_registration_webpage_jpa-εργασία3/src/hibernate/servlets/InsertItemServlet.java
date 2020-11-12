package hibernate.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
 
import hibernate.entity.Item;
import hibernate.util.HibernateUtils;
 
@WebServlet("/InsertItemServlet")
public class InsertItemServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
        String barcode = request.getParameter("barcode");
        String name = request.getParameter("name");
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        
        
        if(barcode.isBlank() || name.isBlank() || color.isBlank() || description.isBlank()) {
        	response.sendRedirect("fail.jsp");
        }
        
        else {
 
	        Item item = new Item();
	        
	        item.setBarcode(barcode);
	        item.setName(name);
	        item.setColor(color);
	        item.setDescription(description);
	 
	        boolean ans;
	        SessionFactory factory = HibernateUtils.getSessionFactory();
	        Session session = factory.openSession();
	 
	        
	
	        Query query = session.createNativeQuery("select * from items.item where barcode = ?");
	        query.setParameter(1, item.getBarcode());
	        List<Item> iteml= query.list();
	        
			ans = iteml.isEmpty();	
			
			if (ans == true) {
	
				Transaction tx = session.beginTransaction();
		        session.save(item);
		 
	
		        tx.commit();
		        session.close();
		        response.sendRedirect("GetDataServlet");
			}
			else {
				 response.sendRedirect("fail.jsp");
			}
        }
        
        
    }
        
}