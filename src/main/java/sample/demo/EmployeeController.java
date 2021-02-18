package sample.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository){
        this.repository=repository;
    }

    @GetMapping("/employees")
    List<Employee> all(){
        return repository.findAll();
    }

    @GetMapping("/employees/{id}")
    Employee one(@PathVariable Long id){
        return repository.findById(id).orElseThrow(()->new EmployeeNotFounException(id));
    }

    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmp){
        return repository.save(newEmp);
    }

    @PutMapping("/employees/{id}")
    Employee put(@RequestBody Employee replaceEmployee, @PathVariable Long id){
        return repository.findById(id).map(employee -> {
            employee.setName(replaceEmployee.getName());
            employee.setSurname(replaceEmployee.getSurname());
            //another possible option
//            employee =replaceEmployee;
//            employee.setId(id);
            return repository.save(employee);
        }).orElseGet(()->{replaceEmployee.setId(id); return repository.save(replaceEmployee);});
        //orElseGet(()->new EmployeeNotFoundException(id)); - returns "Cold not find employee {id}
    }

    @DeleteMapping("/employees/{id}")
    void del(@PathVariable Long id){
        repository.deleteById(id);
    }
}
