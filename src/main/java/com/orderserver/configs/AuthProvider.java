package com.orderserver.configs;

import com.orderserver.models.User;
import com.orderserver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String name = authentication.getName();
        String password = (String)authentication.getCredentials();

        User user = userRepository.getUser(name, password);

        if (user == null) {
            throw new BadCredentialsException("User not found or name/password wrong");
        }
        if (!password.equals(password)) {
            throw new BadCredentialsException("Password wrong");
        }

        return new UsernamePasswordAuthenticationToken(name, password, user.getUserRoles());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
