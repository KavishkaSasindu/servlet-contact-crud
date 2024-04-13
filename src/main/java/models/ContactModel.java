package models;

public class ContactModel {
    private int Id;
    private String name;
    private String email;
    private String phone;
    private String social;

    public ContactModel(){

    }

    public ContactModel(String name,String email,String phone,String social){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.social = social;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSocial() {
        return social;
    }

    public void setSocial(String social) {
        this.social = social;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
