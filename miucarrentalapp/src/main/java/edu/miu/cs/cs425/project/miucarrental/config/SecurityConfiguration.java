package edu.miu.cs.cs425.project.miucarrental.config;


import edu.miu.cs.cs425.project.miucarrental.service.MiuCarRentUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, proxyTargetClass = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
    private UserDetailsService userDetailsService;

    @Autowired
    
    public SecurityConfiguration(MiuCarRentUserDetailsService userDetailsService) {

        this.userDetailsService = userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .userDetailsService(this.userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure (HttpSecurity http) throws Exception{
        http
                .headers()
                .frameOptions().sameOrigin()
                .and()
                .authorizeRequests()
                .antMatchers("/resources/static/**","/images/**","/css/**","/miucarrental/public/**", "/miucarrental/public/login").permitAll()
                .antMatchers("/", "/miucarrental").permitAll()
                .antMatchers("/miucarrental/admin/**").hasRole("ADMIN")
                .antMatchers("/miucarrental/customer/**").hasRole("CUSTOMER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/miucarrental/public/login")
                .defaultSuccessUrl("/miucarrental/public/home")
                .failureUrl("/miucarrental/public/login?error")
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/miucarrental/public/logout"))
                .logoutSuccessUrl("/miucarrental/public/login?logout")
                .permitAll()
                .and()
                .exceptionHandling();


    }
}
