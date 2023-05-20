package com.example.model.flower_HW_1_2;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.StringJoiner;

/**
 * @author Nadia  Filatova
 * @since 5/13/23
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class VisualParameters {
    private Color stemColor;
    private Color leafColor;
    private Integer size;

    public VisualParameters() {
    }

    public VisualParameters(Color stemColor, Color leafColor, Integer size) {
        this.stemColor = stemColor;
        this.leafColor = leafColor;
        this.size = size;
    }
    public void setStemColor(Color stemColor) {
        this.stemColor = stemColor;
    }


    public void setLeafColor(Color leafColor) {
        this.leafColor = leafColor;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", VisualParameters.class.getSimpleName() + "[", "]")
           .add("stemColor='" + stemColor + "'")
           .add("leafColor='" + leafColor + "'")
           .add("size=" + size)
           .toString();
    }
}
