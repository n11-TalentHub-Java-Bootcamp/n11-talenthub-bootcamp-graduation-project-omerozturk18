package com.omerozturk.N11GraduationProject.gen.configuration;


import com.twilio.Twilio;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("twilio")
@Data
public class TwilioConfiguration {

    private String accountSid;
    private String authToken;
    private String trialNumber;

    @Bean
    public void twilioService(){
        Twilio.init(accountSid,authToken);
    }

}