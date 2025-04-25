package com.techhub.hms.Services;

import java.util.List;


import com.techhub.hms.Models.Tests;

public interface TestService {

	public boolean isTestAdded(Tests tests);
	public List<Tests> getTests();
}
