package com.andrew.springsecurity.config;

import com.andrew.springsecurity.model.Customer;
import com.andrew.springsecurity.repositories.CustomerRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsernameAndPwdAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private CustomerRepositories customerRepositories;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        List<Customer> customer = customerRepositories.findByEmail(username);
        if(customer.size() > 0) {
          if (passwordEncoder.matches(pwd, customer.get(0).getPwd())) {
              List<GrantedAuthority> authorities = new ArrayList<>();
              authorities.add(new SimpleGrantedAuthority(customer.get(0).getRole()));
              return new UsernamePasswordAuthenticationToken(username, pwd, authorities);
          } else {
              throw new BadCredentialsException("Invalid Password");
            }
          } else {
            throw new BadCredentialsException("No User registered with this details");
        }

    }

    @Override
    public boolean supports(Class<?> authentication) {

        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

}