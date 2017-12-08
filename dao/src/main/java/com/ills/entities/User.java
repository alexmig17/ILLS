package com.ills.entities;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by Alex on 21.11.2017.
 */
@Entity
@Table(name = "USER")
public class User implements EntityI {

    public static final String PREFIX = "USR";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USR_OID")
    private Long oid;

    @Column(name = "USR_LOGIN", unique = true)
    private String login;

    @Column(name = "USR_PASSWORD", nullable = false)
    private String password;

    @Column(name = "USR_IS_ENABLE")
    private boolean isEnabled;

    @Column(name = "USR_IS_ACCOUNT_NON_EXPIRED")
    private boolean isAccountNonExpired;

    @Column(name = "USR_IS_CREDENTIAL_NON_EXPIRED")
    private boolean isCredentialsNonExpired;

    @Column(name = "USR_IS_ACCOUNT_NON_LOCKED")
    private boolean isAccountNonLocked;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<UserExcludePermission> excludePermissions;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<UserIncludePermission> includePermissions;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserRole> userRoles;

    public Long getId() {
        return oid;
    }

    public void setId(Long oid) {
        this.oid = oid;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
    }

    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
    }

    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    /*public List<UserExcludePermission> getExcludePermissions() {
        return excludePermissions;
    }

    public void setExcludePermissions(List<UserExcludePermission> excludePermissions) {
        this.excludePermissions = excludePermissions;
    }*/

   /* public List<UserIncludePermission> getIncludePermissions() {
        return includePermissions;
    }

    public void setIncludePermissions(List<UserIncludePermission> includePermissions) {
        this.includePermissions = includePermissions;
    }*/

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
