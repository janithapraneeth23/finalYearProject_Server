package com.janitha.videoenhancer.serverAtCloud.securingweb;
import com.janitha.videoenhancer.serverAtCloud.external.UserRepository;
import com.janitha.videoenhancer.serverAtCloud.formLogin.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserDetailsService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not present"));
        return user;
    }

    public boolean createUser(UserDetails user)
    {
        try{
            userRepository.save((User)user);
        }catch(Exception e){
            return false;
        }
        return true;
    }

    public boolean isUserExist(UserDetails user)
    {
        try{
            User tmpUser = userRepository.findUserByUsername(user.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User not present"));
        }catch(Exception e){
            return false;
        }
        return true;
    }
}
