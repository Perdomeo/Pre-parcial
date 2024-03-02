package model;

/**
 *
 * @author William
 */
public class Vehicle {
    private String plateint;
    private String vehicle;
    private int booth;
    private String brand;
    private String type;

    public Vehicle(String plateint, String vehicle, int booth, String brand, String type) {
        this.plateint = plateint;
        this.vehicle = vehicle;
        this.booth = booth;
        this.brand = brand;
        this.type = type;
    }

    public String getPlateint() {
        return plateint;
    }

    public void setPlateint(String plateint) {
        this.plateint = plateint;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public int getBooth() {
        return booth;
    }

    public void setBooth(int booth) {
        this.booth = booth;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
