package com.spring.mvc.board.service;

import com.spring.mvc.board.domain.Board;
import com.spring.mvc.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    //글 전체 조회 중간처리
    public List<Board> getArticles() {
        List<Board> boardList = boardRepository.getArticles();

        //중간처리: 리스트의 인덱스를 전부 뒤집기
//        boardList.sort(Collections.reverseOrder());
        List<Board> sortedList = new ArrayList<>();
        for (int i = boardList.size() - 1; i >= 0 ; i--) {
            sortedList.add(boardList.get(i));
        }

        return sortedList;
    }


    //새 글 등록 중간처리
    public void insert(Board board) {
        boardRepository.insertArticle(board);
    }


    public void deleteArticle(int boardNo) {
        boardRepository.deleteArticle(boardNo);
    }

    public Board getContent(int boardNo) {

        return boardRepository.getContent(boardNo);
    }

    public void modifyArticle(Board board) {
        boardRepository.modifyArticle(board);
    }
}