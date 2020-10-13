package com.tobias.function.DBAcces.Handlers;

import com.tobias.function.DBAcces.Mappers.CarMapper;
import com.tobias.function.function.entities.Car;

import java.sql.*;

import static com.tobias.function.DBAcces.DBSetup.Connector.getConnection;

public class CarHandler {

    private Car loadCar(ResultSet rs) throws SQLException {
        return new Car(
                rs.getInt("cars.id"),
                rs.getInt("cars.horsepower"),
                rs.getString("cars.brand"),
                rs.getDouble("cars.price"),
                rs.getString("cars.category"),
                rs.getString("cars.model"),
                rs.getInt("cars.weight"),
                rs.getInt("cars.buildyear"),
                rs.getInt("cars.milage"),
                rs.getString("cars.image"),
                rs.getBoolean("cars.available"));
    }

    public Car createCar(int horsepower, String brand, double price, String category, String model, int weight, int buildyear,
                                               int milage, String image){
        CarMapper cMapper = new CarMapper();
        int id = 0;
        try (Connection conn = getConnection()) {
            var ps =
                    conn.prepareStatement(
                            "INSERT INTO cars (Horsepower, Brand, Price, Category, Model, Weight, BuildYear, Milage, Imagename) " +
                                    "VALUE (?,?,?,?,?,?,?,?,?);",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, horsepower);
            ps.setString(2, brand);
            ps.setDouble(3, price);
            ps.setString(4, category);
            ps.setString(5, model);
            ps.setInt(6, weight);
            ps.setInt(7, buildyear);
            ps.setInt(8, milage);
            ps.setString(9, image);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            } else {
                System.out.println("Car does not exist throw");;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return cMapper.findCar(id);
    }
}
