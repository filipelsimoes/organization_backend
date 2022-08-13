package com.pipedrive.challenge.repository;

import com.pipedrive.challenge.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    List<Organization> findByName(String organizationName);
    List<Organization> findAllByParent(String parentOrganization);
}
