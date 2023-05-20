package com.example.model.flower_HW_1_2;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * @author Nadia  Filatova
 * @since 5/13/23
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Flower {
    @XmlElement(name = "plant")
    private List<Plant> plants = new ArrayList<>();

    public Flower(List<Plant> plants) {
        this.plants = plants;
    }

    public Flower() {
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Flower.class.getSimpleName()
                + "[", "]").add("plants=" + plants).toString();
    }
}
