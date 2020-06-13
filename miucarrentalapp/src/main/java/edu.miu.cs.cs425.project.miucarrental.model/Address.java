    package edu.miu.cs.cs425.project.miucarrental.model;

    import javax.persistence.*;
    import javax.validation.constraints.NotBlank;
    import java.util.List;

    @Entity
    @Table(name = "address")
    public class Address {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)

        private Integer addressId;
      @NotBlank(message = "Street can not be blank")
        @Column(nullable = false)
        private String street;
      @NotBlank(message = "City can not be blank")
        @Column(nullable = false)
        private String city;
       @NotBlank(message = "State can not be blank")
        @Column(nullable = false)
        private String state;
       @NotBlank(message = "ZipCode can not be blank")
        @Column(nullable = false)
        private String zipCode;



//        @OneToOne(fetch = FetchType.LAZY, optional = true)
//        @JoinColumn(name = "user_id", nullable = true)

    //    @Column(nullable = true) NOT ALLOWED
        @OneToOne(mappedBy="address")
        private User user;


        public Address(){

        }

        public Address(String street,String city, String state,String zipCode ){
            this.addressId = addressId;
            this.street = street;
            this.city = city;
            this.state = state;
            this.zipCode = zipCode;

        }
//        public Address(String street,String city, String state,String zipCode){
//            this.addressId = addressId;
//            this.street = street;
//            this.city = city;
//            this.state = state;
//            this.zipCode = zipCode;
//
//        }





        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        @Override
        public String toString() {
            return street + ", " + city + ", " + state + " " + zipCode;


        }


        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public Integer getAddressId() {
            return addressId;
        }

        public void setAddressId(Integer addressId) {
            this.addressId = addressId;
        }
    }

