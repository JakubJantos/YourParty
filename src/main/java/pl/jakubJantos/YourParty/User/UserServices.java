package pl.jakubJantos.YourParty.User;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    private final UserRepository userRepository;

    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    //systerm rejestracji
    public boolean register(String mail, String login, String password) {
        boolean isMailAndLoginUnique = userRepository.findAll().stream()
                .anyMatch(u -> u.getMail().equals(mail) || u.getLogin().equals(login));
        if (isMailAndLoginUnique) {
            throw new RuntimeException("Mail is allredy exist");
        }
        User user = new User(login, mail, password);
        User created = userRepository.save(user);

        return created.getId() != null;

    }

    //system logowania
    public boolean login(String login, String password) {
        boolean loginUser = userRepository.findAll().stream()
                .anyMatch(u -> u.getLogin().equals(login) & u.getPassword().equals(password));
        if (!loginUser) {
            throw new RuntimeException("wrong login or password");
        }
        return loginUser;


    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
