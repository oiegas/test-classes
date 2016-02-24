package com.converter;

import com.domain.Test;
import com.ui.domain.UITest;

public interface TestConverter {

	public Test createTest(UITest ui);
	public UITest createUITest(Test test);
}
