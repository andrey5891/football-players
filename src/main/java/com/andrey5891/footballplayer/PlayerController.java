package com.andrey5891.footballplayer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/player")
@RestController
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerRepo playerRepo;

    @GetMapping
    public List<Player> getAll() {
        log.info("call get all");
        return playerRepo.getAll();
    }

    @GetMapping("/{id}")
    public Player getById(@PathVariable Integer id) {
        log.info("call get by id");
        return playerRepo.getById(id);
    }
}
