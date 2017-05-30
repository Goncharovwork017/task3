package web.security.customs;

import entities.*;
import dao.IUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * Created by Андрей on 25.05.2017.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserDAO userDao;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userDao.getByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException("No user with such login: " + login);
        } else {
            Roles rol = user.getRoles();
            System.out.println(rol);
            return new CustomUserDetails(user, rol);
        }
    }
}
