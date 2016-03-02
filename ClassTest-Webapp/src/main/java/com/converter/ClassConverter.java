package com.converter;

import com.domain.Clas;
import com.ui.domain.UIClass;

public interface ClassConverter {

	public Clas createClass(UIClass ui);
	public UIClass createUIClass(Clas clas);
}
