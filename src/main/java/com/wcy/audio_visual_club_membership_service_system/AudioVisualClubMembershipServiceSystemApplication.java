package com.wcy.audio_visual_club_membership_service_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wcy.audio_visual_club_membership_service_system.mapper")
public class AudioVisualClubMembershipServiceSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(AudioVisualClubMembershipServiceSystemApplication.class, args);
    }

}
