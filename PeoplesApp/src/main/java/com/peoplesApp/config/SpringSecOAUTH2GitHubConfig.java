package com.peoplesApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecOAUTH2GitHubConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((request) -> request.anyRequest().authenticated())
                .oauth2Login(Customizer.withDefaults());
        return http.build();

    }

//    @Bean
//    public ClientRegistrationRepository clientRepository() {
//        ClientRegistration clientReg =  new ClientRegistration();
//        return new InMemoryClientRegistrationRepository(clientReg);
//    }

//    private ClientRegistration clientRegistration() {
//        return CommonOAuth2Provider.GITHUB.getBuilder("github").clientId("D4d103cd92e32198baf3")
//                .clientSecret("13caa392e4532c87cc29b3ee83aaea225589090e").build();
//    }
//

}
