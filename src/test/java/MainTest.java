/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author Xariez
 */
public class MainTest {
    
    public MainTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of doPrint method, of class Main.
     * Should succeed since the Customers ArrayList is valid
     */
    @org.junit.jupiter.api.Test
    public void testDoPrint() {
        System.out.println("doPrint");
        Main instance = new Main();
        
        List<Customer> customers = new ArrayList<Customer>();
        customers.add(new Customer("John", 1000.0, 5.0, 5));
        customers.add(new Customer("Peter", 3000.0, 2.5, 5));
        
        instance.doPrint(customers);        
    }
    
    /**
     * Test of doPrint method, of class Main.
     * Should fail since the Customers ArrayList is invalid
     */
    @org.junit.jupiter.api.Test
    public void testDoPrint2() {
        System.out.println("doPrint (Test 2)");
        Main instance = new Main();
             
        List<Customer> customers = new ArrayList<Customer>();
        customers.add(new Customer("John", -1000.0, 5.0, 5));
        customers.add(new Customer("Peter", -3000.0, 2.5, 5));
        
        instance.doPrint(customers);        
    }
    
    /**
     * Test of doPrint method, of class Main.
     * Should fail since the Customers ArrayList is null
     */
    @org.junit.jupiter.api.Test
    public void testDoPrint3() {
        System.out.println("doPrint (Test 3)");
        Main instance = new Main();
                
        instance.doPrint(null);        
    }
}
