/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibn.rusyd.renal.medika.dao;

import com.ibn.rusyd.renal.medika.entity.Ward;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author arifullah
 */
public interface WardDao extends PagingAndSortingRepository<Ward, String>{
    
}
