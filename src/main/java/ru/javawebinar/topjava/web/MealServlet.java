package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.dao.MealDAO;
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

public class MealServlet extends HttpServlet {

    private static final Logger LOG = getLogger(MealServlet.class);

    private MealDAO mealDAO;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug("redirect to meals");

        String action = request.getParameter("action");
        String goTo = "";

        if (action.equalsIgnoreCase("update"))
        {
            int mealId = Integer.parseInt(request.getParameter("id"));
            MealWithExceed mealWithExceed = mealDAO.getMealById(mealId);
            goTo = "meal.jsp";
            request.setAttribute("meal", mealWithExceed);
        }
        else
        {
            if (action.equalsIgnoreCase("delete"))
            {
                int mealId = Integer.parseInt(request.getParameter("id"));
                mealDAO.deleteMeal(mealId);
                goTo = "mealsList.jsp";
                request.setAttribute("mealsList", mealDAO.getListMeals());
            }
            else
                if (action.equalsIgnoreCase("mealsList"))
                {
                    goTo = "mealsList.jsp";
                    request.setAttribute("mealsList", mealDAO.getListMeals());
                }
                else
                    goTo = "mealsList.jsp";
        }

        request.getRequestDispatcher(goTo).forward(request, response);
        //response.sendRedirect("mealsList.jsp");
    }



}
