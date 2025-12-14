package com.pearl.novdev.collection;

import java.util.Objects;

public class SetStudent {

    String id;
    String name;

    SetStudent(String id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SetStudent)) return false;
        SetStudent s = (SetStudent) o;
        return id.equals(s.id); // Only ID is used to check uniqueness
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "[" + id + "] " + name;
    }
}
