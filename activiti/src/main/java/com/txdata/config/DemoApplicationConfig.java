package com.txdata.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class DemoApplicationConfig {

    private Logger logger = LoggerFactory.getLogger(DemoApplicationConfig.class);

    @Bean
    public UserDetailsService myUserDetailsService(){
        InMemoryUserDetailsManager detailsManager = new InMemoryUserDetailsManager();
        String[][] usersGroupAndRoles = {
                {"root","password","ROLE_ACTIVITI_USER","GROUP_activitiTeam"},
                {"jack","password","ROLE_ACTIVITI_USER","GROUP_activitiTeam"},
                {"jerry","password","ROLE_ACTIVITI_USER","GROUP_activitiTeam"},
                {"tom","password","ROLE_ACTIVITI_USER","GROUP_activitiTeam"},
                {"otto","password","ROLE_ACTIVITI_USER","GROUP_activitiTeam"},
                {"other","password","ROLE_ACTIVITI_USER","GROUP_otherTeam"},
                {"admin","password","ROLE_ACTIVITI_ADMIN"},
        };

        for (String[] users : usersGroupAndRoles) {
            //用户组s
            List<String> authorList = Arrays.asList(Arrays.copyOfRange(users,2,users.length));

            logger.info("> Registering new user: {} with the followin Authorities[{}]",users[0],authorList);

            detailsManager.createUser(new User(users[0],
                    passwordEncoder().encode(users[1]),
                    authorList.stream().map(s -> new SimpleGrantedAuthority(s)).collect(Collectors.toList())));
        }
        return detailsManager;
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
