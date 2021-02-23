
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Xariez
 */
public class Main {
    public static void main(String[] args) {
        new Main().doRead();
    }
    
    public void doRead() {
        try {
            List<Customer> customers = new ArrayList<Customer>();
            
            String path = System.getProperty("user.dir") + "/src/main/java/prospects.txt";
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String str = null;
            boolean firstLine = true;
                        
            while((str = reader.readLine()) != null && str.length() > 1) {
                if(firstLine) {
                    firstLine = false;
                    continue;
                }
                
                if(!str.startsWith("\"")) {
                    String[] temp = str.split(",");
                    customers.add(new Customer(temp[0], Double.parseDouble(temp[1]), Double.parseDouble(temp[2]), Integer.parseInt(temp[3])));
                }
                else {
                    String[] temp = str.replaceFirst(",", " ").split(",");
                    customers.add(new Customer(temp[0].replace("\"", ""), Double.parseDouble(temp[1]), Double.parseDouble(temp[2]), Integer.parseInt(temp[3])));
                }
            }
            
            doPrint(customers);
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    } 
    
    private double getPower(double base, int exp) {
        double result = 1;
        while(exp-- > 0) {
            result *= base;
        }
        return result;
    }
    
    public void doPrint(List<Customer> customers) {
        try {
            for(Customer item : customers) {
                if(item.getTotalLoan() < 0 || item.getInterest() < 0 || item.getYears() < 0) {
                    System.out.println("One or more values for " + item.getName() + " are less than 0 and cannot be processed. Continuing to next customer.");
                    continue;
                }                  
                
                int numOfPayments = item.getYears() * 12;
                double calcInterest = item.getInterest() / (12 * 100);
                double formula = item.getTotalLoan() * (calcInterest * getPower((1 + calcInterest), numOfPayments)) / (getPower(1 + calcInterest, numOfPayments) - 1);

                DecimalFormat numFormat = new DecimalFormat("#.00");                
                System.out.println(item.getName() + " wants to borrow " +
                                   item.getTotalLoan() + " € for a period of " +
                                   item.getYears() + " years and pay  " +
                                   numFormat.format(formula) + " € each month");
            }
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
