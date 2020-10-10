package com.tobias.function.DBAcces.Mappers;

import com.tobias.function.function.entities.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.tobias.function.DBAcces.DBSetup.Connector.getConnection;

public class CarMapper {

    private Car loadCar(ResultSet rs) throws SQLException {
        return new Car(
                //int id, int horsepower, String make, String model, int weight, int buildyear, int milage, String imagename
                rs.getInt("cars.id"),
                rs.getInt("cars.horsepower"),
                rs.getString("cars.make"),
                rs.getString("cars.model"),
                rs.getInt("cars.weight"),
                rs.getInt("cars.buildyear"),
                rs.getInt("cars.milage"),
                rs.getString("cars.imagename"));
    }

    public List<Car> getAllCars() {
        try (Connection conn = getConnection()) {
            PreparedStatement s = conn.prepareStatement("SELECT * FROM cars;");
            ResultSet rs = s.executeQuery();
            ArrayList<Car> cars = new ArrayList<>();
            while(rs.next()) {
                cars.add(loadCar(rs));
            }
            return cars;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
