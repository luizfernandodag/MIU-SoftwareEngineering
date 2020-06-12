    package edu.miu.cs.cs425.project.miucarrental.model;

    import org.springframework.format.annotation.DateTimeFormat;

    import javax.persistence.*;
    import java.time.LocalDate;

    @Entity
    public class RentalCar {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        //@NotBlank(message = "pick_up date can not be empty")
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate pickupDate;
        //@NotBlank(message = "return_Date can not be empty")
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate returnDate;

        @OneToOne(cascade = CascadeType.ALL)
        Car car;

        @OneToOne()
        User user;


        public RentalCar(){

        }

        public RentalCar(LocalDate pickupDate, LocalDate returnDate, Car car, User user ) {
            this.pickupDate = pickupDate;
            this.returnDate = returnDate;
            this.car = car;
            this.user = user;
        }

        public RentalCar(Long id) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
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
                    "id=" + id +
                    ", pickupDate=" + pickupDate +
                    ", returnDate=" + returnDate +
                    ", car=" + car +
                    ", user=" + user +
                    '}';
        }
    }
