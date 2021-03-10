package spring01.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component("emailBean")
public class EmailInfoService implements GenericInfoService {

	private String address;

	public EmailInfoService() {
		
	}

	public EmailInfoService(String address) {
		this.address = address;
	}

	@Override
	public String getName() {
		return "email";
	}
	
	@Override
	public void initMethod() {
		System.out.println("email service initialization.");
	}

	@Override
	public void endMethod() {
		System.out.println("email service destroy.");
		
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
