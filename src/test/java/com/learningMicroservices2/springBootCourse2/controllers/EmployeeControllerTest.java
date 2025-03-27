package com.learningMicroservices2.springBootCourse2.controllers;

import com.learningMicroservices2.springBootCourse2.entities.Employee;
import com.learningMicroservices2.springBootCourse2.services.IEmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IEmployeeService IEmployeeService;

    private Employee employee;

    @BeforeEach
    void setUp() {
         employee = new Employee(102L,
                    "Salvador102",
                    "Chumbe",
                    24,
                    "salv@gmail.com",
                    "Backend Developer",
                    true,
                    "I'm ready for this");
    }
/*
    @Test
    public void createEmployee() throws Exception{
        Employee employeePayload = new Employee(102L,
                "Salvador102",
                "Chumbe",
                24,
                "salv@gmail.com",
                "Backend Developer",
                true,
                "I'm ready for this");
        Mockito.when(employeeService.saveEmployee(employeePayload)).thenReturn(employee);
        mockMvc.perform(post("/create").contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(employeePayload))).andExpect(status().isOk());
    }


 */
}