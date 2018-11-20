package com.fges.rizomm.m1iii.learningagreementAPI.entity.user;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import com.fges.rizomm.m1iii.learningagreementAPI.entity.LearningEntity;
import com.fges.rizomm.m1iii.learningagreementAPI.util.BCryptManagerUtil;
import com.fges.rizomm.m1iii.learningagreementAPI.util.RoleEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Users")
public class User extends LearningEntity<Long> implements Serializable, UserDetails {

    private static final long serialVersionUID = 1L;

    private String username;

    private String firstname;

    private String lastname;

    @JsonIgnore
    private String password;

    @ManyToOne
    private Place place;

    @ManyToOne
    @JsonIgnore
    private SiteGroup siteGroup;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Order> ordersList;

    @ElementCollection(targetClass = RoleEnum.class, fetch = FetchType.EAGER)
    @Cascade(value = CascadeType.REMOVE)
    @JoinTable(indexes = {
            @Index(name = "INDEX_USER_ROLE", columnList = "id_user") }, name = "roles", joinColumns = @JoinColumn(name = "id_user"))
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Collection<RoleEnum> roles;

    @Column(name = "account_non_expired")
    @JsonIgnore
    private boolean accountNonExpired;

    @Column(name = "account_non_locked")
    @JsonIgnore
    private boolean accountNonLocked;

    @Column(name = "credentials_non_expired")
    @JsonIgnore
    private boolean credentialsNonExpired;

    @Column(name = "enabled")
    @JsonIgnore
    private boolean enabled;

    private String token;

    private boolean passHasBeenSet;

    public User() {
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = false;
        this.passHasBeenSet = false;
        this.roles = Collections.singletonList(RoleEnum.ADMIN);
    }

    public User(String username, String firstname, String lastname, Collection<RoleEnum> roles) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = false;
        this.passHasBeenSet = false;
        this.roles = roles;
    }


    public User(String username, String password, String firstname, String lastname, Collection<RoleEnum> roles) {
        this.username = username;
        this.password = BCryptManagerUtil.passwordencoder().encode(password);
        this.firstname = firstname;
        this.lastname = lastname;
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = false;
        this.passHasBeenSet = false;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String roles = StringUtils.collectionToCommaDelimitedString(getRoles().stream()
                .map(Enum::name).collect(Collectors.toList()));
        return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
    }

    public void setPassword(String password) {
        if (!password.isEmpty()) {
            this.password = BCryptManagerUtil.passwordencoder().encode(password);
        }
    }
}
