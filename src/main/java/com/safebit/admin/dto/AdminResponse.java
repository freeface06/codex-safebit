package com.safebit.admin.dto;

import java.util.Set;

public class AdminResponse {
    private Long id;
    private String username;
    private String email;
    private Long groupId;
    private Set<Long> authorityIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Set<Long> getAuthorityIds() {
        return authorityIds;
    }

    public void setAuthorityIds(Set<Long> authorityIds) {
        this.authorityIds = authorityIds;
    }
}
