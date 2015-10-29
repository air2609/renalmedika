
package com.ibn.rusyd.renal.medika.controller;

import com.ibn.rusyd.renal.medika.dao.WardDao;
import com.ibn.rusyd.renal.medika.entity.Ward;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author arifullah
 */

@Controller
@RequestMapping("/ward")
public class WardController {
    
    @Autowired
    private WardDao wd;
    
    @RequestMapping("/list")
    private void getAllWard(Model m){
        m.addAttribute("wardList", wd.findAll());
    }
    
    
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    private String showForm(@RequestParam(value = "id", required = false) String id, Model m){
        m.addAttribute("ward", new Ward());
        if(id != null && !id.isEmpty()){
            Ward ward = wd.findOne(id);
            if(ward != null){
                m.addAttribute("ward", wd.findOne(id));
            }
            
        }
        return "/ward/form";
    }
    
    @RequestMapping(value = "/delete")
    private String delete(@RequestParam(value = "id", required = true) String id){
        wd.delete(id);
        return "redirect:list";
    }
    
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    private String processForm(@Valid Ward w , BindingResult errors){
        
        if(errors.hasErrors()){
            return "/ward/form";
        }
   
        wd.save(w);
        
        return "redirect:list";
    }
}
