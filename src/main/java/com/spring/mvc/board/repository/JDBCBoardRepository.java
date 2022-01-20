package com.spring.mvc.board.repository;

import com.spring.mvc.board.domain.Board;
import com.spring.mvc.score.Score;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository("jbr")
public class JDBCBoardRepository implements BoardRepository {

    //DB접속정보 설정
    private String uid = "java01";
    private String upw = "1234";
    private String url = "jdbc:oracle:thin:@localhost:1521:xe"; //데이터베이스가 어디있는지 주소
    private String driverName = "oracle.jdbc.driver.OracleDriver";

    @Override
    public List<Board> getArticles() {

        List<Board> boardList = new ArrayList<>();

        try {
            Class.forName(driverName);
            Connection conn = DriverManager.getConnection(url, uid, upw);

            String sql = "SELECT * FROM board ORDER BY board_no DESC"; //내림차 : 큰게 위로 안쓰면 ASC 오름차
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                boardList.add(new Board(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return boardList;

    }

    @Override
    public boolean insertArticle(Board article) {
        try {
            Class.forName(driverName);
            Connection conn = DriverManager.getConnection(url, uid, upw);

            String sql = "INSERT INTO board (board_no,writer,title,content) VALUES (seq_board.nextval, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, article.getWriter());
            pstmt.setString(2, article.getTitle());
            pstmt.setString(3, article.getContent());


            int result = pstmt.executeUpdate(); // 성공한 쿼리의 수 리턴
            if (result == 1) System.out.println("입력 성공!");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteArticle(int boardNo) {
        try {

            Class.forName(driverName);

            Connection conn = DriverManager.getConnection(url, uid, upw);


            String sql = "DELETE FROM board WHERE board_no = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);


            pstmt.setInt(1, boardNo);


            int result = pstmt.executeUpdate(); // 성공한 쿼리의 수 리턴
            if (result == 1) System.out.println("삭제 성공!");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public Board getContent(int boardNo) {

        try {
            Class.forName(driverName);
            Connection conn = DriverManager.getConnection(url, uid, upw);

            String sql = "SELECT * FROM board WHERE board_no = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, boardNo);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) { //마우스 커서 이동 (행 커서)
                return new Board(rs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }


    @Override
    public boolean modifyArticle(Board article) {
        try {

            Class.forName(driverName);

            Connection conn = DriverManager.getConnection(url, uid, upw);


            String sql = "UPDATE board " +
                    "SET writer = ?, title = ?, content = ? " +
                    "WHERE board_no =?";
            PreparedStatement pstmt = conn.prepareStatement(sql);


            pstmt.setString(1, article.getWriter());
            pstmt.setString(2, article.getTitle());
            pstmt.setString(3, article.getContent());
            pstmt.setInt(4, article.getBoardNo());

            int result = pstmt.executeUpdate(); // 성공한 쿼리의 수 리턴
            if (result == 1) System.out.println("수정 성공!");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    //조회수 상승 처리
    @Override
    public void upViewCount(int boardNo) {

        try {

            Class.forName(driverName);

            Connection conn = DriverManager.getConnection(url, uid, upw);


            String sql = "UPDATE board " +
                    "SET view_cnt = view_cnt + 1 " +
                    "WHERE board_no =?";
            PreparedStatement pstmt = conn.prepareStatement(sql);


            pstmt.setInt(1, boardNo);


            int result = pstmt.executeUpdate(); // 성공한 쿼리의 수 리턴
            if (result == 1) System.out.println("수정 성공!");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

