package com.pipedrive.challenge.service;

import com.pipedrive.challenge.entity.Organization;
import com.pipedrive.challenge.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class Service {

    private final OrganizationRepository organizationRepository;

    public HashSet<Organization> getOrganization(String name){
        List<Organization> byParent = organizationRepository.findAllByParent(name);
        List<Organization> byName = organizationRepository.findByName(name);
        List<Organization> newList = Stream.concat(byName.stream(), byParent.stream()).toList();
        HashSet<Organization> newHash = new HashSet<>(newList);
        return newHash;
    }
    public List<Organization> getAllOrganizations(){
        System.out.println(organizationRepository.findAll());
        return organizationRepository.findAll();
    }

    public void addOrganization(Organization organization){
        organizationRepository.save(organization);
    }

    public void uploadFile(MultipartFile file){
        if (!file.isEmpty() && file.getContentType().contains("csv")) {
            try {
                byte[] bytes = file.getBytes();
                String completeData = new String(bytes);
                String[] rows = completeData.split("#");
                String[] columns = rows[0].split(",");
                for(int i =1; i < columns.length-1; i++){
                    String[] row = completeData.split(System.lineSeparator())[i].split(",");
                    Organization newOrganization = new Organization(new Random().nextLong(), row[0], row[1].trim());
                    addOrganization(newOrganization);
                }
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }



}
