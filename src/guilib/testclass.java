package guilib;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;


public class testclass
{
    // instance variables - replace the example below with your own

//    private EmployeeCtr employeeController;
//    private CustomerCtr customerController;
//    private ProductCtr productController;
//    private OrderCtr orderCtr;
    public testclass(){
//        employeeController = new EmployeeCtr();
//        customerController = new CustomerCtr();
//        productController = new ProductCtr();
//        orderCtr = new OrderCtr();
    }

    public String randomDateGenerator() {
    	LocalDate startDate = LocalDate.of(2000, 1, 1); //start date
        long start = startDate.toEpochDay();

        LocalDate endDate = LocalDate.now(); //end date
        long end = endDate.toEpochDay();

        long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
        
        LocalDate localDate = LocalDate.ofEpochDay(randomEpochDay);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/LLLL/yyyy");
        String formattedString = localDate.format(formatter);
        return formattedString;
    }
    
    public void addObjects(){
        //Employees
//        employeeController.createEmployee("Fulderik", 21, "Aalborg", "9000", "Swagstreet 20", "343433453", "Swag@profesional.dk", "1", true);
//        employeeController.createEmployee("Steve", 25, "Aalborg", "9000", "PeteStreet 20", "343433453", "@profesional.dk", "2", true);
//        employeeController.createEmployee("Jens", 60, "Aalborg", "9000", "Istedgade", "343433453", "jens.kinky@yahoo.dk", "3", false);
        //Products
//        productController.createProduct("1", "Tun", 23, 1000, false, "");
//        productController.createProduct("2", "Chips", 12, 920,false, "");
//        productController.createProduct("3", "Boremaskine", 800, 0, true, "REWWW28832");
//        productController.createProduct("4", "Scooter", 12000, 0, true, "Stalmis");

        // Copies
//        UniqueProduct product1 = (UniqueProduct) productController.getProduct("3");
//        productController.createCopy("200332", "2017", product1);
//        productController.createCopy("200332", "2018", product1);
//        productController.createCopy("200332", "2018", product1);

//        UniqueProduct product2 = (UniqueProduct) productController.getProduct("4");
//        productController.createCopy("54432", randomDateGenerator(), product2);
//        productController.createCopy("54435", randomDateGenerator(), product2);
//        productController.createCopy("54420", randomDateGenerator(), product2);
//        productController.createCopy("54499", randomDateGenerator(), product2);
//        productController.createCopy("54469", randomDateGenerator(), product2);
        
        //Customers
//        Customer customer = customerController.createCustomer("Jens", 23, "Skagen", "????", "Jens address", "232764323", "jens@jens.dk");
//        customerController.createCustomer("Bo", 54, "Paris", "????", "Eiffel Tower", "232342324", "jens@jens.dk");
//        customerController.createCustomer("Andreas", 32, "Nordens Paris", "????", "Jomfru Ane Gade", "232336524", "partyfyr@hotmail.dk");
    
        //Orders
        //Order order = orderCtr.createOrder("20", 20, 20, customer);
//        Product product3 = productController.getProduct("1");
//        OrderLine orderLine = orderCtr.createOrderLine(20, product3, order);
//        order.addOrderLine(orderLine);
        
    }
}
