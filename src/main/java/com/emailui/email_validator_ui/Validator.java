package com.emailui.email_validator_ui;

public class Validator{
	public Validator(){}
	
	public static int validate(String email){
		int rules = 0;
		if (email.contains(".")){
			++rules;
		}
		if (email.matches("^[^@]*@[^@]*$")){
			++rules;
		}
		//New rules: 1)String must be of form something@something.something
		if (email.matches("^.+@.+\\..+$")){
			++rules;
		}
		//2) TLD must only contain lower case letters
		if (email.matches("^.*\\.[a-z]+$")){
			++rules;
		}
		return rules;
	}
}