package edu.miu.cs.cs425.project.miucarrental.controller;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import edu.miu.cs.cs425.project.miucarrental.model.Car;
import edu.miu.cs.cs425.project.miucarrental.model.CarStatus;
import edu.miu.cs.cs425.project.miucarrental.repository.CarRepository;
import edu.miu.cs.cs425.project.miucarrental.service.CarService;
import edu.miu.cs.cs425.project.miucarrental.service.CarStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    CarStatusService carStatusService;

    @Autowired
    CarService carService;

    @Autowired
    CarRepository carRepository;

    @GetMapping(value = {"/dashboard/car/list", "/miucarrental/dashboard/car/list"})
    public String getAllCars(Model model, Principal principal) {
        // System.out.println("CURRENT USER: " + principal.getName());
        model.addAttribute("cars", carService.findAll());
        return "/car/list";
    }

    @GetMapping(value = {"/dashboard/car/new", "/miucarrental/dashboard/car/new"})
    public String carForm(Model model) {
        model.addAttribute("car", new Car());
        model.addAttribute("status", carStatusService.findAll());
        return "/car/new";
    }

    @GetMapping(value = {"/dashboard/car/edit/{carId}", "/miucarrental/dashboard/car/edit/{carId}"})
    public String showFormForUpdate(@PathVariable Long carId, Model theModel) {
        // get the car from the service
        Car theCar = carService.findById(carId);
        // set Car as a model attribute to pre-populate the form
        theModel.addAttribute("car", theCar);
        // theModel.addAttribute("status", carStatusService.findAll());
        // send over to our form
        return "car/edit";
    }

    @PostMapping(value = {"/dashboard/car/new", "/miucarrental/dashboard/car/new"})
    public String save(@Valid @ModelAttribute("car") Car car,
                       BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            System.out.println(result.getAllErrors().toString());
            model.addAttribute("status", carStatusService.findAll());
            return "car/new";
        }
        car = carService.save(car);
        return "redirect:/dashboard/car/list";
    }

    @PostMapping(value = {"/miucarrental/dashboard/car/edit", "/dashboard/car/edit"})
    public String update(@Valid @ModelAttribute("car") Car car,
                         BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "car/edit";
        }
        car = carService.save(car);
        return "redirect:/dashboard/car/list";
    }

    @GetMapping(value = "/available/list")
    public ModelAndView availableCars(Model model) {

        CarStatus carStatus = carStatusService.findById(1L);

        List<Car> availableCars = carRepository.findByCarStatusIs(carStatus);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("availableCars", availableCars);
        modelAndView.setViewName("car/edit");

        List<String> carImages = recreateImages(availableCars);
        modelAndView.addObject("carImages", carImages);

        return modelAndView;
    }


    @GetMapping(value = {"/dashboard/car/delete/{carId}", "/miucarrental/dashboard/car/delete/{carId}"})
    public String delete(@PathVariable Long carId) {
        // delete the Car
        carService.deleteById(carId);
        // redirect to /car/list
        return "redirect:/dashboard/car/list";

    }


    public static List<String> recreateImages(List<Car> cars) {
        List<String> carImages = new ArrayList<>();

        try {
            for (Car c : cars) {
                byte[] encodeBase64 = Base64.encode(c.getCarPic()).getBytes();
                String base64Encoded = new String(encodeBase64, "UTF-8");
                carImages.add(base64Encoded);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return carImages;
    }

    @InitBinder
    protected void initBinder(HttpServletRequest request,
                              ServletRequestDataBinder binder) throws ServletException {
        binder.registerCustomEditor(byte[].class,
                new ByteArrayMultipartFileEditor());
    }
}

