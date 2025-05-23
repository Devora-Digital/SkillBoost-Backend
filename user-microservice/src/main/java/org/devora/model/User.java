package org.devora.model;

import jakarta.persistence.*;
import lombok.*;
import org.devora.enums.Language;
import org.devora.enums.Role;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

    private String headline;

    private String description;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Language language = Language.ENGLISH;

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SocialLink> links = new ArrayList<>();
}
