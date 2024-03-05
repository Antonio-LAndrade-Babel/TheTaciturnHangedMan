package com.taciturn.services;

import com.taciturn.hangedman.TheHangedMan;

public interface HangedService {
    void startHanged();
    void processTry(char tryChar);
    boolean isFinished();
    boolean isWon();
    TheHangedMan getHangedState();
}
