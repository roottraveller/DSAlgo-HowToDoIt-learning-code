package org.learning.composite;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Developer extends Employee implements PartTime {
    private List<String> techStack;


    public Developer(String id, String name, List<String> techStack) {
        super(id, name);
        this.techStack = techStack;
    }
}

