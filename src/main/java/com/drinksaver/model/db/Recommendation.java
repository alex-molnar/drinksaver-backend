package com.drinksaver.model.db;

import com.drinksaver.model.dto.SingleNameResponse;
import jakarta.persistence.*;

@Entity
@Table(name = "recommendations")
public class Recommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;
    private String name;
    private Integer alcoholTypeId;
    private Integer alcoholVolumeId;

    public SingleNameResponse asSingleNameResponse() {
        return new SingleNameResponse(id, name);
    }
}
