package com.example.hackaton.controller;



import com.example.hackaton.model.Client;
import com.example.hackaton.repository.ClientRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class ClientController {

    private final ClientRepository users;

    public ClientController(ClientRepository users) {
        this.users = users;
    }

    @GetMapping
    public List<Client> getUsers() {
        return users.findAll();
    }

    @GetMapping("/{username}")
    public Client getUser(@PathVariable String username) {
        return users.findByLoginName(username).orElse(null);
    }
    @GetMapping("/{username}/question")
    public String getQuestion(@PathVariable String username) {
       return users.findByLoginName(username)
                .map(Client::getQuestion)
                .orElse("No question");
    }

}
