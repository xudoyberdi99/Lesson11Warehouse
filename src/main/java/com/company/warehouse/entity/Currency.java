package com.company.warehouse.entity;

import com.company.warehouse.entity.template.AbctrtEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Currency extends AbctrtEntity {

}
