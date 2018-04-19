package com.example.android.common.morsecoder;
import java.util.*;

public class Decoder {
    private ArrayList<Long> morseDecodedTextBuffer;

    public Decoder() {

    }

    public long[] decode(String morseEncodedText) {
        morseDecodedTextBuffer = new ArrayList<Long>();
        String[] splittedMorseCode = morseEncodedText.split("//");
        morseDecodedTextBuffer.add(0L);
        for(int wordCounter = 0; wordCounter < splittedMorseCode.length; wordCounter++) {
            String word = splittedMorseCode[wordCounter];
            String[] letters = word.split("/");

            for(int letterCounter = 0; letterCounter < letters.length; letterCounter++)
            {   
                for(int dots = 0; dots< letters[letterCounter].length();dots++){
                if(letters[letterCounter].charAt(dots)=='-'){
                    morseDecodedTextBuffer.add(100L);
                }
                else{
                    morseDecodedTextBuffer.add(30L);
          
                 }
                 
                 if(dots==letters[letterCounter].length()-1){
                     morseDecodedTextBuffer.add(200L);
                    }
                    else{
                    morseDecodedTextBuffer.add(100L);}
              }
                
            }
            

        }
        Long[] objLong = morseDecodedTextBuffer.toArray(new Long[morseDecodedTextBuffer.size()]);
        long[] primLong = new long[objLong.length];

        for(int index = 0; index < objLong.length; index++)
        {
            primLong[index] = objLong[index];
        }

        return primLong;
    }
}