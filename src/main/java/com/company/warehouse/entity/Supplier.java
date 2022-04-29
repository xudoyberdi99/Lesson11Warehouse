package com.company.warehouse.entity;

import com.company.warehouse.entity.template.AbctrtEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Supplier extends AbctrtEntity {
    @Column(unique = true,nullable = false)
    private String phoneNumber;
}
