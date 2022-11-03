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
                {"email@domain.com", true},//0
                {"firstname.lastname@domain.com",false},//1
                {"email@subdomain.domain.com",false},//2
                {"firstname+lastname@domain.com",false},//3
                {"email@123.123.123.123",false},//4
                {"email@[123.123.123.123]",false},//5
                {"\"email\"@domain.com",false},//6
                {"1234567890@domain.com",false},//7
                {"email@domain-one.com",false},//8
                {"_______@domain.com",false},//9
                {"email@domain.name",false},//10
                {"email@domain.co.jp",false},//11
                {"firstname-lastname@domain.com",false},//12
                {"plainaddress",false},//13
                {"#@%^%#$@#$@#.com",false},//14
                {"@domain.com",false},//15
                {"Joe Smith <email@domain.com>",false},//16
                {"email.domain.com",false},//17
                {"email@domain@domain.com",false},//18
                {".email@domain.com",false},//19
                {"email.@domain.com",false},//20
                {"email..email@domain.com",false},//21
                {"あいうえお@domain.com",false},//22
                {"email@domain.com (Joe Smith)",false},//23
                {"email@domain",false},//24
                {"email@-domain.com",false},//25
                {"email@domain.web",false},//26
                {"email@111.222.333.44444",false},//27
                {"email@domain..com",false},//28
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