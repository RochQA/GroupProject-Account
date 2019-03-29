package com.example.demo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ControllerTests.class, AccountTests.class, AccountApplicationTests.class, ServiceTests.class})
public class SuiteTest { 

}

