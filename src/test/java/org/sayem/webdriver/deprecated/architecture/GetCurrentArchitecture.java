package org.sayem.webdriver.deprecated.architecture;

import org.openqa.selenium.Architecture;
import org.openqa.selenium.Platform;

public class GetCurrentArchitecture {

    public static void main(String[] args) {

        // I am on Mac x64, so it return me Mac x64

        System.out.print(Platform.getCurrent() + " " + Platform.getCurrent().getMajorVersion());
        System.out.println(" " + Architecture.getCurrent());
    }
}
