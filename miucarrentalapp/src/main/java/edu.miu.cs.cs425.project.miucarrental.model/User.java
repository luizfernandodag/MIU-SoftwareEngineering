    package edu.miu.cs.cs425.project.miucarrental.model;


    import org.springframework.format.annotation.DateTimeFormat;

    import javax.persistence.*;
//    import javax.validation.Valid;
//    import javax.validation.constraints.NotBlank;
    import java.time.LocalDate;
//    import javax.validation.constraints.NotEmpty;

    @Entity
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
    //    @NotEmpty(message = "First Name Can Not Be Empty")
        @Column(nullable = false)
        private String firstName;
    //    @NotBlank(message = "Last Name Can Not Be Empty")
        @Column(nullable = false)
        private String lastName;

        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate dob;

    //    @NotBlank(message = "License Number  Can Not Be Empty")
        @Column(nullable = false)
        private String driverLicenceNumber;

    //    @Valid
        @OneToOne(cascade = CascadeType.ALL)
        Address address;


        public User(){

        }
        public User(String firstName, String lastName, LocalDate dob, String licenceNumber, Address address){

            this.firstName = firstName;
            this.lastName = lastName;
            this.dob = dob;
            this.driverLicenceNumber = licenceNumber;
            this.address = address;

        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }



        public LocalDate getDob() {
            return dob;
        }

        public void setDob(LocalDate dob) {
            this.dob = dob;
        }

        public String getDriverLicenceNumber() {
            return this.driverLicenceNumber;
        }

        public void setDriverLicenceNumber(String licenceNumber) {
            this.driverLicenceNumber = licenceNumber;
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }



        @Override
        public String toString() {
            return "Customer{" +
                    "id=" + id +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", dob=" + dob +
                    ", driverLicenseNumber='" + this.driverLicenceNumber + '\'' +
                    ", address=" + address +
                    '}';
        }
    }
