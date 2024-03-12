package mx.edu.utez.sda.springmvc8a.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true
)
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsServices(){
        UserDetails user  = User.withUsername("user1").password(
                passwordEncoder().encode("user123")
        ).roles("USER").build();

        UserDetails user2  = User.withUsername("user2").password(
                passwordEncoder().encode("user123")
        ).roles("Role_Admin").build();

        UserDetails children  = User.withUsername("children").password(
                passwordEncoder().encode("user123")
        ).roles("children").build();

        UserDetails adulto  = User.withUsername("adulto").password(
                passwordEncoder().encode("user123")
        ).roles("adulto").build();

        return new InMemoryUserDetailsManager(user,user2,children,adulto);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((request)->{
            request.requestMatchers("/","/index").permitAll();
            request.anyRequest().authenticated();
        });
        http.formLogin((login)->{
            login.loginPage("/login").permitAll();
        });

        http.logout((logout)->{
            logout.permitAll();
        });
        return  http.build();
    }
}
