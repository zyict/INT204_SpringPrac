package spring01.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import spring01.model.EmailInfoService;

@Configuration
@PropertySource("classpath:email.properties")
@ComponentScan("spring01.model")
public class SpringComponentScanConfig {

    @Bean
    public EmailInfoService emailConst(){
        return new EmailInfoService("sit.sit@kmutt.ac.th");
    }

    @Bean(name = "emailSetter")
    public EmailInfoService emailSetter(){
        EmailInfoService emailService = new EmailInfoService();
        emailService.setAddress("sit@kmutt.ac.th");
        return emailService;
    }

    @Value("${email.address}")
    private String tmp;
    @Bean
    public EmailInfoService emailProp(){
        return new EmailInfoService(tmp);
    }
}
