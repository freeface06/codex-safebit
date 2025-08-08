package com.safebit.admin.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.util.Set;

public class AdminGroupCreateRequest {
    @NotBlank
    private String name;

    @NotEmpty
    private Set<Long> authorityIds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Long> getAuthorityIds() {
        return authorityIds;
    }

    public void setAuthorityIds(Set<Long> authorityIds) {
        this.authorityIds = authorityIds;
    }
}
