package Modules;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Connection.DbConnection;


public class Author {
    private int id;
    private String name;

    public Author(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Author() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public static void AddAuthor(Author author){
        try {
            Connection connection = DbConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO author VALUES (?)");
            ps.setString(1, author.getName());
            ps.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
