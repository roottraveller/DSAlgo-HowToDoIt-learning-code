package org.learning.composite;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class Employee {
    protected String id;
    protected String name;


    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
