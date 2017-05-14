package ru.javawebinar.topjava.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.javawebinar.topjava.AuthorizedUser;
import ru.javawebinar.topjava.service.MealService;

@Controller
@RequestMapping(value = "/meals")
public class MealController {

    private final MealService service;

    @Autowired
    public MealController(MealService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String users(Model model) {
        model.addAttribute("meals", service.getAll(AuthorizedUser.id()));
        return "meals";
    }

    @RequestMapping(value = "/update")
    public String update(@RequestParam("id") Integer id)
    {
        int userId = AuthorizedUser.id();
        service.update(service.get(id, userId), userId);
       return "redirect:meals";
    }
}
