package com.demo;

/**
 * 备份者2--备份整个的话备份的是对象的引用,并不能达到备份的效果
 */
public class GamePlayerBackup2 {
    private GamePlayer gamePlayer;

    public GamePlayerBackup2(GamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    public GamePlayer getGamePlayer() {
        return gamePlayer;
    }

    public void setGamePlayer(GamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }
}
