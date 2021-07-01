package com.spring.boot.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.boot.model.EmployeeDetails;
import com.spring.boot.repository.EmployeeRepositoryDao;

@Controller
public class Employee {
	
	@Autowired
	private EmployeeRepositoryDao employeeRepositoryDao;
	
	@RequestMapping("/covid19-Details")
	public String employeeDetails() throws MalformedURLException {

		URL url=new URL("https://www.covid19india.org/");
		try(BufferedReader br=new BufferedReader(new InputStreamReader(url.openStream()))) {
			 Properties systemProps = System.getProperties();
			    systemProps.put("javax.net.ssl.keyStorePassword","passwordForKeystore");
			    systemProps.put("javax.net.ssl.keyStore","pathToKeystore.ks");
			    systemProps.put("javax.net.ssl.trustStore", "pathToTruststore.ts");
			    systemProps.put("javax.net.ssl.trustStorePassword","passwordForTrustStore");
			    System.setProperties(systemProps);
			String data;
			StringBuilder sb=new StringBuilder();
			while((data=br.readLine())!=null){
				sb.append(data);
				sb.append(System.lineSeparator());
			}
		System.out.println(sb);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "home.jsp";
		
	}
	
	
	@RequestMapping("/addEmployee")
	public String addEmployee(EmployeeDetails employeeDetails) {
		employeeRepositoryDao.save(employeeDetails);
		return "home.jsp";
		
	}
	
	@RequestMapping("/getEmployee/{id}")
	@ResponseBody
	public Optional<EmployeeDetails> getEmployee(@PathVariable("id") Long id) {
		return employeeRepositoryDao.findById(id);
		
	}
	

	@RequestMapping("/employee")
	@ResponseBody
	public List<EmployeeDetails> getEmployee(EmployeeDetails employeeDetails) {

		return employeeRepositoryDao.findAll();
		
	}
	
	@PostMapping(path="/saveEmployee",consumes= {"application/xml"})
	public EmployeeDetails saveEmployee(@RequestBody EmployeeDetails employeeDetails) {

		return employeeRepositoryDao.save(employeeDetails);
		
	}
	
	@DeleteMapping(path="/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable("id") Long id) {

		employeeRepositoryDao.deleteById(id);
		return "deleted successfully";
		
	}
	

	@GetMapping("/employee")
	public List<EmployeeDetails> getEmployeeList(EmployeeDetails employeeDetails) {

		return employeeRepositoryDao.findAll();
		
	}
	
	@PutMapping(path="/saveOrUpdateEmployee",consumes= {"application/xml","application/json"})
	public EmployeeDetails saveOrUpdateEmployee(@RequestBody EmployeeDetails employeeDetails) {

		return employeeRepositoryDao.save(employeeDetails);
		
	}

	
}
