import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<b><a href ='index.html'> Add a book</a></b>");
        out.println("<h1> Book List </h1>");

        List<Book> books = BookBD.getAllBooks();

        out.print("<table border='2' width='100%'");
        out.print("<tr>" +
                "<th>Id</th>" +
                "<th>Title</th>" +
                "<th>Author</th>" +
                "<th>Genre</th>" +
                "<th colspan ='2'>Actions</th>");

        for (Book book : books) {
            out.print("<tr>" +
                    "<td>" + book.getId() + "</td>" +
                    "<td>" + book.getTitle() + "</td>" +
                    "<td>" + book.getAuthor() + "</td>" +
                    "<td>" + book.getGenre() + "</td>" +
                    "<td><a href='EditServlet?id=" + book.getId() + "'>edit</a></td>" +
                    "<td><a href='DeleteServlet?id=" + book.getId() + "'>delete</a></td>" +
                    "</tr>");
        }
        out.print("</table>");
    }
}
