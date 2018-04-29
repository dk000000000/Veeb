package com.example.android.bluetoothchat;

import android.content.Context;
import com.example.android.common.logger.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *  the login and scrunity mechnicsm of the main Application
 */

public class Passcode {
    Context _context;

    public Passcode(Context context){
        _context = context;
    }

    /**
     *  verify user input
     */
    public boolean verify(String passCode) {
        try {
            InputStream inputStream = _context.openFileInput("passcode.txt");
            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ((receiveString = bufferedReader.readLine()) != null) {
                    stringBuilder.append(receiveString);
                }
                inputStream.close();
                String ret = stringBuilder.toString();
                System.out.println(ret);
                return passCode.equals(ret);
            }
        } catch (FileNotFoundException e) {
            saveCode(passCode);
            System.out.println("PassCode Created");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     *  save passcode to file
     */
    public void saveCode(String newPasscode) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(_context.
                    openFileOutput("passcode.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(newPasscode);
            outputStreamWriter.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
}
