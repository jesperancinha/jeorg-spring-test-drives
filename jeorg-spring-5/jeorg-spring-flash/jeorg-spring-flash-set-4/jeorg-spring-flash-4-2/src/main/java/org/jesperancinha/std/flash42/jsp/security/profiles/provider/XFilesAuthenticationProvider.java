package org.jesperancinha.std.flash42.jsp.security.profiles.provider;

import org.jesperancinha.std.flash42.jsp.security.profiles.domain.XFilesUser;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.List;

public class XFilesAuthenticationProvider implements AuthenticationProvider {
    private static final List<XFilesUser> FLASH_USERS = Arrays.asList(
            XFilesUser.FlashUserBuilder.flashUserBuilder().name("admin").password("admin").role("ROLE_ADMIN").build(),
            XFilesUser.FlashUserBuilder.flashUserBuilder().name("user").password("user").role("ROLE_USER").build()
    );

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        final var username = authentication.getName();
        final var password = authentication.getCredentials().toString();
        final var flashLoginUser = XFilesUser.FlashUserBuilder.flashUserBuilder().name(username).password(password).build();
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
