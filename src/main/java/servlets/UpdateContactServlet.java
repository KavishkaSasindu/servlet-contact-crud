package servlets;
import dao.ContactDao;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import models.ContactModel;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/update")
public class UpdateContactServlet extends HttpServlet{
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
        ContactModel contact = new ContactModel();
        PrintWriter write = response.getWriter();
        try{
            int contactId = Integer.parseInt(request.getParameter("contactId"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String social = request.getParameter("social");

            contact.setId(contactId);
            contact.setName(name);
            contact.setEmail(email);
            contact.setPhone(phone);
            contact.setSocial(social);

            ContactDao contactDao = new ContactDao();
            boolean success = contactDao.updateContact(contact);
            if(success){
                System.out.println("updated contact success");
                write.println("<script>alert('updaetd contact success')</script>");
                response.sendRedirect("display.jsp");
            }else{
                System.out.println("not update");
            }

        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
