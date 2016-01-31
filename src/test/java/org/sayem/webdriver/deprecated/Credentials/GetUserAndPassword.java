package org.sayem.webdriver.deprecated.Credentials;

import org.openqa.selenium.security.UserAndPassword;

public class GetUserAndPassword {

    public static void main(String[] args) {

        UserAndPassword example = new UserAndPassword("user", "password");
        System.out.println(example.getUsername());
        System.out.println(example.getPassword());

    }
}
