package com.gameexpert.player.service;

import com.gameexpert.player.repository.PlayerRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gameexpert.common.ConflictException;
import com.gameexpert.player.dto.CreatePlayerRequest;
import com.gameexpert.player.entity.Player;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Transactional
    public void createPlayer(CreatePlayerRequest request) {
        // TODO Lv 3: 닉네임 중복을 확인하고 플레이어를 저장합니다.
        //throw new UnsupportedOperationException("Lv 3: 플레이어 등록을 구현하세요.");

        if(playerRepository.existsByNickname(request.getNickname()))
        {
            throw new ConflictException("DUPLICATE_NICKNAME");
        }

        savePlayer(new Player(request.getNickname()));
    }

    private void savePlayer(Player player) {
        try {
            playerRepository.saveAndFlush(player);
        } catch (org.springframework.dao.DataIntegrityViolationException failure) {
            throw new ConflictException("DUPLICATE_NICKNAME");
        }
    }
}
