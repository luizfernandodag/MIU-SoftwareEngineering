package edu.miu.cs.cs425.project.miucarrental.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Column(nullable=false)
    @NotBlank(message = "* First Name is required")
    private String firstName;
    @Column(nullable=false)
    @NotBlank(message = "* Last Name is required")
    private String lastName;
    @Column(nullable=false, unique=true)
    @NotBlank(message = "* Username is required")
    private String username;
    @Column(nullable=false)
    @NotBlank(message = "* Password is required")
    @Size(min=8)
    private String password;
    @Column(nullable=false, unique=true)
    @NotBlank(message = "* Email is required")
    @Email(message="{errors.invalid_email}")
    private String email;
    //to be set when car is rented
    @Column(nullable=true)
    private String driversLicense;
   //@Column(nullable=false)
    //@NotBlank(message = "* Address is required")

@OneToOne(mappedBy = "user", fetch = FetchType.LAZY,
          cascade = CascadeType.ALL)
// @OneToOne(cascade = CascadeType.ALL)
//@JoinTable(
//        name = "users_address",
//        joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "userId")},
//        inverseJoinColumns = {@JoinColumn(name = "ADDRESS_ID", referencedColumnName = "addressId")}
//)
    private Address address;



    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "userId")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "roleId")}
    )
    private List<Role> roles;



    @OneToMany(cascade = CascadeType.ALL)
    private List<RentalCar> RentsAndReservations;


    public User() {
    }

    public User(String firstName, String lastName, String username, String password, String email,String driversLicense, Address address, Role role) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;

        this.address = address;
        this.address.setUser(this);
        this.driversLicense = driversLicense;

        this.roles = new ArrayList<Role>();
        this.roles.add(role);
        this.RentsAndReservations = new ArrayList<RentalCar>();
    }


    public User(String firstName, String lastName, String username, String password, String email,String driversLicense, Address address) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;

        this.address = address;
        this.address.setUser(this);
        this.driversLicense = driversLicense;

        this.roles = new ArrayList<Role>();
        this.RentsAndReservations = new ArrayList<RentalCar>();
    }

    public User(String firstName, String lastName, String username, String password, String email, Address address) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;

        this.address = address;
        this.address.setUser(this);

        this.roles = new ArrayList<Role>();
        this.RentsAndReservations = new ArrayList<RentalCar>();
    }

    public User(String firstName, String lastName, String username, String password, String email, Address address, Role role) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;

        this.address = address;
        this.address.setUser(this);
        this.RentsAndReservations = new ArrayList<RentalCar>();
        this.roles = new ArrayList<Role>();
        role.addUser(this);
        this.roles.add(role);
    }

    public User(String firstName, String lastName, String username, String password, String email, Address address, String roleName) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;

        this.address = address;
        this.address.setUser(this);
        this.roles = new ArrayList<Role>();
        this.RentsAndReservations = new ArrayList<RentalCar>();
        Role role = new Role(roleName);

        role.addUser(this);
        this.roles.add(role);
    }


    public User(String firstName, String lastName, String username, String password, String email, Address address, Role role, RentalCar rentalCarReservation ) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;

        this.address = address;
        this.address.setUser(this);
        this.RentsAndReservations = new ArrayList<RentalCar>();
        this.RentsAndReservations.add(rentalCarReservation);
        this.roles = new ArrayList<Role>();
        role.addUser(this);
        this.roles.add(role);
    }

    public User(String firstName, String lastName, String username, String password, String email, Address address, String roleName,RentalCar rentalCarReservation) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;

        this.address = address;
        this.address.setUser(this);
        this.roles = new ArrayList<Role>();
        this.RentsAndReservations = new ArrayList<RentalCar>();
        this.RentsAndReservations.add(rentalCarReservation);
        Role role = new Role(roleName);

        role.addUser(this);
        this.roles.add(role);
    }






    public User(@NotBlank(message = "* First Name is required") String firstName, @NotBlank(message = "* Last Name is required") String lastName, @NotBlank(message = "* Username is required") String username, @NotBlank(message = "* Password is required") @Size(min = 8) String password, @NotBlank(message = "* Email is required") @Email(message = "{errors.invalid_email}") String email, String driversLicense, Address address, List<Role> roles, List<RentalCar> rentsAndReservations) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.driversLicense = driversLicense;
        this.address = address;
        this.roles = roles;
        this.RentsAndReservations = rentsAndReservations;
    }

    public User(Integer userId, @NotBlank(message = "* First Name is required") String firstName, @NotBlank(message = "* Last Name is required") String lastName, @NotBlank(message = "* Username is required") String username, @NotBlank(message = "* Password is required") @Size(min = 8) String password, @NotBlank(message = "* Email is required") @Email(message = "{errors.invalid_email}") String email, String driversLicense, Address address, List<Role> roles, List<RentalCar> rentsAndReservations) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.driversLicense = driversLicense;
        this.address = address;
        this.roles = roles;
        RentsAndReservations = rentsAndReservations;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    public void addRole (Role role) {


        if(!this.roles.contains(role))
            this.roles.add(role);
        if(!role.getUsers().contains(this))
            role.addUser(this);
    }

    public void addRole (String roleName) {

        Role rolee = new Role(roleName);
        if(!this.roles.contains(rolee))
        this.roles.add(rolee);
        if(!rolee.getUsers().contains(this))
            rolee.addUser(this);

    }

    public void addRentalReservation(RentalCar rentalCarReservation)
    {
        this.RentsAndReservations.add(rentalCarReservation);
    }

    public String getDriversLicense() {
        return driversLicense;
    }

    public void setDriversLicense(String driversLicense) {
        this.driversLicense = driversLicense;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {

        this.address = address;
    }

    @Override
    public String toString() {
        String out =
                "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + " }\n";
        return out;

    }

    public List<RentalCar> getRentsAndReservations() {
        return RentsAndReservations;
    }

    public void setRentsAndReservations(List<RentalCar> rentsAndReservations) {
        RentsAndReservations = rentsAndReservations;
    }
}