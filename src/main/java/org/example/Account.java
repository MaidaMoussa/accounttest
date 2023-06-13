package org.example;

import java.util.regex.Pattern;

public class Account {
    private String accountNumber;

    public Account(String accountNumber) {
        this.setAccountNumber(accountNumber);
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    private void setAccountNumber(String accountNumber) {

        if (accountNumber != null && Pattern.matches("^\\d{3}-\\d{7}-\\d{2}$", accountNumber)) {

            String[] parts = accountNumber.split("-");
            String nbr = parts[0] + parts[1];

            long nbrFromString = Long.parseLong(nbr);
            long modulo = nbrFromString % 97;

            if (modulo == Long.parseLong(parts[2])) {

                this.accountNumber = accountNumber;
            } else {
                throw new IllegalArgumentException("Invalid account number : " +
                        parts[0] + parts[1] + " mod 97 != " + parts[2]);
            }
        } else {
            throw new IllegalArgumentException("Invalid account number : " +
                    accountNumber + " valid example 001-1111111-08");
        }
    }
}
