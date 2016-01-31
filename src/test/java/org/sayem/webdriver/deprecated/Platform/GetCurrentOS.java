package org.sayem.webdriver.deprecated.Platform;

import org.openqa.selenium.Platform;

import java.util.Arrays;

import static org.openqa.selenium.Platform.getCurrent;

public class GetCurrentOS {

    public static void main(String[] args) {

        // I am on Mac, so it return me information about Mac
        System.out.println(Arrays.toString(Platform.values())); // [WINDOWS, XP, VISTA, WIN8, MAC, UNIX, LINUX, ANDROID, ANY]
        System.out.println(getCurrent()); // MAC
        System.out.println(Arrays.toString(getCurrent().getPartOfOsName()));  // [mac, darwin]
        System.out.println(getCurrent().getMajorVersion()); // 10
        System.out.println(getCurrent().getMinorVersion()); // 9


        System.out.println(Platform.LINUX.is(Platform.UNIX)); // Return true
        System.out.println(Platform.MAC.is(Platform.WINDOWS)); // Return false


        // I am on Mac, so It return me Mac
        if (Platform.getCurrent().equals(Platform.MAC)) {
            System.out.println("Mac");
            // Do something....

        } else if (Platform.getCurrent().equals(Platform.WINDOWS)) {
            System.out.println("Windows");
            // Do something...
        } else {
            System.out.println("Unknown");
        }

    }
}
