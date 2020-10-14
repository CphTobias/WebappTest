package com.tobias.function.DBAcces.Handlers;

import com.tobias.function.DBAcces.DBSetup.Connector;
import com.tobias.function.DBAcces.Mappers.CarMapper;
import com.tobias.function.function.entities.Car;

import java.sql.*;

import static com.tobias.function.DBAcces.DBSetup.Connector.getConnection;

public class CarHandler {

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

    public void setCarToClosed(int carID, boolean getCarBoolean) throws SQLException, ClassNotFoundException {
        try(Connection conn = Connector.getConnection()) {
            if(getCarBoolean == false){
                PreparedStatement ps2 = conn.prepareStatement(
                        "UPDATE cars SET available = 1 WHERE id = ?;");
                ps2.setInt(1, carID);
                ps2.executeUpdate();
                ps2.close();
            } else {
                PreparedStatement ps3 = conn.prepareStatement(
                        "UPDATE cars SET available = 0 WHERE id = ?;");
                ps3.setInt(1, carID);
                ps3.executeUpdate();
                ps3.close();
            }
        } catch (SQLException | ClassNotFoundException se) {
            throw se;
        }
    }

    public void updatePrice(int carID, double getCarPrice) throws SQLException, ClassNotFoundException {
        try(Connection conn = Connector.getConnection()) {
            PreparedStatement ps2 = conn.prepareStatement(
                    "UPDATE cars SET Price = ? WHERE id = ?;");
            ps2.setDouble(1, getCarPrice);
            ps2.setInt(2, carID);
            ps2.executeUpdate();
            ps2.close();
        } catch (SQLException | ClassNotFoundException se) {
            throw se;
        }
    }
}
