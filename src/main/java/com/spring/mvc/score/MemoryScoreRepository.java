package com.spring.mvc.score;

import java.util.List;

public class MemoryScoreRepository implements ScoreRepository {
    @Override
    public boolean save(Score score) {
        return false;
    }

    @Override
    public List<Score> findAll() {
        return null;
    }

    @Override
    public Score findOne(int stuNum) {
        return null;
    }

    @Override
    public boolean remove(int stuNum) {
        return false;
    }
}
