package org.launchcode.techjobs.oo;

import java.util.Objects;

abstract class JobField {

    private final int id;
    private static int nextId = 1;
    private String value;

    // Constructors

    public JobField() {
        this.id = nextId;
        nextId++;
    }

    public JobField(String value) {
        this();
        this.value = value;
    }

    // Getters

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    // Setter

    public void setValue(String value) {
        this.value = value;
    }

    // Methods

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobField jobField = (JobField) o;
        return id == jobField.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

