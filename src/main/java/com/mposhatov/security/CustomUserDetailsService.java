package com.mposhatov.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

//        final DbClient client = clientRepository.findByLogin(login);
//
//        if (client == null) {
//            throw new UsernameNotFoundException(login);
//        }
//
//        return new User(
//                client.getLogin(), client.getPassword(),
//                true,
//                true,
//                true,
//                true,
//                client.getRoles().stream().map(o -> new SimpleGrantedAuthority(o.name())).collect(Collectors.toList()));
//    }
        return null;
    }
}
