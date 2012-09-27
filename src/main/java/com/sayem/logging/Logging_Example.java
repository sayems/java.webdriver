package com.sayem.logging;

import org.apache.log4j.Logger;

public class Logging_Example {


	public static void main(String[] args) {

		// add log4j.jar

		// add log4j.propertie directly inside the src folder

		// create the object in the code
		
		Logger APPLICATION_LOGS = Logger.getLogger("devpinoyLogger");

		APPLICATION_LOGS.debug("hello");

		APPLICATION_LOGS.debug("We are wrinting in to a log file");

		APPLICATION_LOGS.debug("starting the test case xyz test");


	}
}

