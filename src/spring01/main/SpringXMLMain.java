package spring01.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring01.model.DbInfoService;
import spring01.model.EmailInfoService;
import spring01.model.GenericInfoService;

public class SpringXMLMain {

	public static void main(String[] args) {
		// load Spring XML Configuration 
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get bean and call its method
		EmailInfoService e = context.getBean("emailBean", EmailInfoService.class);
		
		System.out.println("Email name: "+ e.getName());
		
		DbInfoService d = (DbInfoService) context.getBean("dbBean");
		System.out.println("db name: " + d.getName());
		
		System.out.println("==============================================");
		
		/////////////////////// compare /////////////////////////////
		GenericInfoService gs1, gs2, gs3, gs4;
		
		gs1 = context.getBean("emailBean", GenericInfoService.class);
		gs2 = context.getBean("dbBean", GenericInfoService.class);
		
		gs3 = (GenericInfoService) context.getBean("emailBean");
		gs4 = (GenericInfoService) context.getBean("dbBean");
		
		System.out.println("2 emailBeans are same? : "+ (gs1 == gs3));
		System.out.println("2 dbBeans are same? : "+ (gs2 == gs4));
		
		System.out.println("==============================================");
		
		////////////////////////////////////////////////////////////////////////
		
		EmailInfoService e2 = context.getBean("emailConst", EmailInfoService.class);
		System.out.println("Email address: " + e2.getAddress());
		System.out.println("==============================================");
		
		EmailInfoService e3 = context.getBean("emailSetter", EmailInfoService.class);
		System.out.println("email address(emailSetter): "+ e3.getAddress());
		
		System.out.println("==============================================");

		EmailInfoService e4 = context.getBean("emailProp", EmailInfoService.class);
		System.out.println("email address(emailProp): "+ e4.getAddress());

		// close context
		context.close();

		///////////////////////////////////////////////////////////////////////

		// load Spring ComponentScan
		System.out.println("\n--------------- Using Annotation -----------------");
		AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(SpringComponentScanConfig.class);

		// get beans
		GenericInfoService g1 = (GenericInfoService) context2.getBean("emailBean");
		GenericInfoService g2 = (GenericInfoService) context2.getBean("dbBean");

		System.out.println("emailBean: " + g1.getName());
		System.out.println("dbBean: " + g2.getName());

		EmailInfoService es1 = (EmailInfoService) context2.getBean("emailConst");
		System.out.println("emailBean(emailConst): "+ es1.getAddress());

		EmailInfoService es2 = (EmailInfoService) context2.getBean("emailSetter");
		System.out.println("emailBean(emailSetter): "+ es2.getAddress());

		EmailInfoService es3 = (EmailInfoService) context2.getBean("emailProp");
		System.out.println("eamilBean(eamilProp): "+ es3.getAddress());
//		close context
		context2.close();
	
	}

}