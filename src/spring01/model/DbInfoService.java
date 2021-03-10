package spring01.model;

import org.springframework.stereotype.Component;

@Component("dbBean")
public class DbInfoService implements GenericInfoService {
	@Override
	public String getName() {
		return "database";
	}

	@Override
	public void initMethod() {
		 System.out.println("database service initialization.");
		
	}

	@Override
	public void endMethod() {
		System.out.println("database service destroy.");
		
	}
}
