package com.company;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class MainTest {

    @Parameterized.Parameters
    public static Collection data(){
        return Arrays.asList(new Object[][] {
                {"email@domain.com", true},
                {"firstname.lastname@domain.com",false},
                {"email@subdomain.domain.com",false},
                {"firstname+lastname@domain.com",false},
                {"email@123.123.123.123",false},
                {"email@[123.123.123.123]",false},
                {"\"email\"@domain.com",false},
                {"1234567890@domain.com",false},
                {"email@domain-one.com",false},
                {"_______@domain.com",false},
                {"email@domain.name",false},
                {"email@domain.co.jp",false},
                {"firstname-lastname@domain.com",false},
                {"plainaddress",false},
                {"#@%^%#$@#$@#.com",false},
                {"@domain.com",false},
                {"Joe Smith <email@domain.com>",false},
                {"email.domain.com",false},
                {"email@domain@domain.com",false},
                {".email@domain.com",false},
                {"email.@domain.com",false},
                {"email..email@domain.com",false},
                {"あいうえお@domain.com",false},
                {"email@domain.com (Joe Smith)",false},
                {"email@domain",false},
                {"email@-domain.com",false},
                {"email@domain.web",false},
                {"email@111.222.333.44444",false},
                {"email@domain..com",false},
        });
    }

    private String emailInput;
    private boolean resultExpected;

    public MainTest(String emailInput, boolean resultExpected) {
        this.emailInput = emailInput;
        this.resultExpected = resultExpected;
    }


    @Test
    public void testCheckEmail() {
        Main main = new Main();
        assertEquals(resultExpected, main.validEmail(emailInput));
    }
}