package org.sayem.browser;

import com.smartbear.testleft.testobjects.TestProcess;

public class DesktopAdapter implements Browser<TestProcess> {

    private TestProcess driver;

    DesktopAdapter(TestProcess driver) {
        this.driver = driver;
    }

    @Override
    public TestProcess driver() {
        return driver;
    }
}
