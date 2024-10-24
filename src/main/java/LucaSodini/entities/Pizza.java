package LucaSodini.entities;


import lombok.*;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pizza implements MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private int calories;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Topping> toppings = new ArrayList<>();

    public void addTopping(Topping topping) {
        toppings.add(topping);
        this.price += topping.getPrice();
        this.calories += topping.getCalories();
    }
}
