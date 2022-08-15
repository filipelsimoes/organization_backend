package com.pipedrive.challenge.service;

import com.pipedrive.challenge.entity.Organization;
import com.pipedrive.challenge.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.util.stream.Stream;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class Service {

    private final OrganizationRepository organizationRepository;

    public HashSet<Organization> getOrganization(String name){
        List<Organization> byName = organizationRepository.findByNameOrderByNameAsc(name);
        List<Organization> byParent = organizationRepository.findAllByParentOrderByNameAsc(name);
        List<Organization> newList = new ArrayList<>();
        newList.add(0, byName.get(0));
        newList.addAll(byParent);
        LinkedHashSet<Organization> newHash = new LinkedHashSet<>(newList);
        return newHash;
    }
    public List<Organization> getAllOrganizations(){
        return organizationRepository.findAllByOrderByNameAsc();
    }

    public void addOrganization(String name, String parent){
        Organization organization = new Organization (new Random().nextLong(), name, parent);
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
                    addOrganization(row[0], row[1].trim());
                }
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }



}
