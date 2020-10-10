import com.tobias.function.DBAcces.Mappers.CarMapper;
import com.tobias.function.function.entities.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ServletUser")
public class ServletUser extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CarMapper carMapper = new CarMapper();
        String username = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");

        List<Car> cars = carMapper.getAllCars();

        //cars = {"BMW", "Volvo", "Tesla"};
        //cars.add("BMW");
        //cars.add("Volvo");
        //cars.add("Tesla");
        request.setAttribute("billist", cars);

        String newmessage = "Hej " + username + " Du er igang med at sende en mail :)";
        request.setAttribute("welcomemessage", newmessage);
        request.getRequestDispatcher("/WEB-INF/Welcome.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
