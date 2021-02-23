/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Xariez
 */
public class Customer {

    public String getName() {
        return name;
    }

    public double getTotalLoan() {
        return totalLoan;
    }

    public double getInterest() {
        return interest;
    }

    public int getYears() {
        return years;
    }
    private String name;
    private double totalLoan;
    private double interest;
    private int years;
    
    public Customer(String _name, double _loan, double _interest, int _years) {
        this.name = _name;
        this.totalLoan = _loan;
        this.interest = _interest;
        this.years = _years;
    }
    
    
}
