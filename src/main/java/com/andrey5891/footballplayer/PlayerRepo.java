package com.andrey5891.footballplayer;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerRepo {

    private final JdbcClient jdbcClient;

    public List<Player> getAll() {
        return jdbcClient.sql("SELECT p.* FROM player p").query().listOfRows().stream()
                .map(e -> new Player((Integer) e.get("id"), (String) e.get("name")))
                .toList();
    }

    public Player getById(Integer id) {
        var e = jdbcClient.sql("SELECT p.* FROM player p WHERE id = ?").param(id).query().singleRow();
        return new Player((Integer) e.get("id"), (String) e.get("name"));
    }
}
