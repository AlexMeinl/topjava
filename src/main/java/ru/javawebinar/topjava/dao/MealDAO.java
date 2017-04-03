package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealWithExceed;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.List;
import java.util.stream.Collectors;

public class MealDAO {

    public List<MealWithExceed> listMeals = MealsUtil.getMeals()
            .stream()
            .map((m) -> new MealWithExceed(
                    m.getDateTime(),
                    m.getDescription(),
                    m.getCalories(),
                    true)).collect(Collectors.toList());

    public void addMeal(MealWithExceed mealWithExceed)
    {
        listMeals.add(mealWithExceed);
    }

    public void deleteMeal(Integer id)
    {
        MealWithExceed mealWithExceed = listMeals.stream().filter((m) -> m.getId().equals(id)).findFirst().get();
        listMeals.remove(mealWithExceed);
    }

    public List<MealWithExceed> getListMeals() {
        return listMeals;
    }

    public void updateMeal(MealWithExceed mealWithExceed)
    {
        listMeals.add(mealWithExceed);
    }

    public MealWithExceed getMealById(Integer id)
    {
        return listMeals.stream().filter((m) -> m.getId().equals(id)).findFirst().get();
    }
}
