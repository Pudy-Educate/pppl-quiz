package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WalletTest {

    Wallet dompet;
    @BeforeEach
    void init(){
        dompet = new Wallet(10000, "IDR");
    }
    @Test
    void testGetInitBalance() {
        Assertions.assertEquals(10000, dompet.getBalance());
    }


    @Test
    void testGetInitCurrency() {
        Assertions.assertEquals("IDR", dompet.getCurrency());

    }

    @Test
    void testDepositAmount() {
        dompet.depositAmount(10000);
        Assertions.assertEquals(20000, dompet.getBalance());
    }

    @Test
    void testDepositAmountNegative() {
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            dompet.depositAmount(-1);
        });
    }

    @Test
    void testDepositAmountZero() {
        dompet.depositAmount(0);
        Assertions.assertEquals(10000, dompet.getBalance());
    }

    @Test
    void testWithdrawAmount() {
        Assertions.assertAll(()->{
            Assertions.assertTrue( dompet.withdrawAmount(5000));
            Assertions.assertEquals(5000, dompet.getBalance());
        });

    }

    @Test
    void testWithdrawnAmountNegative() {
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            dompet.withdrawAmount(-1);
        });
    }

    @Test
    void testWithdrawnAmountExceed() {
     Assertions.assertFalse(dompet.withdrawAmount(20000));
    }

    @Test
    void testTransferFunds() {
        Wallet dompet2 = new Wallet(20000, "IDR");

        dompet.transferFunds(dompet2, 5000);
        Assertions.assertAll(()->{
            Assertions.assertEquals(5000, dompet.getBalance());
            Assertions.assertEquals(25000, dompet2.getBalance());
        });
    }

    @Test
    void testTransferFundsInsufficient() {
        Wallet dompet2 = new Wallet(20000, "IDR");

        Assertions.assertAll(()->{
            Assertions.assertThrows(IllegalArgumentException.class, ()->{
                dompet.transferFunds(dompet2, 50000);
            });
            Assertions.assertEquals(10000, dompet.getBalance());
            Assertions.assertEquals(20000, dompet2.getBalance());
        });
    }

    @Test
    void testTransferFundsDiffCurrency() {
        Wallet dompet2 = new Wallet(20000, "SGD");
        Assertions.assertAll(()->{
            Assertions.assertThrows(IllegalArgumentException.class, ()->{
                dompet.transferFunds(dompet2, 1000);
            });
            Assertions.assertEquals(10000, dompet.getBalance());
            Assertions.assertEquals(20000, dompet2.getBalance());
        });

    }
}