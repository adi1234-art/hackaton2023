package com.example.hackaton.model.dto;

import com.example.hackaton.model.Device;

import java.io.Serializable;

public class AddDeviceDTO implements Serializable {
    private Device device;
    private String answer;

    public AddDeviceDTO() {}

    public AddDeviceDTO(Device device, String answer) {
        this.device = device;
        this.answer = answer;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
