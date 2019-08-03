package pl.jakubJantos.YourParty.User;

import org.springframework.stereotype.Service;

@Service
public class UserServices {

    private final UserRepository userRepository;

    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean register(String mail, String Login, String password) {
        boolean isMailUnique = userRepository.findAll().stream()
                .anyMatch(u -> u.getMail().equals(mail));
        if (isMailUnique) {
            throw new RuntimeException("Mail is allredy exist");
        }
        User user = new User(mail, Login, password);
        User created = userRepository.save(user);

        return created.getId() != null;

    }
}
