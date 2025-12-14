package com.pearl.novdev.collection;

import java.util.Objects;

public class TreeSetStudent  implements Comparable<TreeSetStudent> {
    String id;
    String name;

    TreeSetStudent(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Sort by name
    @Override
    public int compareTo(TreeSetStudent other) {
        return this.name.compareToIgnoreCase(other.name);
    }

    // Needed for equality in Set
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeSetStudent)) return false;
        TreeSetStudent s = (TreeSetStudent) o;
        return id.equals(s.id);
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

