import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Edit Book</h1>");
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);

        Book book = BookBD.getBookById(id);

        out.print("<form action='EditServlet2' method='post'>");
        out.print("<table>");
        out.print("<tr><td></td><td><input type='hidden' name='id' value='" + book.getId() + "'/></td></tr>");
        out.print("<tr><td>Title:</td><td><input type='text' name='title' value='" + book.getTitle() + "'/></td></tr>");
        out.print("<tr><td>Author:</td><td><input type='text' name='author' value='" + book.getAuthor() + "'/></td></tr>");
        out.print("<tr><td>Genre:</td><td>");
        out.print("<select name='genre' style='width:150px'>");
        out.print("<option>Fantasy</option>");
        out.print("<option>Science fiction</option>");
        out.print("<option>Adventure</option>");
        out.print("<option>Other</option>");
        out.print("</select>");
        out.print("</td></tr>");
        out.print("<tr><td colspan='2'><input type='submit' value='Save'/></td></tr>");
        out.print("</table>");
        out.print("</form>");

    }
}



