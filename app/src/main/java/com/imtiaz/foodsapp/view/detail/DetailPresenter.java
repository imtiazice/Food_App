package com.imtiaz.foodsapp.view.detail;

import android.support.annotation.NonNull;

import com.imtiaz.foodsapp.Utils;
import com.imtiaz.foodsapp.model.Meals;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPresenter {
    private DetailView view;

    public DetailPresenter(DetailView view) {
        this.view = view;
    }

    void getMealById(String mealName) {
        
        //TODO #5 Call the void show loading before starting to make a request to the server
        view.showLoading();



        //TODO #6 Make a request to the server (Don't forget to hide loading when the response is received)

        Utils.getApi().getMealByName(mealName)
                .enqueue(new Callback<Meals>() {
                    @Override
                    public void onResponse(@NonNull Call<Meals> call, @NonNull Response<Meals> response) {
                        view.hideLoading();
                        if (response.isSuccessful() && response.body() != null){
                            view.setMeal(response.body().getMeals().get(0));
                        } else {
                            view.onErrorLoading(response.message());
                        }

                    }

                    @Override
                    public void onFailure(@NonNull Call<Meals> call, @NonNull Throwable t) {
                        view.hideLoading();
                        view.onErrorLoading(t.getLocalizedMessage());
                    }
                });


        //TODO #7 Set response (meal)
    }
}
