package com.battle.net.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.battle.net.dao.Calculation;

@Controller
public class FuelCalcController {
	
	@RequestMapping("/fuelcalc")
	public String showfuelCalc(){
		return "fuelcalc";
	}
	
	@RequestMapping("/calculate")
	public String calcFuel(Model model, Calculation calculation){	
		try {
		model.addAttribute("distance", calculation.getDistance());
		model.addAttribute("fuel", calculation.getLitersFuel());
		model.addAttribute("calculate", calculation.getSum());
		} catch (NullPointerException e) {
            System.out.print("Caught the NullPointerException");
		}
		return "fuelcalc";
	}
}
