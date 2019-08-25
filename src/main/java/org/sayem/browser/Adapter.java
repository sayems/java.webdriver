package org.sayem.browser;

import com.smartbear.testleft.HttpException;
import com.smartbear.testleft.RestConnectionRefused;
import com.smartbear.testleft.TestAgentRunException;

/**
 * Created by sayem on 08/02/17.
 */
public interface Adapter<T> {
    Browser<T> browser() throws TestAgentRunException, RestConnectionRefused, HttpException;
}
