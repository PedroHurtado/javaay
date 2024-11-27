package com.example.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class Pizza extends EntityBase {

    //constante
    private final double PROFIT = 1.2D;
    
    private String name;
    private String description;
    private String url;
    private Set<Ingredient> ingredients = new HashSet<>();

    //constructor protected para no poder crear instancias
    //sino es por el metodo static interno(create)
    protected Pizza(UUID id, String name,String description,String url){
        super(id);        
        this.name=name;
        this.description = description;
        this.url = url;
    }
    public void addIngredient(Ingredient ingredient){
        ingredients.add(ingredient);
    }
    public void removeIngredient(Ingredient ingredient){
        ingredients.remove(ingredient);
    }
    public void update(String name,String description,String url){        
        this.name=name;
        this.description = description;
        this.url = url;
    }
    //static method
    public static Pizza create(String name,String description,String url,List<Ingredient> ingredients){
        Pizza pizza = new Pizza(UUID.randomUUID(), name, description, url);
        for (Ingredient ingredient : ingredients) {
            pizza.ingredients.add(ingredient);
        }
        return pizza;
    }    
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public String getUrl(){
        return url;
    }
    public List<Ingredient> getIngredients(){
        return ingredients.stream().toList();
    }
    public Double getPrice(){

        //https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html

        return (ingredients.stream()
            .map(i->i.getCost())  //transformando el ingrediente a double
            .reduce(0D, (ac,c)->ac+c)) * PROFIT;
        
        
        /*     
        Double total = 0D;
        for (Ingredient ingredient : ingredients) {
            total+=ingredient.getCost();
        }
        return total * PROFIT;
        */
    }
}