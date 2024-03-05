package org.furstd.nnpiacv02.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 * Direktivum ddl-auto může nabývat následujících hodnot:
 * - 'none': Žádné změny schématu nebudou provedeny.
 * - 'validate': Provede validaci schématu bez jeho změny.
 * - 'update': Aktualizuje schéma na základě definice entit.
 * - 'create': Vytvoří schéma při startu a zahodí existující schéma.
 * - 'create-drop': Vytvoří schéma při startu a odstraní ho při ukončení aplikace.
 */
@Getter
@Entity
@NoArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean active;

    @Column(nullable = false)
    private Date creationDate;

    private Date updateDate;

    @OneToMany(mappedBy = "author")
    private final List<Task> tasks = Collections.emptyList();

    @ManyToMany
    @JoinTable(
            name = "app_user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles = new ArrayList<>();

    public AppUser(int id, String username, String password, boolean active, Date creationDate, Date updateDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.active = active;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    public void addRole(Role role) {
        roles.add(role);
    }
}
