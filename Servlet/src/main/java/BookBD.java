import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookBD {

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/books", "postgres", "1234");
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }


    public static int insert(Book book) {
        int status = 0;
        try {
            Connection connection = BookBD.getConnection();
            PreparedStatement ps = connection.prepareStatement(
                    "insert into books(title, author, genre ) values (?, ?, ?)");
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getGenre());
            status = ps.executeUpdate();
            connection.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public static int update(Book book) {
        int status = 0;
        try {
            Connection connection = BookBD.getConnection();
            PreparedStatement update = connection.prepareStatement(
                    "update books set title = ? , author = ?, genre = ? where id = ? ");
            update.setString(1, book.getTitle());
            update.setString(2, book.getAuthor());
            update.setString(3, book.getGenre());
            update.setInt(4,book.getId());
            status = update.executeUpdate();
            connection.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public static int delete(int id) {
        int status = 0;
        try {
            Connection connection = BookBD.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "delete from books where id=?");
            preparedStatement.setInt(1, id);
            status = preparedStatement.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static Book getBookById(int id) {
        Book book = new Book();
        try {
            Connection connection = BookBD.getConnection();
            PreparedStatement ps = connection.prepareStatement(
                    "select * from books where id=?");
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                book.setId(resultSet.getInt(1));
                book.setTitle(resultSet.getString(2));
                book.setAuthor(resultSet.getString(3));
                book.setGenre(resultSet.getString(4));
            }
            connection.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return book;
    }

    public static List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        try {
            Connection connection = BookBD.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from books");
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt(1));
                book.setTitle(resultSet.getString(2));
                book.setAuthor(resultSet.getString(3));
                book.setGenre(resultSet.getString(4));
                books.add(book);
            }
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }
}

