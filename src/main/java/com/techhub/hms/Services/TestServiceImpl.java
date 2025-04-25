package com.techhub.hms.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techhub.hms.Models.Tests;
import com.techhub.hms.Repository.TestRepo;

@Service
public class TestServiceImpl implements TestService {
  @Autowired
	TestRepo testRepo;

@Override
public boolean isTestAdded(Tests tests) {
	
	return testRepo.isTestAdded(tests);
}

@Override
public List<Tests> getTests() {
	
	return testRepo.getTests();
}
}
