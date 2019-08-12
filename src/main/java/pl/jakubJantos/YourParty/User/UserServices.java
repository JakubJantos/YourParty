package pl.jakubJantos.YourParty.User;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public User login(String login, String password) {
        Optional<User> loginUser = userRepository.findAll().stream()
                .filter(u -> u.getLogin().equals(login) & u.getPassword().equals(password))
                .findFirst();
        if (!loginUser.isPresent()) {
            throw new RuntimeException("wrong login or password");
        }

        return loginUser.get();


    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
