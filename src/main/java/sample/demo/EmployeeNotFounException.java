package sample.demo;

public class EmployeeNotFounException extends RuntimeException {
    public EmployeeNotFounException(Long id) {
        super("Could not find employee "+id);
    }
}
