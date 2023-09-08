package Modules;
import java.sql.Connection;
import java.sql.PreparedStatement;

import Connection.DbConnection;

public class User {
    private int id;
    private String name;
    private String idCard;
    private String phone;

    public User(int id, String name, String idCard, String phone){
        this.id = id;
        this.name = name;
        this.idCard = idCard;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public static int AddUser(User user){
        int update = 0;
        try {
            Connection connection = DbConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO users VALUES (?,?,?,?)");
            ps.setInt(1,user.getId());
            ps.setString(2,user.getName());
            ps.setString(3,user.getIdCard());
            ps.setString(4,user.getPhone());
            update = ps.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
        return update;
    }
}
