package com.pipedrive.challenge.controller;

import com.pipedrive.challenge.entity.Organization;
import com.pipedrive.challenge.service.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final Service service;

    @CrossOrigin
    @RequestMapping("/getOrganization")
    public @ResponseBody HashSet<Organization> getOrganization(@RequestParam String name) {
        return service.getOrganization(name);
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public @ResponseBody void uploadCSV(@RequestParam("file") MultipartFile file) {
        service.uploadFile(file);
    }

    @GetMapping("/getAllOrganizations")
    public @ResponseBody List<Organization> getAllOrganizations() {
        return service.getAllOrganizations();
    }

    @PostMapping("/addOrganization")
    public @ResponseBody void addOrganization(@RequestParam String name, @RequestParam String parent) {
        service.addOrganization(name, parent);
    }
}
