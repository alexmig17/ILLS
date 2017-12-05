package com.ills.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorColumn(name = "ROLE", discriminatorType = DiscriminatorType.STRING)
@Table(name = "PERMISSION")
public class PermissionForRole extends  Permission{
}
