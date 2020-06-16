package edu.miu.cs.cs425.project.miucarrental.util;

import edu.miu.cs.cs425.project.miucarrental.model.Car;

import java.util.ArrayList;
import java.util.List;

public class GeneratorUtils {

    public static List<Car> generateCars() {
        return new ArrayList<Car>() {{
            add(new Car("Audi",
                    "Audi",
                    "123-456",
                    16.0,
                    "Audi A3",
                    "White",
                    "https://cars.usnews.com/static/images/Auto/izmo/i159547119/2020_audi_a3_sedan_angularfront.jpg",
                    "Available",
                    ""));
            add(new Car("Audi",
                    "Audi",
                    "123-456",
                    16.0,
                    "2019 Audi Allroad",
                    "White",
                    "https://cars.usnews.com/static/images/Auto/izmo/i108385758/2019_audi_a4_allroad_angularfront.jpg",
                    "Available",
                    ""));
            add(new Car("Audi",
                    "Audi",
                    "123-456",
                    16.0,
                    "2019 Audi e-tron",
                    "White",
                    "https://cars.usnews.com/static/images/Auto/izmo/i159613991/2019_audi_e_tron_angularfront.jpg",
                    "Available",
                    ""));

            add(new Car("Chevrolet",
                    "Chevrolet",
                    "123-456",
                    16.0,
                    "2020 Chevrolet Colorado",
                    "White",
                    "https://cars.usnews.com/static/images/Auto/izmo/i158864407/2020_chevrolet_colorado_angularfront.jpg",
                    "Available",
                    ""));
            add(new Car("Chevrolet",
                    "Chevrolet",
                    "123-456",
                    16.0,
                    "2020 Chevrolet Impala",
                    "White",
                    "https://cars.usnews.com/static/images/Auto/izmo/i159613936/2020_chevrolet_impala_angularfront.jpg",
                    "Available",
                    ""));
            add(new Car("Chevrolet",
                    "Chevrolet",
                    "123-456",
                    16.0,
                    "2020 Chevrolet Equinox",
                    "White",
                    "https://cars.usnews.com/static/images/Auto/custom/14075/2020_Chevrolet_Equinox_1.jpg",
                    "Available",
                    ""));
        }};
    }


}
