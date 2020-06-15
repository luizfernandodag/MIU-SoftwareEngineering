package edu.miu.cs.cs425.project.miucarrental.controller;
import edu.miu.cs.cs425.project.miucarrental.model.CarStatus;
import edu.miu.cs.cs425.project.miucarrental.service.CarStatusService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/carStatus")
public class CarStatusController {
    @Autowired
    private CarStatusService carStatusService;


    @GetMapping("/list")

    public String getAllCarStatus(Model model){
        List<CarStatus> carStatuses = carStatusService.findAll();
        model.addAttribute("carStatuses", carStatuses);
        return "carStatus/carStatusList";
    }

    @GetMapping("/register")
    public String employeeForm(Model model){

        model.addAttribute("carStatuses", new CarStatus());
        return "carStatus/newCarStatus";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("carStatuses") CarStatus carStatuses){
        carStatusService.save(carStatuses);
        return "redirect:/carStatus/list";
    }

    @GetMapping("/update")
    public String showFormForUpdate(@RequestParam("statusId") Long id, Model theModel) {


        CarStatus theEmployee = carStatusService.findById(id);


        theModel.addAttribute("carStatuses", theEmployee);


        return "carStatus/newCarStatus";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("statusId") Long id) {

        // delete the employee
        carStatusService.deleteById(id);

        // redirect to /employees/list
        return "redirect:/carStatus/list";

    }
}


