import java.lang.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.function.Predicate;

/*
    Predicate<T>
          - public boolean test(T t);
*/
class PredicateExample {
    public static void main(String[] args) {
        testPredicateCombination();
        testPredicateCollection();
    }
    
    private static void testPredicateCollection(){
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");

        Predicate<String> startsWithA = str -> str.startsWith("A");
        List<String> namesStartingWithA = names.stream()
                                               .filter(startsWithA) // Or (it -> it.startWith("A"))
                                               .collect(Collectors.toList());
        System.out.println(namesStartingWithA); // Output: [Alice]
    }
    
    private static void testPredicateCombination(){
        Predicate<String> isNotEmpty = str -> str != null && !str.isEmpty();
        // Test the predicate
        System.out.println(isNotEmpty.test("Hello, World!")); // true
        System.out.println(isNotEmpty.test("")); // false
        System.out.println(isNotEmpty.test(null)); // false
        
        
        Predicate<Integer> isGreaterThanTen = num -> num > 10;
        Predicate<Integer> isEven = num -> num % 2 == 0;
        // Test the predicate
        System.out.println(isGreaterThanTen.test(5));  // Output: false
        System.out.println(isGreaterThanTen.test(15)); // Output: true
        
        // Combine predicates
        Predicate<Integer> isGreaterThanTenAndEven = isGreaterThanTen.and(isEven);
        System.out.println(isGreaterThanTenAndEven.test(8));  // Output: false
        System.out.println(isGreaterThanTenAndEven.test(12)); // Output: true

        // Combine predicates 
        Predicate<Integer> isGreaterThanTenOrEven = isGreaterThanTen.or(isEven);
        System.out.println(isGreaterThanTenOrEven.test(8));  // Output: true
        System.out.println(isGreaterThanTenOrEven.test(12)); // Output: true

        // Negate predicate
        Predicate<Integer> isNotGreaterThanTen = isGreaterThanTen.negate();
        System.out.println(isNotGreaterThanTen.test(8));  // Output: true
        System.out.println(isNotGreaterThanTen.test(12)); // Output: false 
    }
}
