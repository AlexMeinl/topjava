package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.MealWithExceed;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.slf4j.LoggerFactory.getLogger;


/**
 * User: gkislin
 * Date: 19.08.2014
 */
public class UserServlet extends HttpServlet {
    private static final Logger LOG = getLogger(UserServlet.class);

    public List<MealWithExceed> listMeals = MealsUtil.getMeals()
            .stream()
            .map((m) -> new MealWithExceed(
                    m.getDateTime(),
                    m.getDescription(),
                    m.getCalories(),
                    true)).collect(Collectors.toList());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug("redirect to users");
        request.setAttribute("listMeals", listMeals);
        request.getRequestDispatcher("mealsList.jsp").forward(request, response);
       //response.sendRedirect("users.jsp");
    }

}
