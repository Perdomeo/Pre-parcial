package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Vehicle;
import mysqlconnection.MySQLConnection;

/**
 *
 * @author William
 */
public class VehicleController {
    MySQLConnection mySQLConnection;
    public VehicleController() {
        mySQLConnection = new MySQLConnection();
    }
    
     public void insert(Vehicle vehicle) {
        // Establishes the connection to the database
        try (Connection conn = mySQLConnection.mySQLConexion()) {
            // Verify if the connection was successful
            if (conn != null) {
                // Prepares the SQL query to insert data
                String insertSQL = "INSERT INTO Vehicle (plateint, vehicle, booth, brand, type) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                    pstmt.setString(1, vehicle.getPlateint());
                    pstmt.setString(2, vehicle.getVehicle());
                    pstmt.setInt(3, vehicle.getBooth());
                    pstmt.setString(4, vehicle.getBrand());
                    pstmt.setString(5, vehicle.getType());
                    // Execute the query
                    int rowsAffected = pstmt.executeUpdate();
                    // Verify if the insertion was successful
                    if (rowsAffected > 0) {
                        System.out.println("Successful integration");
                    } else {
                        System.out.println("Data could not be inserted");
                    }
                }
            } else {
                System.out.println("Could not establish a connection to the database");
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while inserting into the database");
            e.printStackTrace();
        }
    }
    
    public void select() {
        // Establishes the connection to the database
        try (Connection conn = mySQLConnection.mySQLConexion()) {
            // Verify if the connection was successful
            if (conn != null) {
                // Prepares the SQL query to insert data
                String selectSQL = "SELECT * FROM Vehicle";
                try (PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
                    // Execute the query
                    ResultSet rs = pstmt.executeQuery();
                    // Itera on the results
                    while (rs.next()) {
                        System.out.println("Placa: " + rs.getString("plateint") + ", Vehiculo: " + rs.getString("vehicle") + ", Puestos: " + rs.getInt("booth")
                        + ", Marca: " + rs.getString("brand" ) + ", tipo: " + rs.getString("type" ));
                    }
                }
            } else {
                System.out.println("Could not establish a connection to the database");
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while inserting into the database");
            e.printStackTrace();
        }
    }
}
