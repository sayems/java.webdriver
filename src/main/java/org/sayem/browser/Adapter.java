package org.sayem.browser;

import com.smartbear.testleft.ApiException;
import com.smartbear.testleft.HttpException;
import com.smartbear.testleft.RestConnectionRefused;
import com.smartbear.testleft.TestAgentRunException;
import com.smartbear.testleft.testobjects.TestObject;

public interface Adapter<T extends TestObject> {
    Browser<T> webPage(String app) throws TestAgentRunException, RestConnectionRefused, HttpException, ApiException;
}
