package pl.adcom.thymeleafhelloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.adcom.thymeleafhelloworld.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class CarController {

    private List<Car> listaAut;

    public CarController(){
        Car car = new Car("BMW", "i8");
        Car car1 = new Car("Fiat", "126p");
        Car car2 = new Car("Polonez", "Caro");
        Car car3 = new Car("Hyundai", "i30");
//        listaAut = Arrays.asList(car,car1,car2,car3);
        listaAut = new ArrayList<>();
        listaAut.add(car);
        listaAut.add(car1);
        listaAut.add(car2);
        listaAut.add(car3);
    }

    @GetMapping("/car")
    public String getCar(Model model){
        model.addAttribute("auta", listaAut);
        model.addAttribute("newauto", new Car());
        return "car";
    }

    @PostMapping("/add-car")
    public String addCar(@ModelAttribute Car car){
        listaAut.add(car);
        return "redirect:/car";
    }

}
