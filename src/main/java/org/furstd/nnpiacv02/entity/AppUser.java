package org.furstd.nnpiacv02.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Direktivum ddl-auto může nabývat následujících hodnot:
 * - 'none': Žádné změny schématu nebudou provedeny.
 * - 'validate': Provede validaci schématu bez jeho změny.
 * - 'update': Aktualizuje schéma na základě definice entit.
 * - 'create': Vytvoří schéma při startu a zahodí existující schéma.
 * - 'create-drop': Vytvoří schéma při startu a odstraní ho při ukončení aplikace.
 */
@Data
@Builder
@NoArgsConstructor
@Entity
public class AppUser implements UserDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Setter
    @Column(nullable = false, unique = true)
    private String username;

    @Setter
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean active;

    @Column(nullable = false)
    private Date creationDate;

    private Date updateDate;

    @OneToMany(mappedBy = "author")
    @ToString.Exclude
    private final List<Task> tasks = Collections.emptyList();

    @ManyToMany(fetch = FetchType.EAGER)
    @ToString.Exclude
    @JoinTable(
            name = "app_user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private final List<Role> roles = new ArrayList<>();

    public AppUser(int id, String username, String password, boolean active, Date creationDate, Date updateDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.active = active;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    public AppUser(String username, String password) {
        this.username = username;
        this.password = password;
        this.active = true;
        this.creationDate = new Date();
        this.updateDate = null;
    }

    public void addRole(Role role) {
        roles.add(role);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
