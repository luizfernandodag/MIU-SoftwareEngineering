
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
            @Column(nullable = false)
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
            private String status;
            private String description;

            @OneToOne
            private CarStatus carStatus;


            @OneToMany(cascade = CascadeType.ALL)
            private List<RentalCar> RentsAndReservations;

            public Car() {
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

            public Car(String carMake,
                       String carBrand,
                       String plateNumber,
                       double rentPrice,
                       String model,
                       String color,
                       String carPicUrl,
                       String status,
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

            public Car(String carMake, String carBrand, String plateNumber, CarStatus carStatus, double rentPrice, String model, String color, byte[] carPic) {
                this.carMake = carMake;
                this.carBrand = carBrand;
                this.plateNumber = plateNumber;
                this.carStatus = carStatus;
                this.rentPrice = rentPrice;
                this.model = model;
                this.color = color;
                this.carPic = carPic;
                this.RentsAndReservations = new ArrayList<RentalCar>();
            }

            public Car(String carMake, String carBrand, String plateNumber, CarStatus carStatus, double rentPrice, String model, String color, byte[] carPic,RentalCar RentsAndReservations) {
                this.carMake = carMake;
                this.carBrand = carBrand;
                this.plateNumber = plateNumber;
                this.carStatus = carStatus;
                this.rentPrice = rentPrice;
                this.model = model;
                this.color = color;
                this.carPic = carPic;
                this.RentsAndReservations = new ArrayList<RentalCar>();
                this.RentsAndReservations.add(RentsAndReservations);
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

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
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

            public void addRentalReservation(RentalCar rentalCarReservation)
            {
                this.RentsAndReservations.add(rentalCarReservation);
            }

        }


