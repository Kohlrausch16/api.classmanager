package com.classmanager.api.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "language_name")
    private String languageName;

    @Column(name = "languageFlag")
    private String languageFlag;

    @Column(name = "activeStatus")
    private boolean activeStatus;

    @CreatedDate
    @Column(name = "createdAt")
    private LocalDateTime ceatedAt;

    @LastModifiedDate
    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;
}