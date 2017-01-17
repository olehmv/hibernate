package com.shop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public enum Status {
	AVAILABLE("AVAILABLE"),BOUGCH("BOUGCH"),SOLD("SOLD");
	private String value;

    Status(String value) { this.value = value; }    

    public String getValue() { return value; }

    public static Status parse(String id) {
        Status right = null; // Default
        for (Status item : Status.values()) {
            if (item.getValue()==id) {
                right = item;
                break;
            }
        }
        return right;
    }

};


