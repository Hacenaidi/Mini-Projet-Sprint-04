package com.hacen.evenements.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hacen.evenements.model.Evenement;
import com.hacen.evenements.model.Type;
import com.hacen.evenements.service.EvenementService;

import jakarta.validation.Valid;

@Controller
public class EvenementController {
	
	@Autowired
	EvenementService evenementService;
	 @RequestMapping("/ListeEvenements")
	public String listeEvenements(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
	{
	Page<Evenement> even = evenementService.getAllEvenementsParPage(page,size);
	modelMap.addAttribute("evenements", even);
	modelMap.addAttribute("pages", new int[even.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	return "listeEvenements";
	}
	 @RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
		 Evenement evenement =  new Evenement();
		 modelMap.addAttribute("evenement",evenement);
		 List<Type> type = evenementService.getAllTypes();
		 modelMap.addAttribute("mode", "new");
		 modelMap.addAttribute("types", type);
		 return "formEvenement";
	}
	@RequestMapping("/saveEvenement")
	public String saveEvenement(@Valid Evenement evenement,
			BindingResult bindingResult,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size",defaultValue = "2") int size)
	{
		int currentPage;
		boolean isNew = false;
		if (bindingResult.hasErrors()) return "formEvenement";
		System.out.println("---------------------------------------------qqqqqqqqqqqqqqqqqqqqqqqqqq-------------------------------------------------");
		System.out.println(evenement);
		if (evenement.getIdEvenement()== null) 
		isNew=true;
		evenementService.saveEvenement(evenement);
		if (isNew) 
		{
		Page<Evenement> prods = evenementService.getAllEvenementsParPage(page, size);
		
		currentPage = prods.getTotalPages()-1;
		}
		else 
		currentPage=page;
		return ("redirect:/ListeEvenements?page="+currentPage+"&size="+size);
		}
	@RequestMapping("/supprimerEvenement")
	public String supprimerEvenement(@RequestParam("id") Long id,
	 ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
		@RequestParam (name="size", defaultValue = "2") int size)
	{
		evenementService.deleteEvenementById(id);
	Page<Evenement> even = evenementService.getAllEvenementsParPage(page,size);
	modelMap.addAttribute("evenements", even);
	modelMap.addAttribute("pages", new int[even.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listeEvenements";
	}

	 @RequestMapping("/modifierEvenement")
	public String editerEvenement(@RequestParam("id") Long id,
	 ModelMap modelMap,
	 @RequestParam (name="page",defaultValue = "0") int page,
		@RequestParam (name="size", defaultValue = "2") int size)
	{
	Evenement e= evenementService.getEvenement(id);
	 List<Type> type = evenementService.getAllTypes();
	modelMap.addAttribute("mode", "edit");
	modelMap.addAttribute("evenement", e);
	modelMap.addAttribute("types", type);
	modelMap.addAttribute("page", page);
	modelMap.addAttribute("size", size);
	return "formEvenement";
	}
	@RequestMapping("/updateEvenement")
	public String updateEvenement(@ModelAttribute("evenement") Evenement
			evenement, @RequestParam("date") String date,
	 ModelMap modelMap) throws ParseException
	{
	//conversion de la date
	 //Date dateCreation = dateformat.parse(String.valueOf(date));

	evenementService.updateEvenement(evenement);
	 List<Evenement> even = evenementService.getAllEvenements();
	 modelMap.addAttribute("evenements", even);
	return "listeEvenements";
	}
	@GetMapping(value = "/")
	public String welcome() {
	 return "index";
	}
	}
