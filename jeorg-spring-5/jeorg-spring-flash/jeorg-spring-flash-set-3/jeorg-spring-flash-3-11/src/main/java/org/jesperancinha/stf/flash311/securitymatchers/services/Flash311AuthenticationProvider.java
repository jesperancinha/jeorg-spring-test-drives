package org.jesperancinha.stf.flash311.securitymatchers.services;

import org.jesperancinha.stf.flash311.securitymatchers.domain.FlashUser;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.List;

import static org.jesperancinha.stf.flash311.securitymatchers.domain.FlashUser.FlashUserBuilder.flashUserBuilder;

public class Flash311AuthenticationProvider implements AuthenticationProvider {
    private static final List<FlashUser> FLASH_USERS = Arrays.asList(
            flashUserBuilder().name("neo_truth").password("redpill").role("ROLE_RED").build(),
            flashUserBuilder().name("neo_lie").password("bluepill").role("ROLE_BLUE").build()
    );

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        final var username = authentication.getName();
        final var password = authentication.getCredentials().toString();
        final var flashLoginUser = flashUserBuilder().name(username).password(password).build();
        final var userOptional =
                FLASH_USERS.stream()
                        .filter(flashLoginUser::equals)
                        .findAny();
        final var grantedAuthorities = List.of(
                new SimpleGrantedAuthority(
                        userOptional.orElseThrow(() ->
                                new BadCredentialsException(String.format("User %s cannot be authenticated!", username)))
                                .getRole()));
        return new UsernamePasswordAuthenticationToken(username, password, grantedAuthorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
