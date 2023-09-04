package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
     
   
	@Autowired
    private RestTemplate restTemplate;
 
   @GetMapping("/products")
    public String payment()
    {
   
  
  
      String response = restTemplate.getForObject("http://product-service/vendor/product/all", String.class);
    	
        return response;  
    }
    
    
    
   /* @GetMapping("/getProducts")
    public ResponseEntity<String> getProducts() {
        String url = "http://localhost:8092/vendor/product/all";
        
        // Create a RestTemplate instance
       
        RestTemplate restTemplate = new RestTemplate();
        
        // Make the GET request and retrieve the response as a string
        String response = restTemplate.getForObject(url, String.class);

        return ResponseEntity.ok(response);
    }  */

   

    
    
    
    @PostMapping("/makePayment")
    public ResponseEntity<Payment> makePayment(@RequestBody Payment payment) {
        Payment savedPayment = paymentService.makePayment(payment);

        // Send a simple email receipt
        sendEmailReceipt(savedPayment);

        return new ResponseEntity<>(savedPayment, HttpStatus.CREATED);
    }
    
    

    private void sendEmailReceipt(Payment payment) {
        // Implement email sending logic here using Spring Mail
        // This is a simplified example and should be configured in a real application.
        // For sending emails, you can use JavaMailSender or other email libraries.

        // For this example, we'll just print a simple email receipt.
        System.out.println("Email Receipt:");
        System.out.println("Order ID: " + payment.getOrderId());
        System.out.println("Amount: $" + payment.getAmount());
        System.out.println("Payment Status: " + payment.getPaymentStatus());
        System.out.println("Thank you for your payment!");
    }
}
