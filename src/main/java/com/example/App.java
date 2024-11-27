package com.example;



import java.util.ArrayList;
import java.util.List;

import com.example.domain.Ingredient;
import com.example.domain.Pizza;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
        Ingredient ingredient = Ingredient.create("Tomate", 1.2D);

        ingredient.update("Tomate", 1.3D);

        ingredient.getId();
        ingredient.getName();
        ingredient.getCost();

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient);
        ingredients.add(ingredient);
        Pizza pizza = Pizza.create("Carbonara", "Pizza rica", "imagen", ingredients);

        System.out.println(pizza.getIngredients().size());


        System.out.println(ingredient.getName());
        
    }
}

