package com.imtiaz.foodsapp.view.detail;

import com.imtiaz.foodsapp.model.Meals;

public interface DetailView {
    //TODO #4 Add void method  for showLoading, hideLoading, setMeal, onErrorLoading;

    void showLoading();
    void hideLoading();
    void setMeal(Meals.Meal meal);
    void onErrorLoading(String message);
}
