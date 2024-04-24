package org.learning.builder;

/*
 * The Builder Pattern serves as a solution for creating complex objects by separating their construction from their
 * representation. By breaking down the creation process into multiple steps, it provides flexibility and clarity in
 * object instantiation.
 * Example:
 * java.lang.StringBuilder
 * java.lang.StringBuffer
 *
 *
 * https://javarevisited.blogspot.com/2012/06/builder-design-pattern-in-java-example.html#axzz7XpEkzHVa
 */

import lombok.Data;

@Data
public class BuilderClassDemo {
    // Step 1: Define immutable fields
    private final String name;
    private final String crush;

    // Step 2: Constructor with Builder as parameter
    public BuilderClassDemo(Builder builder) {
        this.name = builder.name;
        this.crush = builder.crush;
    }

    // Step 3: Define static nested Builder class
    public static class Builder {
        // Step 4: Define fields to match the ones in the main class
        private String name;
        private String crush;

        // Step 5: Builder methods to set properties
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder crush(String crush) {
            this.crush = crush;
            return this;
        }

        // Step 6: Build method to instantiate the main class
        public BuilderClassDemo build() {
            return new BuilderClassDemo(this);
        }
    }
}
