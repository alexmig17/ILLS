package com.ills.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Alex on 02.12.2017.
 */
@Entity
@Table(name="ROLE")
public class Role extends EntityA<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROL_OID")
    private Long oid;

    @Column(name = "ROL_NAME")
    private String roleName;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "role")
    private List<RolePermission> rolePermissions;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<RolePermission> getRolePermissions() {
        return rolePermissions;
    }

    public void setRolePermissions(List<RolePermission> rolePermissions) {
        this.rolePermissions = rolePermissions;
    }
}
