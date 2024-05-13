
@Data
public class Employee {
    private int empId;
    private String name;

    @Override
    public boolean equals(Object obj) { // IMP: remember signature 
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Employee employee = (Employee) obj;
        return this.empId == employee.empId 
                && this.name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(empId);
        result = 31 * result + name.hashCode();
        // Or can use Utility class Objects.hashCode(Object obj) 
        // Objects.hashCode(empId) and Objects.hashCode(name) etc 
        return result;
    }
}
