package org.learning.composite;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/*
 * The composite pattern allows you to compose objects into tree-like structures to represent part-whole hierarchies.
 * Example:
 * Employees in an Organization, Family members in a Dynasty, Nodes in an XML document, etc.
 *
 *
 * https://javarevisited.blogspot.com/2018/02/composite-design-pattern-in-java-real.html#axzz7YGkYs1WH
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class Manager extends Employee implements FullTime {
    // Step 1: Manager class acts as a composite and can contain a list
    //of Employee objects,which may include both individual Developer
    //and Manager instances (creating a tree-like structure)
    private final List<Employee> directs;


    public Manager(String id, String name, List<Employee> directs) {
        super(id, name);
        this.directs = directs;
    }
}
