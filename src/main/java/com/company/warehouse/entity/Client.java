package com.company.warehouse.entity;

import com.company.warehouse.entity.template.AbctrtEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client extends AbctrtEntity {
    @Column(nullable = false,unique = true)
    private String phoneNumber;
}
