package pl.niepracuj.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeRequests()
                .antMatchers(HttpMethod.POST,
                        "/adv/create","/company/create", "/level/create", "/seniority/create","/technology/create",  "/user/login" )
                .hasAnyAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.GET, "/**").permitAll()
                .anyRequest().permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();

    }

    // "/adv/search**", wyrzucone z linijki 21

    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService);
    }

}
