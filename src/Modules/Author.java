package Modules;

import java.io.File;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Connection.DbConnection;


public class Author {
    private int id;
    private String name;

    public Author(int id, String name){
        this.id = id;
        this.name = name;
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

    public static int AddAuthor(Author author) {
        int authorId = 1;
        try {
            Connection connection = DbConnection.getConnection();
            PreparedStatement checkAuthor = connection.prepareStatement("SELECT id FROM author WHERE author.name = ?");
            checkAuthor.setString(1, author.getName());
            ResultSet result = checkAuthor.executeQuery();

            if (result.next()) {
                System.out.println("Author already exists, no need to add again.");
                authorId = result.getInt("id");
            } else {
                try {
                    PreparedStatement insertAuthor = connection.prepareStatement("INSERT INTO author (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
                    insertAuthor.setString(1, author.getName());
                    insertAuthor.executeUpdate();

                    ResultSet generatedKeys = insertAuthor.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        authorId = generatedKeys.getInt(1);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return authorId;
    }
    public static void UpdateAuthor(Author author){
        try {
            Connection connect = DbConnection.getConnection();
            PreparedStatement ps = connect.prepareStatement("UPDATE author SET name = ?");
            ps.setString(1,author.getName());
            ps.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
