package com.example.domains.entities;

public enum RatingEnum {
	ParentalGuidanceSuggested ("PG"),
	ParentsStronglyCautioned ("PG-13"),
	Restricted ("R"),
	AdultsOnly ("NC-17");

    private final String name;       

    private RatingEnum(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
       return this.name;
    }
}
