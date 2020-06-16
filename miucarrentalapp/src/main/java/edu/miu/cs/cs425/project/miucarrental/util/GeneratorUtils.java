package edu.miu.cs.cs425.project.miucarrental.util;

import edu.miu.cs.cs425.project.miucarrental.model.*;

import java.util.ArrayList;
import java.util.List;

public class GeneratorUtils {

    public static List<Car> generateCars() {
        return new ArrayList<Car>() {{
            add(new Car("Audi",
                    "Audi",
                    "000-000",
                    17.0,
                    "Audi A3",
                    "White",
                    "https://cars.usnews.com/static/images/Auto/izmo/i159547119/2020_audi_a3_sedan_angularfront.jpg",
                    CarStatusEnum.Available,
                    "",CarType.Economy,
                    DistanceMile.TWENTY,
                    PaymentOption.PickUp));
            add(new Car("Audi",
                    "Audi",
                    "111-111",
                    22.0,
                    "2019 Audi Allroad",
                    "White",
                    "https://cars.usnews.com/static/images/Auto/izmo/i108385758/2019_audi_a4_allroad_angularfront.jpg",
                    CarStatusEnum.Available,
                    "",
                    CarType.Economy,
                    DistanceMile.TWENTY,
                    PaymentOption.PickUp));
            add(new Car("Audi",
                    "Audi",
                    "222-222",
                    12.0,
                    "2019 Audi e-tron",
                    "White",
                    "https://cars.usnews.com/static/images/Auto/izmo/i159613991/2019_audi_e_tron_angularfront.jpg",
                    CarStatusEnum.Available,
                    "",
                    CarType.Intermediate,
                    DistanceMile.TWENTY,
                    PaymentOption.PickUp));

            add(new Car("Chevrolet",
                    "Chevrolet",
                    "333-333",
                    15.0,
                    "2020 Chevrolet Colorado",
                    "White",
                    "https://cars.usnews.com/static/images/Auto/izmo/i158864407/2020_chevrolet_colorado_angularfront.jpg",
                    CarStatusEnum.Available,
                    "",
                    CarType.Economy,
                    DistanceMile.FIFTY,
                    PaymentOption.PickUp));

            add(new Car("Chevrolet",
                    "Chevrolet",
                    "444-444",
                    24.0,
                    "2020 Chevrolet Impala",
                    "White",
                    "https://cars.usnews.com/static/images/Auto/izmo/i159613936/2020_chevrolet_impala_angularfront.jpg",
                    CarStatusEnum.Available,
                    "",
                    CarType.Standard,
                    DistanceMile.THIRTY,
                    PaymentOption.PickUp));

            add(new Car("Chevrolet",
                    "Chevrolet",
                    "555-555",
                    26.0,
                    "2020 Chevrolet Equinox",
                    "White",
                    "https://cars.usnews.com/static/images/Auto/custom/14075/2020_Chevrolet_Equinox_1.jpg",
                    CarStatusEnum.Available,
                    "",
                    CarType.FullSize,
                    DistanceMile.FIFTY,
                    PaymentOption.PickUp));
        }};
    }


    public static List<User> generateUsers() {

        return new ArrayList<User>() {{
            add(new User("USER",
                    "ANONYMOUS",
                    "ANONYMOUS",
                    "123456789",
                    "anonymous@miucarrent.com",
                    new Address("test street", "Fairfield", "IOWA", "56728"),
                    new Role("ANONYMOUS")));

            add(new User("USER",
                    "CUSTOMER",
                    "CUSTOMER",
                    "123456789",
                    "customer@miucarent.com",
                    new Address("test2 street", "Fairfield", "IOWA", "56728"),
                    new Role("CUSTOMER")));

            add(new User("USER",
                    "ADMIN",
                    "ADMIN",
                    "123456789",
                    "admin@miucarrent.com",
                    new Address("test3 street", "Fairfield", "IOWA", "56728"),
                    new Role("ADMIN")));
        }};
    }


}
