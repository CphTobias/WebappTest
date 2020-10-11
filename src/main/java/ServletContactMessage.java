import com.tobias.DBAcces.Handlers.MessageHandler;
import com.tobias.function.entities.ContactMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/ServletContactMessage")
public class ServletContactMessage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MessageHandler messageHandler = new MessageHandler();
        String username = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");

        ContactMessage cMessage = messageHandler.createContactMessage(LocalDateTime.now(),username, email, message);

        String formatedName = " " + cMessage.getName();
        String formatedEmail = " " + cMessage.getEmail();
        String formatedCMessage = " " + cMessage.getMessage();


        request.setAttribute("name", formatedName);
        request.setAttribute("email", formatedEmail);
        request.setAttribute("message", formatedCMessage);

        request.getRequestDispatcher("/WEB-INF/ContactMessageSend.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //MessageMapper messageMapper = new MessageMapper();
        //List<ContactMessage> cMessage = messageMapper.getContactMessages(true);

        //request.setAttribute("activeCM", cMessage);
        //request.getRequestDispatcher("/WEB-INF/ContactMessageSend.jsp").forward(request, response);
    }
}
