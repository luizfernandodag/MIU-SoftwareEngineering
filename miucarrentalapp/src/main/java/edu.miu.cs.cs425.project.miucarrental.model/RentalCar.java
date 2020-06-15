    package edu.miu.cs.cs425.project.miucarrental.model;

    import org.springframework.format.annotation.DateTimeFormat;

    import javax.persistence.*;
    import javax.validation.constraints.NotBlank;
    import java.time.LocalDate;
    import java.util.List;

    @Entity
    @Table(name = "rental_cars")
    public class RentalCar {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer rentalCarId;
        @NotBlank(message = "pick_up date can not be empty")
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate pickupDate;
        @NotBlank(message = "return_Date can not be empty")
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate returnDate;

        //@OneToOne(cascade = CascadeType.ALL)
        @ManyToOne
        @JoinColumn(name="car_id", nullable=false)
        Car car;

        //@OneToOne()
        @ManyToOne
        @JoinColumn(name="user_id", nullable=false)
        User user;





        public RentalCar(){

        }

        public RentalCar(LocalDate pickupDate, LocalDate returnDate, Car car, User user ) {
            this.pickupDate = pickupDate;
            this.returnDate = returnDate;
            this.car = car;
            this.car.addRentalReservation(this);
            this.user = user;
            this.user.addRentalReservation(this);
        }

        public RentalCar(Integer id) {
            this.rentalCarId = id;
        }



        public LocalDate getPickupDate() {
            return pickupDate;
        }

        public void setPickupDate(LocalDate pickupDate) {
            this.pickupDate = pickupDate;
        }

        public LocalDate getReturnDate() {
            return returnDate;
        }

        public void setReturnDate(LocalDate returnDate) {
            this.returnDate = returnDate;
        }

        public Car getCar() {
            return car;
        }

        public void setCar(Car car) {
            this.car = car;
        }


        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        @Override
        public String toString() {
            return "RentalCar{" +
                    "id=" + rentalCarId +
                    ", pickupDate=" + pickupDate +
                    ", returnDate=" + returnDate +
                    ", car=" + car +
                    ", user=" + user +
                    '}';
        }

        public Integer getRentalCarId() {
            return rentalCarId;
        }

        public void setRentalCarId(Integer rentalCarId) {
            this.rentalCarId = rentalCarId;
        }
    }
