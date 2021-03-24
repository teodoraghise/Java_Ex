import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String genre = request.getParameter("genre");

        Book book = Book.builder()
                .id(id)
                .title(title)
                .author(author)
                .genre(genre)
                .build();

        int status = BookBD.update(book);
        if (status > 0) {
            out.print("<p>successfully update</p>");
            out.println("<b><a href ='ViewServlet'> View Books</a></b>");
            request.getRequestDispatcher("/test/view").include(request, response);
        } else {
            out.print("<p>unable to update</p>");
        }


    }
}
