package com.taciturn.services;

import org.springframework.stereotype.Service;

import com.taciturn.hangedman.TheHangedMan;

import java.util.Random;

@Service
public class HangedServiceImpl implements HangedService {
    private TheHangedMan hangedMan;
    private final String[] words = {"zapato", "fantasía", "útil", "málaga", "aceituna", "pavo", "plátano", "utopía", "comando", "margarita"};

    @Override
    public void startHanged(){
        String chosenWord = words[new Random().nextInt(words.length)];
        hangedMan = new TheHangedMan(chosenWord);
    }

    @Override
    public void processTry(char tryChar){
        hangedMan.tryCharacter(tryChar);
    }

    @Override
    public boolean isFinished(){
        return hangedMan.isFinished();
    }

    @Override
    public boolean isWon(){
        return hangedMan.isWon();
    }

    @Override
    public TheHangedMan getHangedState(){
        return hangedMan;
    }
}
