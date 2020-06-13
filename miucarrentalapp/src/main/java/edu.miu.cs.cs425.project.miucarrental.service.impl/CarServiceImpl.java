    package edu.miu.cs.cs425.project.miucarrental.service.impl;

    import edu.miu.cs.cs425.project.miucarrental.model.Car;
    import edu.miu.cs.cs425.project.miucarrental.repository.CarRepository;
    import edu.miu.cs.cs425.project.miucarrental.service.CarService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.List;

    @Service
    public class CarServiceImpl implements CarService {

        @Autowired
        private CarRepository carRepository;

        @Override
        public Car save(Car car) {

            return carRepository.save(car);
        }

        @Override
        public List<Car> findAll() {

            return (List<Car>) carRepository.findAll();
        }

        @Override
        public void deleteById(Long id) {

            carRepository.deleteById(id);
        }

        @Override
        public Car findById(Long id) {

            return carRepository.findById(id).get();
        }
    }
