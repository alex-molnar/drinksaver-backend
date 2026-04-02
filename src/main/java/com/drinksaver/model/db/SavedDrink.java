package com.drinksaver.model.db;

import com.drinksaver.model.dto.Drink;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "saved_drinks")
@NoArgsConstructor
@Getter
@Setter
public class SavedDrink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;
    private String date;
    private Integer alcoholTypeId;
    private Integer alcoholVolumeId;
    private String comments;

    public SavedDrink(Integer userID, String date, Integer alcoholTypeId, Integer alcoholVolumeId, String comments) {
        this.userId = userID;
        this.date = date;
        this.alcoholTypeId = alcoholTypeId;
        this.alcoholVolumeId = alcoholVolumeId;
        this.comments = comments;
    }

    public static SavedDrink of(Drink drink) {
        return new SavedDrink(
                drink.userId(),
                drink.date(),
                drink.alcoholTypeId(),
                drink.alcoholVolumeId(),
                drink.comments()
        );
    }
}
