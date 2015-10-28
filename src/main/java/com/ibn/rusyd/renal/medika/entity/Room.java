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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author arifullah
 */
@Entity(name = "ms_room")
public class Room {
    
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @Column(nullable = false, unique = true, length = 10)
    private String code;
    
    @Column(name = "room_name", nullable = false)
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "ward_id", nullable = false)
    private Ward ward;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "room")
    private List<Bed> listBed = new ArrayList<>();
}
