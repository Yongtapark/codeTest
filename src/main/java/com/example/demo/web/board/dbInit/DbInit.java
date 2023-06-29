package com.example.demo.web.board.dbInit;

import com.example.demo.web.board.dao.BoardDAO;
import com.example.demo.web.model.BoardModel;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@RequiredArgsConstructor
@Profile("!test")
public class DbInit {
    private final InitService initService;
    @PostConstruct
    public void init(){
        initService.dbInIt1();
    }

    @PreDestroy
    public void clean(){
        initService.clean();
    }
    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService{
        private final BoardDAO boardDAO;




    public void dbInIt1(){
        for(int i=0;i<100;i++){
            boardDAO.save(new BoardModel("testTitle","testContent","test"));
        }

    }

    public void clean(){
        boardDAO.deleteAll();
    }
    }

}
