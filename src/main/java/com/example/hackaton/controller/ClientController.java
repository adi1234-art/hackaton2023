package com.example.hackaton.controller;



import com.example.hackaton.model.Client;
import com.example.hackaton.repository.ClientRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;



/**
 * This class is used for sharing client information for siteKey frontendApp.
 * Business case behind it's creation was to make frontend mock able to download
 */
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

    /**
     * method created mostly for tasting purposes only, does not implement business logic
     * @param username is the name of the user we would like to get information about
     * @return  user or null
     */
    @GetMapping("/{username}")
    public Client getUser(@PathVariable String username) {
        return users.findByLoginName(username).orElse(null);
    }

    /**
     * method is used for fetching question for the verification user case in ot
     * @param username is the name of the user we would like to get information about
     * @return question for the user
     */
    @GetMapping("/{username}/question")
    public String getQuestion(@PathVariable String username) {
       return users.findByLoginName(username)
                .map(Client::getQuestion)
                .orElse("No question");
    }

}
