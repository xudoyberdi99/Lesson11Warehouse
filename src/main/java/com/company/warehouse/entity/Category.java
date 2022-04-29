package com.company.warehouse.entity;

import com.company.warehouse.entity.template.AbctrtEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Category extends AbctrtEntity {
    @ManyToOne
    private Category parentCategory;
}
