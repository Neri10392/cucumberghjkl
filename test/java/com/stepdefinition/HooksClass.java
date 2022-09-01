package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;


import com.base.BaseClass;

import io.cucumber.java.Before;

public class HooksClass extends BaseClass {
	@Before
	public void before() throws FileNotFoundException, IOException {
		getDriver(getPropertyFileValue("browser"));
		getUrl(getPropertyFileValue("url"));

	}

}
