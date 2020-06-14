package edu.miu.cs.cs425.project.miucarrentalal.config;


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
//        http
//                .headers()
//                .frameOptions().sameOrigin()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/resources/static/**","/images/**","/css/**","/miucarrental/public/**").permitAll()
//                .antMatchers("/", "/miucarrental", "/miucarrental/public/home","/miucarrental/public/login").permitAll()
//                .antMatchers("/miucarrental/**").hasRole("ADMIN")
//                .antMatchers("/miucarrental/car/list.html","/miucarrental/car/profile.html","/miucarrental/customer/edit.html","/miucarrental/customer/new.html", "/miucarrental/dashboard/index.html","/miucarrental/rent/**", "/miucarrental/user/edit.html", "/miucarrental/user/new.html").hasRole("CUSTOMER")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/miucarrental/public/login.html")
//                .defaultSuccessUrl("/miucarrental/public/home.html")
//                .failureUrl("/miucarrental/public/login?error")
//                .permitAll()
//                .and()
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/miucarrental/public/logout"))
//                .logoutSuccessUrl("/miucarrental/public/login?logout")
//                .permitAll()
//                .and()
//                .exceptionHandling();


    }
}
