package com.taciturn.hangedman;

import java.text.Normalizer;
import java.util.HashSet;
import java.util.Set;

public class TheHangedMan {
    private char[] progress;
    private String answer;
    private int remainingAttempts;
    private Set<Character> attempts;

    public TheHangedMan(String answer){
        this.answer = answer;
        this.progress = new char[this.answer.length()];
        java.util.Arrays.fill(this.progress, '_');
        this.remainingAttempts = 8;
        this.attempts = new HashSet<>();
    }

    public static String normalizeCharacter(String inputCharacter) {
        return Normalizer.normalize(inputCharacter, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+","").toLowerCase();
    }

    public boolean tryCharacter(char triedCharacter){
        triedCharacter = normalizeCharacter(String.valueOf(triedCharacter)).charAt(0);
        boolean success = false;
        if (attempts.add(triedCharacter)) {
            for (int i = 0; i < answer.length(); i++){
                char currentCharacter = normalizeCharacter(String.valueOf(answer)).charAt(i);

                if (currentCharacter == triedCharacter) {
                    progress[i] = triedCharacter;
                    success = true;
                }
            }
            if (!success) remainingAttempts--;
        }
        return success;
    }

    public boolean isFinished() {
        return remainingAttempts <= 0 || !new String(progress).contains("_");
    }

    public boolean isWon(){
        return !new String(progress).contains("_");
    }

    public char[] getProgress() {
        return progress;
    }

    public String getAnswer() {
        return answer;
    }

    public int getRemainingAttempts() {
        return remainingAttempts;
    }

    public Set<Character> getAttempts() {
        return attempts;
    }
}
