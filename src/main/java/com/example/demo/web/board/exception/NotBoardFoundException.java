package com.example.demo.web.board.exception;

public class NotBoardFoundException extends RuntimeException {

    public NotBoardFoundException() {
        super("게시물이 존재하지 않습니다.");
    }

    public NotBoardFoundException(String message) {
        super(message);
    }

    public NotBoardFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotBoardFoundException(Throwable cause) {
        super(cause);
    }
}
