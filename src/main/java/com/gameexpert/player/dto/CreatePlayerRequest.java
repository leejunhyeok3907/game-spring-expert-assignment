package com.gameexpert.player.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class CreatePlayerRequest {

    // TODO Lv 3: 2~12글자의 영문 대소문자, 숫자와 밑줄을 허용하는 검증을 적용합니다.
    @NotBlank(message = "Nickname cannot be blank")
    @Pattern(regexp = "^[a-zA-Z0-9_]{2,12}$", message = "Username must be between 2 and 12 characters and can only contain letters, numbers, and underscores.")
    private final String nickname;

    public CreatePlayerRequest(String nickname) {
        this.nickname = nickname;
    }
}
