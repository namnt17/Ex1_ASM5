package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.validEmail("email@subdomain.domain.com");
    }

    public boolean validEmail(String email){
        String regexPattern = "^(?=.{1,64}@)([^0-9!@#$+._\"-]{0,})@([a-zA-Z]{0,})[.]([com]{1,})";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }


}
