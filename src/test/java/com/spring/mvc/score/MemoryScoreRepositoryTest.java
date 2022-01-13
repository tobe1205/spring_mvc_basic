package com.spring.mvc.score;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemoryScoreRepositoryTest {

    ScoreRepository repo = new MemoryScoreRepository();

    @Test
    void repotTest(){
        repo.save(new Score("홍길동",95,70,65));
        repo.save(new Score("김영희",100,20,65));

        List<Score> scoreList = repo.findAll();
        for (Score s : scoreList) {
            System.out.println("s = " + s);
        }

    }

}