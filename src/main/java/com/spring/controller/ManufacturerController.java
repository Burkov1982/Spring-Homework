package com.spring.controller;

import com.spring.dao.model.Manufacturer;
import com.spring.dto.ManufacturerDTO;
import com.spring.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(path = "/manufacturers")
public class ManufacturerController {

    private final ManufacturerService service;

    @Autowired
    public ManufacturerController(ManufacturerService service) {
        this.service = service;
    }

    //Get logic
    @GetMapping(path = "/findAllManufacturers")
    public ModelAndView showAllManufacturersPage(ModelAndView model) {
        List<ManufacturerDTO> manufacturers = service.getAll();
        model.addObject("manufacturers", manufacturers);
        model.setViewName("findAllManufacturers");
        return model;
    }

    @GetMapping(path = "/findManufacturerById")
    public ModelAndView showManufacturerById(@RequestParam(name = "id") UUID uuid, ModelAndView model) {
        ManufacturerDTO manufacturer = service.findById(uuid);
        model.addObject("manufacturer", manufacturer);
        model.setViewName("findManufacturerById");
        return model;
    }

    // Add, delete, update logic
    @GetMapping(path = "/form/update")
    public String showUpdateManufacturerPage(@RequestParam(name = "id")UUID uuid, Model model) {
         ManufacturerDTO manufacturer = service.findById(uuid);
         model.addAttribute("manufacturer", manufacturer);
         return "updateManufacturerForm";
    }

    @PostMapping(path = "/updateManufacturer")
    public RedirectView update(@ModelAttribute("manufacturer") Manufacturer manufacturer) {
        service.saveOrUpdate(manufacturer);
        return new RedirectView("/manufacturers/findAllManufacturers");
    }

    @GetMapping(path = "/form/add")
    public String showAddFormManufacturerPage(Model model) {
        return "addManufacturerForm";
    }

    @PostMapping(path = "/addManufacturer")
    public RedirectView add(@ModelAttribute("manufacturer") Manufacturer manufacturer) {
        service.saveOrUpdate(manufacturer);
        return new RedirectView("/manufacturers/findAllManufacturers");
    }

    @GetMapping(path = "/delete")
    public RedirectView delete(@RequestParam("id") UUID uuid) {
        ManufacturerDTO manufacturerDTO = service.findById(uuid);
        service.delete(manufacturerDTO);
        return new RedirectView("/manufacturers/findAllManufacturers");
    }

    @ModelAttribute(name = "manufacturer")
    public Manufacturer defaultManufacturer() {
        return new Manufacturer();
    }
}
