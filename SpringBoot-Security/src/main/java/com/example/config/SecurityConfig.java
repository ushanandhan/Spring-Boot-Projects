package com.example.config;

import com.example.filter.JWTUsernameAndPasswordAuthFilter;
import com.example.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.concurrent.TimeUnit;

import static com.example.enums.UserRole.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
//Adding this annotation to make sure @PreAuthorize work in Controller
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    public SecurityConfig(PasswordEncoder passwordEncoder,UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        // Form based Authentication begins here...
//                .csrf().disable()//Enable this only if requests coming from browser. Requests from any applications we can keep this disabled.
//                .authorizeRequests()
//                .antMatchers("/", "index", "/css/**").permitAll()
//                .antMatchers("/api/**").hasRole(STUDENT.name())
////                .antMatchers(HttpMethod.DELETE,"/management/api/**").hasAuthority(UserPermission.COURSE_WRITE.getPermission())
////                .antMatchers(HttpMethod.POST,"/management/api/**").hasAuthority(UserPermission.COURSE_WRITE.getPermission())
////                .antMatchers(HttpMethod.PUT,"/management/api/**").hasAuthority(UserPermission.COURSE_WRITE.getPermission())
////                .antMatchers(HttpMethod.GET,"management/api/**").hasAnyRole(ADMIN.name(), ADMIN_TRAINEE.name())
//                .anyRequest()
//                .authenticated()
//                .and()
////                .httpBasic() // Use this if requests coming as web services
//                .formLogin()
//                    .loginPage("/login")
//                    .permitAll()
//                    .defaultSuccessUrl("/courses",true)
//                    .usernameParameter("user")  //This parameter name should be matched with "name" attribute of input text
//                    .passwordParameter("pass")  //This parameter name should be matched with "name" attribute of input text
//                .and()
//                .rememberMe()
//                    .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21)) // Defaults to 2 Weeks but we set here 3 weeks
//                    .key("somethingverysecured")
//                    .rememberMeParameter("remember")    //This parameter name should be matched with "name" attribute of input text
//                .and()
//                .logout()
//                    .logoutUrl("/logout")
//                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout","GET"))
//                    .clearAuthentication(true)
//                    .invalidateHttpSession(true)
//                    .deleteCookies("JSESSIONID","remember-me")
//                    .logoutSuccessUrl("/login");
        // Form based Authentication Ends here...

        // JWT based Authentication Begins here...
                .csrf().disable()//Enable this only if requests coming from browser. Requests from any applications we can keep this disabled.
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                    .addFilter(new JWTUsernameAndPasswordAuthFilter(authenticationManager()))
                    .authorizeRequests()
                    .antMatchers("/", "index", "/css/**").permitAll()
                    .antMatchers("/api/**").hasRole(STUDENT.name())
                   .anyRequest()
                    .authenticated();
        // JWT based Authentication Ends here...
    }

    /*@Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails ushan = User.builder()
                .username("ushan")
                .password(passwordEncoder.encode("password"))
//                .roles(STUDENT.name()) // ROLE_STUDENT
                .authorities(STUDENT.getGrantedAuthorities())
                .build();

        UserDetails ariya = User.builder()
                .username("ariya")
                .password(passwordEncoder.encode("12345"))
//                .roles(ADMIN.name()) // ROLE_ADMIN
                .authorities(ADMIN.getGrantedAuthorities())
                .build();

        UserDetails varadhan = User.builder()
                .username("varadhan")
                .password(passwordEncoder.encode("12345"))
//                .roles(ADMIN_TRAINEE.name()) // ROLE_ADMIN_TRAINEE
                .authorities(ADMIN_TRAINEE.getGrantedAuthorities())
                .build();

        return new InMemoryUserDetailsManager(
                ushan,
                ariya,
                varadhan
        );
    }*/

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userService);
        return provider;
    }
}
