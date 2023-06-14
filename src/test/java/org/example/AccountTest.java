package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class AccountTest {

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", "    ", "008-9999999-07", "aaa-4444444-99",})
    public void constructor_ShouldThrowExceptionForInvalidAccountFormat(String accountNumber) {

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Account(accountNumber));
    }

    @ParameterizedTest
    @ValueSource(strings = {"008-9999999-07", "078-9999999-77"})
    public void constructor_ShouldThrowExceptionForInvalidModuloChecksum(String accountNumber) {

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Account(accountNumber));
    }

    @ParameterizedTest
    @ValueSource(strings = {"008-9999999-04", "078-6667778-09", "066-7778882-36"})
    public void constructor_ShouldNotThrowForValidAccountNumbers(String accountNumber) {

        Assertions.assertDoesNotThrow(() -> new Account(accountNumber));
    }

}