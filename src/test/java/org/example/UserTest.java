package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

public class UserTest {
    private User user;

    @BeforeEach
    void setup() {
        this.user = new User();
    }

    @ParameterizedTest
    @CsvSource({"John, 33", "Ann, 22", "Paul, 19"})
    void checkUser_ShouldCheckIfCreatedUsersAreEquals(String name, int age) {
        this.user.setName(name);
        this.user.setAge(age);

        Assertions.assertAll(
                () -> Assertions.assertEquals(this.user.getName(), name),
                () -> Assertions.assertEquals(this.user.getAge(), age)
        );
    }

    @Test
    void emptyList_ShouldReturnNullWhenListEmpty() {
        List<User> users = new ArrayList<>();

        Assertions.assertNull(this.user.findUserWithWorstBMI(users));
    }

    
}
