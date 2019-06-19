package com.imtiaz.foodsapp.view.home;

import com.imtiaz.foodsapp.model.Categories;
import com.imtiaz.foodsapp.model.Meals;

import java.util.List;

public interface HomeView {
    void showLoading();
    void hideLoading();
    void setMeal(List<Meals.Meal> meal);
    void setCategory(List<Categories.Category> category);
    void onErrorLoading(String message);
}
