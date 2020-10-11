import com.tobias.function.DBAcces.Mappers.MessageMapper;
import com.tobias.function.function.entities.ContactMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ListIterator;

@WebServlet("/ServletGetMessages")
public class ServletGetMessages extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MessageMapper messageMapper = new MessageMapper();
        String username = request.getParameter("messages");

        List<ContactMessage> cMessage = messageMapper.getContactMessages(username.equals("Closed Messages"));

        for (int i = 0; i < cMessage.size(); i++) {
            cMessage.get(i).getCreatedAt().format(DateTimeFormatter.ISO_TIME);
        }

        request.setAttribute("activeCM", cMessage);
        request.getRequestDispatcher("/WEB-INF/adminpage.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
