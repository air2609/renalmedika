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
@Entity(name = "ms_patient")
public class Patient {
    
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @Column(name = "mr_code", length = 12, nullable = false)
    private String mrCode;
    
    @Column(name = "sex", length = 1, nullable = false)
    private String gender;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dob;
    
    @Column(nullable = false)
    private String address;
    
    @Column(length = 20)
    private String phone;
    
    @Column(name = "alternate_phone", length = 20)
    private String alternatePhone;
    
    @Column(length = 30)
    private String email;
    
    @Column(name = "patient_category", nullable = false, length = 20)
    private String patientCategory;
    
    @Column(name = "patient_type", length = 2)
    private String patientType; 
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "patient")
    private List<Registration> regList = new ArrayList<>();
    
}
