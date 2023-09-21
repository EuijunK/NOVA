package com.sehbeomschool.nova.domain.user.domain;

import com.sehbeomschool.nova.domain.user.dto.KakaoUserInfoDto;
import com.sehbeomschool.nova.global.entity.BaseEntity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long socialId;
    private String name;
    private String profileImg;

    @Builder
    public User(Long socialId, String name, String profileImg) {
        this.socialId = socialId;
        this.name = name;
        this.profileImg = profileImg;
    }

    public User(KakaoUserInfoDto user) {
        this.socialId = user.getId();
        this.name = user.getName();
        this.profileImg = user.getProfileImg();
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void updateProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

}
