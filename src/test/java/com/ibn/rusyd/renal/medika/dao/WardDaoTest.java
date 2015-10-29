/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibn.rusyd.renal.medika.dao;

import com.ibn.rusyd.renal.medika.RenalmedikaApplication;
import com.ibn.rusyd.renal.medika.entity.Ward;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author arifullah
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RenalmedikaApplication.class)

public class WardDaoTest {
    
    @Autowired
    private WardDao wd;
    
    @Autowired
    private DataSource ds;
    
    @Test
    public void testInsert() throws SQLException{
        Ward ward = new Ward();
        ward.setId("001");
        ward.setCode("SER1");
        ward.setName("SERUNI 1");
        
        wd.save(ward);
        
        String sql = "select count(1) as jumlah from ms_ward where code='SER1'";
        
        try (Connection con = ds.getConnection()) {
            ResultSet rs = con.createStatement().executeQuery(sql);
            
            Assert.assertTrue(rs.next());
            Long jumlahRow = rs.getLong("jumlah");
            Assert.assertEquals(1L, jumlahRow.longValue());
        }
    }
    
}
