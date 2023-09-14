package Modules;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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

    public User() {

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

    public static int AddUser(User user) {
        int userId = 1;
        try {
            Connection connect = DbConnection.getConnection();
            PreparedStatement checkIdCard = connect.prepareStatement("SELECT idCard FROM users WHERE users.idCard = ?");
            checkIdCard.setString(1,user.getIdCard());
            ResultSet result = checkIdCard.executeQuery();
            if(result.next()){
                System.out.println("user id card is already exist so we just gonna keep the operation of borrowing based on your id card");
            }else {
                try {
                    Connection connection = DbConnection.getConnection();
                    PreparedStatement prepare = connection.prepareStatement("SELECT id FROM users WHERE name = ?");
                    prepare.setString(1, user.getName());
                    ResultSet rs = prepare.executeQuery();

                    if (!rs.next()) {
                        // User does not exist, insert a new user
                        PreparedStatement insertUser = connection.prepareStatement("INSERT INTO users (name, idCard, phone) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
                        insertUser.setString(1, user.getName());
                        insertUser.setString(2, user.getIdCard());
                        insertUser.setString(3, user.getPhone());
                        insertUser.executeUpdate();

                        ResultSet generatedKeys = insertUser.getGeneratedKeys();
                        if (generatedKeys.next()) {
                            userId = generatedKeys.getInt(1);
                        }
                    } else {
                        userId = rs.getInt("id");
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }
        return userId;
    }

}
