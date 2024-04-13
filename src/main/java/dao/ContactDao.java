package dao;

import db.DbConnection;
import models.ContactModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactDao {

    Connection conn;
    public ContactDao() throws SQLException {
        DbConnection dbConnection = new DbConnection();
        conn = dbConnection.getConnection();
    }

    public boolean addContact(ContactModel contactModel){
        int insertRow=0;
        try{

            final String INSERT_QUERY = "INSERT INTO contact(name,email,phone,social) VALUES(?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(INSERT_QUERY);
            stmt.setString(1,contactModel.getName());
            stmt.setString(2, contactModel.getEmail());
            stmt.setString(3,contactModel.getPhone());
            stmt.setString(4,contactModel.getSocial());
            insertRow = stmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return insertRow>0;
    }

    public List<ContactModel> getAllContact(){

        List<ContactModel> contactList = new ArrayList<>();
        try{
            final String SELECT_QUERY = "SELECT * FROM contact";
            PreparedStatement stmt = conn.prepareStatement(SELECT_QUERY);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String social = rs.getString("social");

                ContactModel contactModel = new ContactModel();

                contactModel.setId(id);
                contactModel.setName(name);
                contactModel.setEmail(email);
                contactModel.setPhone(phone);
                contactModel.setSocial(social);

                contactList.add(contactModel);
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return contactList;
    }

    public ContactModel getOneContact(int contactId){
        ContactModel contactModel =null;
        try{
            final String ONE_DATA_QUERY = "SELECT * FROM contact WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(ONE_DATA_QUERY);
            stmt.setInt(1,contactId);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String social = rs.getString("social");

                contactModel = new ContactModel();

                contactModel.setId(id);
                contactModel.setName(name);
                contactModel.setEmail(email);
                contactModel.setPhone(phone);
                contactModel.setSocial(social);
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return contactModel;
    }

    public boolean updateContact(ContactModel contactModel){
        int insertRow =0;
        try{
            final String UPDATE_QUERY = "UPDATE contact SET name=?,email=?,phone=?,social=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(UPDATE_QUERY);
            stmt.setString(1, contactModel.getName());
            stmt.setString(2,contactModel.getEmail());
            stmt.setString(3,contactModel.getPhone());
            stmt.setString(4,contactModel.getSocial());
            stmt.setInt(5,contactModel.getId());

            insertRow = stmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return insertRow>0;
    }

    public boolean deleteContact(int contactId){
        int rowsDeleted = 0;

        ContactModel contactModel = new ContactModel();
        try{

            final String DELETE_QUERY="DELETE FROM contact WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(DELETE_QUERY);
            stmt.setInt(1,contactId);
            rowsDeleted = stmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return rowsDeleted>0;
    }

}
