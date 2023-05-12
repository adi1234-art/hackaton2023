package com.example.hackaton.controller;


import com.example.hackaton.model.Client;
import com.example.hackaton.model.Device;
import com.example.hackaton.model.dto.AddDeviceDTO;
import com.example.hackaton.model.dto.JsonResponse;
import com.example.hackaton.repository.ClientRepository;
import com.example.hackaton.repository.DeviceRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * This class is used for sharing devices
 */
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
    public JsonResponse<Boolean> checkIfUserHasThisDevice(@PathVariable("id") String id, @PathVariable("username") String username) {
        return  new JsonResponse<>(users.findByLoginName(username)
                    .map(e-> e.getDevices().stream().anyMatch(f->f.getId().equals(id)))
                    .orElse(false));
    }


    @PostMapping("/{username}")
    public void addDevice(@RequestBody AddDeviceDTO addDeviceDTO, @PathVariable("username") String username) {

        Optional<Client> client = users.findByLoginName(username);
        client.ifPresent(e->{
            if(!e.getAnswer().equals(addDeviceDTO.getAnswer())) {
                throw new IllegalArgumentException("wrong answer");
            }
            addDeviceDTO.getDevice().setClient(e);
            devices.save(addDeviceDTO.getDevice());
        });

    }

}
