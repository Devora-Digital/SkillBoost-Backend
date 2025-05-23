package org.devora.model;

import jakarta.persistence.*;
import lombok.*;
import org.devora.enums.SocialLinkType;

import java.util.UUID;

@Entity
@Table(name = "user_links")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SocialLink {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SocialLinkType type;

    @Column(nullable = false)
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
