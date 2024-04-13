package servlets;
import dao.ContactDao;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletResponse;
import models.ContactModel;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{

        try{
            int contactId = Integer.parseInt(request.getParameter("contactId"));

            ContactDao contactDao = new ContactDao();
            boolean success = contactDao.deleteContact(contactId);
            if(success){
                System.out.println("Deleted success");
                response.sendRedirect("display.jsp");
            }else{
                System.out.println("not deleted");
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
