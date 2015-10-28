/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibn.rusyd.renal.medika.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author arifullah
 */

@Entity(name = "ms_doctor")
public class Doctor {
    
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @Column(name = "v_name", nullable = false, length = 100)
    private String name;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dob;
    
    @Column(nullable = false)
    private String address;
    
    @Column(nullable = false, length = 20)
    private String phone;
    
    @Column(length = 20)
    private String alternatePhone;
    
    @Column(length = 1)
    private String doctorCategory;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "doctor")
    private List<Registration> regList = new ArrayList<>();
}
