package com.example.model.flower_HW_1_2;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;

/**
 * @author Nadia  Filatova
 * @since 5/13/23
 */
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public final class FlowerConstants {
    private FlowerConstants() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static final String PLANT = "plant";
    public static final String NAME = "name";
    public static final String SOIL = "soil";
    public static final String ORIGIN = "origin";

    public static final String VISUAL_PARAMETERS = "visualParameters";
    public static final String STEM_COLOR = "stemColor";
    public static final String LEAF_COLOR = "leafColor";
    public static final String PLANT_SIZE = "size";

    public static final String GROWING_TIPS = "growingTips";
    public static final String TEMPERATURE = "temperature";
    public static final String LOVES_LIGHT = "lovesLight";
    public static final String WATERING = "watering";

    public static final String MULTIPLYING_TYPE = "multiplyingType";
}
