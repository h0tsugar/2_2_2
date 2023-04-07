package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

@Controller
public class CarsController {

    private final CarService carService;

    public CarsController(CarService carService) {
        this.carService = carService;
    }
    @GetMapping("/cars")
    public String getCar(Model model, @RequestParam(value = "count", required = false, defaultValue = "0") Integer count) {
        model.addAttribute("cars", carService.getAllCars());
        model.addAttribute("carsCount", carService.capacityCar(count));
        return "cars";
    }

}
