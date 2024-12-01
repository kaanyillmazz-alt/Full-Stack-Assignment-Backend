package com.fullstackassignment.project.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Color {
    YELLOW("yellow"),
    ROSE("rose"),
    WHITE("white");

    private final String color;

    @Override
    public String toString() {
        return this.color;
    }

    @JsonValue
    public String getColor() {
        return color;
    }

    @JsonCreator
    public static Color fromString(String color) {
        for (Color c : Color.values()) {
            if (c.color.equalsIgnoreCase(color)) {
                return c;
            }
        }
        throw new IllegalArgumentException("Unknown color: " + color);
    }
}