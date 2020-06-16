
package edu.miu.cs.cs425.project.miucarrental.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long carId;
    @NotBlank(message = "Make cannot be blank")
    @Column(nullable = false)
    private String carMake;
    @NotBlank(message = "Brand cannot be blank")
    @Column(nullable = false)
    private String carBrand;
    @NotBlank(message = "Plate Number cannot be blank")
    @Column(nullable = false, unique = true)
    private String plateNumber;
    @Column(nullable = false)
    private double rentPrice;
    @NotBlank(message = "Model cannot be blank")
    private String model;
    @NotBlank(message = "Color cannot be blank")
    private String color;
    @Lob
    @JsonIgnore
    private byte[] carPic;
    private String carPicUrl;

    @Enumerated(EnumType.STRING)
    private CarStatusEnum status;

    @Enumerated(EnumType.STRING)
    private CarType type;

    @Enumerated(EnumType.STRING)
    private DistanceMile distance;

    @Enumerated(EnumType.STRING)
    private PaymentOption paymentOption;

    private String description;

    @OneToOne
    private CarStatus carStatus;


    @OneToMany(cascade = CascadeType.ALL)
    private List<RentalCar> RentsAndReservations;

    public Car() {
    }

    public Car(String carMake,
               String carBrand,
               String plateNumber,
               double rentPrice,
               String model,
               String color,
               String carPicUrl,
               CarStatusEnum status,
               String description,
               CarType carType,
               DistanceMile distanceMile,
               PaymentOption paymentOption) {
        this(carMake, carBrand, plateNumber, rentPrice, model, color, carPicUrl, status, description);
        this.type = carType;
        this.distance = distanceMile;
        this.paymentOption = paymentOption;
    }


    public Car(String carMake,
               String carBrand,
               String plateNumber,
               double rentPrice,
               String model,
               String color,
               String carPicUrl,
               CarStatusEnum status,
               String description) {
        this.carMake = carMake;
        this.carBrand = carBrand;
        this.plateNumber = plateNumber;
        this.rentPrice = rentPrice;
        this.model = model;
        this.color = color;
        this.carPicUrl = carPicUrl;
        this.status = status;
        this.description = description;
    }

    public Car(String carMake,
               String carBrand,
               String plateNumber,
               CarStatus carStatus,
               double rentPrice,
               String model,
               String color,
               byte[] carPic) {
        this(carMake, carBrand, plateNumber, rentPrice, model, color, null, null, null);
        this.carStatus = carStatus;
        this.carPic = carPic;
        this.RentsAndReservations = new ArrayList<RentalCar>();
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public double getPrice() {
        return rentPrice;
    }

    public void setPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public CarStatus getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
    }

    public CarStatusEnum getStatus() {
        return status;
    }

    public void setStatus(CarStatusEnum status) {
        this.status = status;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    public DistanceMile getDistance() {
        return distance;
    }

    public void setDistance(DistanceMile distance) {
        this.distance = distance;
    }

    public PaymentOption getPaymentOption() {
        return paymentOption;
    }

    public void setPaymentOption(PaymentOption paymentOption) {
        this.paymentOption = paymentOption;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public byte[] getCarPic() {
        return carPic;
    }

    public void setCarPic(byte[] carPic) {
        this.carPic = carPic;
    }

    public String getCarPicUrl() {
        return carPicUrl;
    }

    public void setCarPicUrl(String carPicUrl) {
        this.carPicUrl = carPicUrl;
    }

    public Long getCarId() {
        return carId;
    }

    public List<RentalCar> getRentsAndReservations() {
        return RentsAndReservations;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public void setRentsAndReservations(List<RentalCar> rentsAndReservations) {
        RentsAndReservations = rentsAndReservations;
    }

    public void addRentalReservation(RentalCar rentalCarReservation) {
        this.RentsAndReservations.add(rentalCarReservation);
    }

}


