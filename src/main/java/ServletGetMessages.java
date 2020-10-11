import com.tobias.DBAcces.Mappers.MessageMapper;
import com.tobias.function.entities.ContactMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ServletGetMessages")
public class ServletGetMessages extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MessageMapper messageMapper = new MessageMapper();
        String username = request.getParameter("messages");

        List<ContactMessage> cMessage = messageMapper.getContactMessages(username.equals("Closed"));



        request.setAttribute("activeCM", cMessage);
        request.getRequestDispatcher("/WEB-INF/ContactMessageSend.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
