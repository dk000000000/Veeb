package com.example.android.common.morsecoder;

import java.util.List;
import java.util.ArrayList;

public class MorseCodeCharacterGetter {

    private List<MorseCodeCharacter> morseCodeCharacters;

    public MorseCodeCharacterGetter() {
        morseCodeCharacters = new ArrayList(){
            {
            add(new MorseCodeCharacter("A",".-"));
            add(new MorseCodeCharacter("B","-..."));
            add(new MorseCodeCharacter("C","-.-"));
            add(new MorseCodeCharacter("D","-.."));
            add(new MorseCodeCharacter("E","."));
            add(new MorseCodeCharacter("F","..-."));
            add(new MorseCodeCharacter("G","--."));
            add(new MorseCodeCharacter("H","...."));
            add(new MorseCodeCharacter("I",".."));
            add(new MorseCodeCharacter("J",".---"));
            add(new MorseCodeCharacter("K","-.-"));
            add(new MorseCodeCharacter("L",".-.."));
            add(new MorseCodeCharacter("M","--"));
            add(new MorseCodeCharacter("N","-."));
            add(new MorseCodeCharacter("O","---"));
            add(new MorseCodeCharacter("P",".--."));
            add(new MorseCodeCharacter("Q","--.-"));
            add(new MorseCodeCharacter("R",".-."));
            add(new MorseCodeCharacter("S","..."));
            add(new MorseCodeCharacter("T","-"));
            add(new MorseCodeCharacter("U","..-"));
            add(new MorseCodeCharacter("V","...-"));
            add(new MorseCodeCharacter("W",".--"));
            add(new MorseCodeCharacter("X","-..-"));
            add(new MorseCodeCharacter("Y","-.--"));
            add(new MorseCodeCharacter("Z","--.."));
        }
        };
    }

    public String getCodeForLetter(String letter) {
        for(MorseCodeCharacter mc : morseCodeCharacters) {
            if(mc.getLetter().equalsIgnoreCase(letter)) {
                return mc.getCode();
            }
        }

        return Constants.ERROR_STRING;
    }

    public String getLetterForCode(String code) {
        for(MorseCodeCharacter mc : morseCodeCharacters) {
            if(mc.getCode().equalsIgnoreCase(code)) {
                return mc.getLetter();
            }
        }

        return Constants.ERROR_STRING;
    }
}