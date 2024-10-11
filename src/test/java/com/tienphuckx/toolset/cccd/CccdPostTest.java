package com.tienphuckx.toolset.cccd;

import com.tienphuckx.toolset.entity.cccd.Cccd;
import com.tienphuckx.toolset.entity.user.User;
import com.tienphuckx.toolset.repository.CccdRepository;
import com.tienphuckx.toolset.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CccdPostTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CccdRepository cccdRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    void one_to_one_test() {
        // Create a new CCCD
        Cccd cccd = new Cccd();
        cccd.setCccdNumber("234434242424");

        // Create a new user
        User user = new User();
        user.setUserName("ab32434cd");
        user.setUserEmail("me55355omeo1");
        user.setUserPhone("fffff");
        user.setUserPassword("*********");

        // Set the CCCD to the user
        user.setCccd(cccd);

        // Save the user (CCCD will be saved automatically due to cascading)
        userRepository.save(user);

        // Assertions
//        User savedUser = userRepository.findById(user.getId()).orElse(null);
//        assertNotNull(savedUser);
//        assertNotNull(savedUser.getCccd());
//        assertEquals("123456789", savedUser.getCccd().getCccdNumber());
//
//        // Fetch the CCCD and ensure it is linked to the correct user
//        Cccd savedCccd = cccdRepository.findById(cccd.getId()).orElse(null);
//        assertNotNull(savedCccd);
//        assertEquals("John Wick", savedCccd.getUser().getUserName());
    }
}
