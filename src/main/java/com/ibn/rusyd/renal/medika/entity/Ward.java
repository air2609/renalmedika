/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibn.rusyd.renal.medika.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author arifullah
 */
@Entity(name = "ms_ward")
public class Ward {
    
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @Column(nullable = false, unique = true, length = 5)
    private String code;
    
    @Column(nullable = false, name = "v_name")
    private String name;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "ward")
    private List<Room> listRooms = new ArrayList<>();
     
}
