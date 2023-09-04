package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment makePayment(Payment payment) {
        // Perform payment processing logic here (e.g., interacting with a payment gateway)
        // You can set paymentStatus to "SUCCESS" or "FAILED" based on the result
        String paymentStatus = "SUCCESS"; // Example

        payment.setPaymentStatus(paymentStatus);

        // Save the payment details to the database
        return paymentRepository.save(payment);
    }
}
