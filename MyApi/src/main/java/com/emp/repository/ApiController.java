package com.emp.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emp.entities.Employee;


@RestController
public class ApiController {
	
	@Autowired
	private EmpRepository emp;

	@GetMapping("/allemps")
	public java.util.List<Employee> getAll(){
		return emp.findAll();
	}

//creating employee
	@PostMapping(value = "/newemp")
	   public String saveEmp(@RequestBody Employee a) {
		 emp.save(a);
		  return "Employee Added ";
	}
	
	
//update all columns
	@PutMapping(value = "/updateAll/{id}")
	public String updateEmp(@PathVariable long id,@RequestBody Employee b) {
		Employee X = emp.findById(id).get();
		X.setEmpMail(b.getEmpMail());
		X.setEmpName(b.getEmpName()); 
		emp.save(X);
		return"Data Updated..";
		
	}
	
//update empName
		@PutMapping(value = "/updateName/{id}")
		public String updatName(@PathVariable long id, @RequestBody Employee c) {
			Employee Y = emp.findById(id).get();
			Y.setEmpName(c.getEmpName());
			emp.save(Y);
			return "Employee Updated";
			
		}
	
//update empMail
	@PutMapping(value = "/updateMail/{id}")
	public String updateMail(@PathVariable long id , @RequestBody Employee d) {
		Employee Z = emp.findById(id).get();
		Z.setEmpMail(d.getEmpMail());
		emp.save(Z);
		return "Employee Mail  updated";
	}
	
//update empPh
	@PutMapping(value = "/updatePhone/{id}")
	public String updatePhone(@PathVariable long id, @RequestBody Employee e) {
		Employee P = emp.findById(id).get();
		P.setEmpPh(e.getEmpPh());
		emp.save(P);
		return "Employee PhoneNumber updated";
	}
	
//delete employee
	@DeleteMapping(value = "/deleteEmp/{id}")
	public String deleteEmp(@PathVariable long id) {
		Employee A = emp.findById(id).get();
		emp.delete(A);
		return "Employee deleted with id: "+id;
	}
	
	

}
