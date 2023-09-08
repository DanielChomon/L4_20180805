package com.example.l4_20180805.controller;
mport org.springframework.beans.factory.annotation.Autowired;
import com.example.l4_20180805.entity.Employee;
import com.example.l4_20180805.repository.DepartmentRepository;
import com.example.l4_20180805.repository.EmployeeRepository;
import com.example.l4_20180805.repository.JobRepository;
import com.example.l4_20180805.repository.LocationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    final DepartmentRepository departmentRepository;
    final EmployeeRepository employeeRepository;
    final LocationRepository locationRepository;

    final JobRepository jobRepository;

    public ProductController(ProductRepository productRepository,
                             CategoryRepository categoryRepository,
                             SupplierRepository supplierRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.supplierRepository = supplierRepository;
    }

    @GetMapping(value = {"", "/"})
    public String listaEmpleados(Model model) {
        model.addAttribute("listaEmpleados", employeeRepository.findAll());
        return "employee/list";
    }

    @GetMapping("/new")
    public String nuevoEmpleadoFrm(Model model) {
        model.addAttribute("listaEmpleos",jobRepository.findAll());
        model.addAttribute("listaDepartamentos",departmentRepository.findAll());
        return "employee/newFrm";
    }

    @PostMapping("/save")
    public String guardarEmpleado(Employee employee, RedirectAttributes attr) {
        departmentRepository.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("/edit")
    public String editarTransportista(Model model, @RequestParam("id") int id) {

        Optional<Employee> optProduct = employeeRepository.findById(id);

        if (optProduct.isPresent()) {
            Employee employee = optProduct.get();
            model.addAttribute("listaCategorias",categoryRepository.findAll());
            model.addAttribute("listaTransportistas",supplierRepository.findAll());
            model.addAttribute("product", product);
            return "employee/editFrm";
        } else {
            return "redirect:/employee";
        }
    }

    @GetMapping("/delete")
    public String borrarTransportista(Model model,
                                      @RequestParam("id") int id,
                                      RedirectAttributes attr) {

        Optional<Product> optProduct = productRepository.findById(id);

        if (optProduct.isPresent()) {
            productRepository.deleteById(id);
        }
        return "redirect:/product";

    }

}
