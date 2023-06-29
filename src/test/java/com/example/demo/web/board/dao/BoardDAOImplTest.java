package com.example.demo.web.board.dao;

import com.example.demo.web.board.exception.NotBoardFoundException;
import com.example.demo.web.board.paging.BoardModelCond;
import com.example.demo.web.model.BoardModel;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@Slf4j
@Transactional
class BoardDAOImplTest {

    @Autowired BoardDAO boardDAO;

    BoardModel boardModel1;
    BoardModel boardModel2;
    BoardModel boardModel3;

    @BeforeEach
    void beforeEach(){
        boardModel1 = new BoardModel("testTitle1","context","tester");
        boardModel2 = new BoardModel("testTitle2","context","tester");
        boardModel3 = new BoardModel("testTitle3","context","tester");
        boardDAO.save(boardModel1);
        boardDAO.save(boardModel2);
        boardDAO.save(boardModel3);
    }

    @Test
    public void saveTest(){
        //given
        BoardModel boardModel = new BoardModel("testTitle","context","tester");

        //when
        int savedId = boardDAO.save(boardModel);
        log.info("savedId={}",savedId);
        BoardModel findBoardModel = boardDAO.findById(boardModel.getBoardNo()).orElseThrow(NotBoardFoundException::new);
        log.info("findBoardModel={}",findBoardModel);

        //then
        assertThat(boardModel.getTitle()).isEqualTo(findBoardModel.getTitle());

    }

    @Test
    public void findTest() throws Exception{
        BoardModel findBoardModel = boardDAO.findById(boardModel1.getBoardNo()).orElseThrow(NotBoardFoundException::new);
        assertThat(findBoardModel.getTitle()).isEqualTo("testTitle1");
    }

    @Test
    public void deleteTest() throws Exception{
        //given
        BoardModel delTest = new BoardModel("delTestTitle","context","tester");
        boardDAO.save(delTest);//

        //when
        boardDAO.delete(delTest.getBoardNo());

        //then
        assertThatThrownBy(()->boardDAO.findById(delTest.getBoardNo()).orElseThrow(NotBoardFoundException::new)).isInstanceOf(NotBoardFoundException.class);
    }

    @Test
    public void findAllTest() throws Exception{
        //given
        BoardModel boardModel = new BoardModel("selTestTitle", "context", "tester");
        boardDAO.save(boardModel);

        //when
        List<BoardModel> findAll = boardDAO.findAll(new BoardModelCond());

        List<BoardModel> findAllSearch = boardDAO.findAll(new BoardModelCond("1",null));
        //then
        /*전체조회*/
        assertThat(findAll.size()).isEqualTo(4);
        assertThat(findAll).contains(boardDAO.findById(boardModel.getBoardNo()).get());
        /*검색*/
        assertThat(findAllSearch.size()).isEqualTo(1);
        assertThat(findAllSearch).contains(boardDAO.findById(boardModel1.getBoardNo()).get());

    }


}