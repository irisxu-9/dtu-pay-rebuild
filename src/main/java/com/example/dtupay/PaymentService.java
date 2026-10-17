package com.example.dtupay;

public class PaymentService {

    public void pay(Account customer, Account merchant, PaymentToken token, int amount) {
        // TODO: implement after the first RED test run
        throw new UnsupportedOperationException("Payment not implemented yet");
    }

    public static class Account {
        private int balance;

        public Account(int startingBalance) {
            this.balance = startingBalance;
        }

        public int getBalance() {
            return balance;
        }

        private void debit(int amount) {
            balance -= amount;
        }

        private void credit(int amount) {
            balance += amount;
        }
    }

    public static class PaymentToken {
        private boolean used = false;

        public boolean isUsed() {
            return used;
        }

        private void markUsed() {
            used = true;
        }
    }
}
