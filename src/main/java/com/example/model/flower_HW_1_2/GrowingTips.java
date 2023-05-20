package com.example.model.flower_HW_1_2;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.StringJoiner;

/**
 * @author Nadia  Filatova
 * @since 5/13/23
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class GrowingTips {
    private Integer temperature;
    private Boolean lovesLight;
    private Integer watering;

    public GrowingTips() {
    }

    public GrowingTips(Integer temperature, Boolean lovesLight, Integer watering) {
        this.temperature = temperature;
        this.lovesLight = lovesLight;
        this.watering = watering;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public void setWatering(Integer watering) {
        this.watering = watering;
    }

    public void setLovesLight(Boolean lovesLight) {
        this.lovesLight = lovesLight;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GrowingTips.class.getSimpleName() + "[", "]")
           .add("temperature=" + temperature)
           .add("lovesLight=" + lovesLight)
           .add("watering=" + watering)
           .toString();
    }
}
