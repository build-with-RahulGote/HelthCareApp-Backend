package com.techhub.hms.Repository;

import java.util.List;

import com.techhub.hms.Models.Tests;

public interface TestRepo {
	public boolean isTestAdded(Tests tests);
	public List<Tests> getTests();
}
