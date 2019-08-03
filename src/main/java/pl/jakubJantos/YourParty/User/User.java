package pl.jakubJantos.YourParty.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String login;
    private String mail;
    private String password;

    public User(String login, String mail, String password) {
        this.login = login;
        this.mail = mail;
        this.password = password;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }
}