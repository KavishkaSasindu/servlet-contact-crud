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

@WebServlet("/add")
public class AddContactServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        ContactModel contactModel = new ContactModel();
        PrintWriter write = response.getWriter();
        try{
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String social = request.getParameter("social");

            ContactDao contactDao = new ContactDao();
            contactModel.setName(name);
            contactModel.setEmail(email);
            contactModel.setPhone(phone);
            contactModel.setSocial(social);
            boolean success = contactDao.addContact(contactModel);
            if(success){
                System.out.println("User added success");
                response.sendRedirect("display.jsp");
            }else{
                write.println("contact does not added");
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
