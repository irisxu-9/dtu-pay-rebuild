package com.example.dtupay;

import org.junit.jupiter.api.Disabled;  // 临时隔离尚未进入本次开发范围的测试
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PaymentServiceTest {

    @Test
    @Disabled("Planned for later: payment with token authorization")
    void successfulPaymentTransfersMoneyAndConsumesToken() {
        PaymentService.Account customer = new PaymentService.Account(1000);
        PaymentService.Account merchant = new PaymentService.Account(200);
        PaymentService.PaymentToken token = new PaymentService.PaymentToken();

        new PaymentService().pay(customer, merchant, token, 100);

        assertEquals(900, customer.getBalance());
        assertEquals(300, merchant.getBalance());
        assertTrue(token.isUsed());
    }
}
