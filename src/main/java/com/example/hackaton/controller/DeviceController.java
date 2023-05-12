package com.example.hackaton.controller;


import com.example.hackaton.model.Client;
import com.example.hackaton.model.Device;
import com.example.hackaton.repository.ClientRepository;
import com.example.hackaton.repository.DeviceRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/devices",produces = MediaType.APPLICATION_JSON_VALUE)
public class DeviceController {

    private final ClientRepository users;

    private final DeviceRepository devices;

    public DeviceController(ClientRepository users, DeviceRepository devices) {
        this.users = users;
        this.devices = devices;
    }


    @GetMapping("/{id}/{username}")
    public Boolean checkIfUserHasThisDevice(@PathVariable("id") String id, @PathVariable("username") String username) {
        return  users.findByLoginName(username)
                    .map(e-> e.getDevices().stream().noneMatch(f->f.getId().equals(id)))
                    .orElse(false);
    }


    @PostMapping("/{username}")
    public void addDevice(@RequestBody Device device, @PathVariable String username) {
        Optional<Client> client = users.findByLoginName(username);
        client.ifPresent(e->{
            device.setClient(e);
            devices.save(device);
        });

    }

}
