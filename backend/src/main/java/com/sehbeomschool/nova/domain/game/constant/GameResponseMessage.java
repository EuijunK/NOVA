package com.sehbeomschool.nova.domain.game.constant;

public enum GameResponseMessage {
    GAME_START_SUCCESS("게임 시작 완료"),
    MARRY_SUCCESS("결혼 완료");

    private final String message;

    GameResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
