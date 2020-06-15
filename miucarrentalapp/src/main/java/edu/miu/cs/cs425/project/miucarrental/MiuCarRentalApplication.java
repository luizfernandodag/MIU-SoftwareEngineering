package edu.miu.cs.cs425.project.miucarrental;

import edu.miu.cs.cs425.project.miucarrental.model.Address;
import edu.miu.cs.cs425.project.miucarrental.model.Role;
import edu.miu.cs.cs425.project.miucarrental.model.User;
import edu.miu.cs.cs425.project.miucarrental.repository.AddressRepository;
import edu.miu.cs.cs425.project.miucarrental.repository.RoleRepository;
import edu.miu.cs.cs425.project.miucarrental.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.time.LocalDate;

//@SpringBootApplication
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class MiuCarRentalApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MiuCarRentalApplication.class, args);
    }
//ADD SOME INITIAL DATA
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private AddressRepository addressRepository;
    private User saveUser(User user)
    {
        return userRepository.save(user);
    }
    private Role saveRole(Role role)
    {
        return this.roleRepository.save(role);
    }
    private Address saveAddress(Address address)
    {
        return this.addressRepository.save(address);
    }


    @Override
    public void run(String... args) throws Exception {
        //ROLES
        Role roleANONYMOUS = new Role("ANONYMOUS");
        Role roleCUSTOMER = new Role("CUSTOMER");
        Role roleADMIN = new Role("ADMIN");
        //ADRESS TEST
         Address addr = new Address("test street", "Fairfield", "IOWA", "56728");
        Address addr2 = new Address("test2 street", "Fairfield", "IOWA", "56728");
        Address addr3 = new Address("test3 street", "Fairfield", "IOWA", "56728");
        //USERS
        String driverLicense = "G340-560-139-985";
        User userAnonymous = new User("USER","ANONYMOUS", "ANONYMOUS", "123456789", "anonymous@miucarrent.com",addr,roleANONYMOUS);
        User userCustomer = new User("USER","CUSTOMER", "CUSTOMER", "123456789", "customer@miucarent.com",addr2,roleCUSTOMER);
        User userAdmin = new User("USER","ADMIN", "ADMIN", "123456789", "admin@miucarrent.com",addr3,roleADMIN);



        //User userCustomer = new User("USER", "CUSTOMER", "G340-560-139-986", addr, roleCUSTOMER);
        //User userAdmin = new User("USER", "ADMIN", LocalDate.now(), "G340-560-139-986", addr, roleADMIN);
        //SAVE USERS AND ROLES/ADDRESS CASCADE
        if(userAnonymous == null)
            System.out.println("NULL");
        else
        {
            System.out.println(userAnonymous);
        }
     //   Address savedAdress = this.saveAddress();
        User savedUser1 = this.saveUser(userAnonymous);
        User savedUser2 = this.saveUser(userCustomer);
        User savedUser3 = this.saveUser(userAdmin);

        System.out.println(savedUser1);
        System.out.println(savedUser2);
        System.out.println(savedUser3);


    }
}
