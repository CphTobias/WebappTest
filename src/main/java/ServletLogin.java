import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //UserMapper userMapper = new UserMapper();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //User loggedInUser = userMapper.login(username, password);

        //request.setAttribute("login", loggedInUser);

        request.getRequestDispatcher("/WEB-INF/Welcome.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
