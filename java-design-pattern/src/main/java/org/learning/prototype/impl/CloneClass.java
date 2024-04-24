package org.learning.prototype.impl;

import lombok.Data;
import org.learning.prototype.PrototypeClassDemo;

/*
 * The Prototype Pattern revolves around generating new objects by duplicating existing ones.
 * By cloning (shallow copy by default) existing objects rather than creating them from scratch,
 * this pattern enables efficient and rapid object creation. The original object, serving as
 * the blueprint for duplication, is referred to as the prototype.
 * Example:
 * clone() method within java.lang.Object
 */


@Data
public class CloneClass implements PrototypeClassDemo {
    private final String name;
    // Other fields can be added here

    public CloneClass(String name) {
        this.name = name;
    }

    // Step 2: Override the clone method to create a shallow copy
    @Override
    public PrototypeClassDemo clone() {
        // Create a shallow copy of the current object
        return new CloneClass(this.name);
    }
}
