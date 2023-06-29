package com.example.demo.web.board.dao.mybatis;

import com.example.demo.web.board.dto.BoardModelUpdateDto;
import com.example.demo.web.board.utils.BoardModelCond;
import com.example.demo.web.model.BoardModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BoardModelMapper {
    int save(BoardModel boardModel);
    void update(@Param("board_no") int boardNo,@Param("updateParam") BoardModelUpdateDto boardModelUpdateDto);
    void addHits(int boardNo);

    List<BoardModel> findAll(BoardModelCond boardModelCond);

    Optional<BoardModel> findById(int boardNo);

    void delete(int boardNo);
}
