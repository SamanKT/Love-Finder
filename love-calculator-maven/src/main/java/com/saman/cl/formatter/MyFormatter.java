package com.saman.cl.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.saman.cl.api.Phone;

public class MyFormatter implements Formatter<Phone> {

	@Override
	public String print(Phone object, Locale locale) {
		System.out.println("inside the prineter");

		return object.getCountryCode() + "-" + object.getNumber();
	}

	@Override
	public Phone parse(String text, Locale locale) throws ParseException {
		Phone myPhone = new Phone();
		String[] split = text.split("-");
		int indexOf = text.indexOf("-");
		if (indexOf == -1) {
			myPhone.setCountryCode("91");
			myPhone.setNumber(split[0]);
		} else {
			if (split[0].length() == 0) {
				myPhone.setCountryCode("91");
			} else {
				myPhone.setCountryCode(split[0]);
			}
			myPhone.setNumber(split[1]);
		}

		return myPhone;
	}

}
