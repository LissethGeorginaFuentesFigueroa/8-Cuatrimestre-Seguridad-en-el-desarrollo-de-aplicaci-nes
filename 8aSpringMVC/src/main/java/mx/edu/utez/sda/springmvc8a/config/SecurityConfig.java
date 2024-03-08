package mx.edu.utez.sda.springmvc8a.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
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
        ).roles("USER").build();

        return new InMemoryUserDetailsManager(user,user2);
    }
}
