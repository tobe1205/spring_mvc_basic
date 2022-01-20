package com.spring.mvc.board.repository;

import com.spring.mvc.board.domain.Board;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("mbr")
public class MemoryBoardRepository implements BoardRepository {

    private static Map<Integer, Board> boardMap = new HashMap<>();

    static {
        boardMap.put(1, new Board( "김철수", "안녕하심까.,,", "저는 김철수이올시다,,, 반갑습니다."));
        boardMap.put(2, new Board( "박영희", "무서운 꿈을 꾸었습니다", "람쥐"));
        boardMap.put(3, new Board( "고길동", "내집에서 나가", "파렴치한 둘리놈"));
    }

    @Override
    public List<Board> getArticles() {
        List<Board> articles = new ArrayList<>();
        for (int boardNo : boardMap.keySet()) {
            Board board = boardMap.get(boardNo);
            articles.add(board);
        }
        return articles;
    }

    @Override
    public boolean insertArticle(Board article) {
        boardMap.put(article.getBoardNo(), article);
        return false;
    }

    @Override
    public boolean deleteArticle(int boardNo) {
        boardMap.remove(boardNo);
        return false;
    }

    @Override
    public Board getContent(int boardNo) {
        return boardMap.get(boardNo);
    }

    @Override
    public boolean modifyArticle(Board article) {
        int boardNo = article.getBoardNo();
        if (boardMap.containsKey(boardNo))
            boardMap.put(boardNo, article); //수정
        return false;
    }

}