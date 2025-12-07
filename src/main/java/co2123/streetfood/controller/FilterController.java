package co2123.streetfood.controller;

import co2123.streetfood.StreetfoodApplication;
import co2123.streetfood.model.Dish;
import co2123.streetfood.model.Vendor;
import co2123.streetfood.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FilterController {

    @Autowired
    private VendorRepository vendorRepository;
//    public List<Vendor> method1(String search){
//        List<Vendor> vendors = new ArrayList<Vendor>();
//        for(Vendor a : StreetfoodApplication.vendorList){
//            if(a.getName().contains(search)){
//                vendors.add(a);
//            }
//        }
//        return vendors;
//    }
    @RequestMapping("/filterVendorByName")
    public String filterVendorByName(@RequestParam String query, Model model) {

        List<Vendor> vendors;

        if (query == null || query.trim().isEmpty()) {
            vendors = (List<Vendor>) vendorRepository.findAll();
        } else {
            vendors = vendorRepository.findByNameContainingIgnoreCase(query.trim());
        }

        model.addAttribute("vendors", vendors);
        return "admin";
    }

    @GetMapping("/search1")
    public String search1(@RequestParam String vendor, Model model) {
//        List<Vendor> list = method1(vendor);
//        if(list.isEmpty()){
//            model.addAttribute("vendors", StreetfoodApplication.vendorList);
//        } else {
//            model.addAttribute("vendors", list);
//        }
//        return "vendors";
        List<Vendor> list;

        if (vendor == null || vendor.trim().isEmpty()) {
            list = (List<Vendor>) vendorRepository.findAll();
        } else {

            list = vendorRepository.findByNameContainingIgnoreCase(vendor.trim());
        }

        model.addAttribute("vendors", list);
        return "admin";
    }

//    public List<Vendor> method2(String search){
//        List<Vendor> vendors = new ArrayList<>();
//        for(Vendor a : StreetfoodApplication.vendorList){
//            for(Dish d : a.getDishes()){
//                if(d.getName().contains(search) && !vendors.contains(a)){
//                    vendors.add(a);
//
//                }
//            }
//        }
//        return vendors;
//    }

    @RequestMapping("/filterVendorByDish")
    public String filterVendorByDish(@RequestParam String query, Model model) {

        List<Vendor> vendors;

        if (query == null || query.trim().isEmpty()) {
            vendors = (List<Vendor>) vendorRepository.findAll();
        } else {
            // finds vendors where ANY dish name contains query
            vendors = vendorRepository.findByDishesNameContainingIgnoreCase(query.trim());
        }

        model.addAttribute("vendors", vendors);
        return "admin";
    }

    @GetMapping("/search2")
    public String search2(@RequestParam String dish, Model model) {
//        List<Vendor> list = method2(dish);
//        if(list.isEmpty()){
//            model.addAttribute("vendors", StreetfoodApplication.vendorList);
//        } else {
//            model.addAttribute("vendors", list);
//        }
//        return "vendors";
        List<Vendor> list;

        if (dish == null || dish.trim().isEmpty()) {
            list = (List<Vendor>) vendorRepository.findAll();
        } else {
            // use repository method instead of method2()
            list = vendorRepository.findByDishesNameContainingIgnoreCase(dish.trim());
        }

        // Again, if empty -> user sees an empty list (correct behaviour)
        model.addAttribute("vendors", list);
        return "admin";
    }

}
