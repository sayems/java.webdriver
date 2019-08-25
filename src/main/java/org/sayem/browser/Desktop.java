package org.sayem.browser;

import com.smartbear.testleft.*;
import com.smartbear.testleft.testobjects.TestProcess;

public class Desktop implements Adapter<TestProcess> {
    @Override
    public Browser<TestProcess> webPage(String url) throws TestAgentRunException, RestConnectionRefused, HttpException, ApiException {
        return new DesktopAdapter(new LocalDriver().getApplications().run(url));
    }
}
