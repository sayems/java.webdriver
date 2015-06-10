package org.sayem.webdriver.basics.webdriver.examples;

import org.junit.Test;
import org.openqa.selenium.os.WindowsUtils;

import static org.junit.Assert.assertEquals;

public class WindowsRegistry {

    @Test
    public void testReadRegistry() {
        String osname = WindowsUtils.readStringRegistryValue("HKEY_LOCAL_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\ProductName");
        System.out.println(osname);
    }

    @Test
    public void testWriteRegistry() {
        WindowsUtils.writeStringRegistryValue("HKEY_CURRENT_USER\\SOFTWARE\\Selenium\\SeleniumVersion", "2.24");
        assertEquals("2.24", WindowsUtils.readStringRegistryValue("HKEY_CURRENT_USER\\SOFTWARE\\Selenium\\SeleniumVersion"));
    }
}