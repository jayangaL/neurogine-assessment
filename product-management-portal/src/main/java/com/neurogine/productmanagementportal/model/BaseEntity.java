package com.neurogine.productmanagementportal.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public class BaseEntity {
    @Version
    private Long version;
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_date;
    @CreatedBy
    private String created_by;
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_date;
    @LastModifiedBy
    private String updated_by;
    @Column(name = "deleted")
    private boolean deleted;
}
