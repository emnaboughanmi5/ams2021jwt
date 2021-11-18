package tn.com.sip.ams.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import tn.com.sip.ams.service.UserService;
import tn.com.sip.ams.service.UserServiceImpl;

@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
     
 
    @Autowired
    private JwtRequestFilter jwtFilter;

    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
	 
	  http.csrf().disable()
	  .authorizeRequests().antMatchers("/login","/api/users","/providers/list").permitAll()
	  .anyRequest().authenticated().and().sessionManagement()
	  .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	  http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	 

    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
	return super.authenticationManagerBean();
    }

    @Bean
    public BCryptPasswordEncoder encoder() {
	return new BCryptPasswordEncoder();
    }

}
