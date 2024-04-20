package com.example.homew2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText input;
    private Button button;
    private TextView output;
    private int listSize;
    private List<Integer> arrayList = new ArrayList<>();
    private List<Integer> linkedList = new LinkedList<>();
    private long timeOne, timeTwo, timeThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = findViewById(R.id.input);
        button = findViewById(R.id.button);
        output = findViewById(R.id.output);
        button.setOnClickListener(listener);
        button.setOnClickListener(listenerHomework);
    }
    private View.OnClickListener listenerHomework = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                listSize = Integer.parseInt(input.getText().toString());
            } catch (NumberFormatException numberFormatException) {
                Toast.makeText(MainActivity.this, "Необходимо ввести размер списков в виде числа", Toast.LENGTH_SHORT).show();
            }
            timeOne = SystemClock.uptimeMillis();
            arrayList = addlist(arrayList);
            timeTwo = SystemClock.uptimeMillis();
            linkedList = addlist(linkedList);
            timeThree = SystemClock.uptimeMillis();
            output.setText("Время заполнения ArrayList " + (timeTwo - timeOne) + "мс"
                    + "\nВремя заполнения LinkedList" + (timeThree - timeTwo) + "мс");

            timeOne = SystemClock.uptimeMillis();
            arrayList.remove(1);
            timeTwo = SystemClock.uptimeMillis();
            arrayList.remove(1);
            timeThree = SystemClock.uptimeMillis();

            output.append("\n\nВремя добавления элеметов:\nВ начало ArrayList " + (timeTwo -timeOne) + " мс "
                    + "\nВ начало LinkedList " + (timeThree - timeTwo) + " мс ");

            timeOne = SystemClock.uptimeMillis();
            arrayList.remove(listSize/2);
            timeTwo = SystemClock.uptimeMillis();
            arrayList.remove(listSize/2);
            timeThree = SystemClock.uptimeMillis();

            output.append("\nВ середину ArrayList " + (timeTwo - timeOne) + " мс "
                    + "\nВ середину LinkedList " + (timeThree - timeTwo) + " мс ");

            timeOne = SystemClock.uptimeMillis();
            arrayList.add(listSize);
            timeTwo = SystemClock.uptimeMillis();
            arrayList.add(listSize);
            timeThree = SystemClock.uptimeMillis();

            output.append("\nВ конец ArrayList " + (timeTwo - timeOne) + " мс "
                    + "\nВ конец LinkedList " + (timeThree - timeTwo) + " мс ");

        }
    };
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            try {
                listSize = Integer.parseInt(input.getText().toString());
            } catch (NumberFormatException numberFormatException) {
                Toast.makeText(MainActivity.this, "Необходимо ввести размер списков в виде числа", Toast.LENGTH_SHORT).show();
            }

            timeOne = SystemClock.uptimeMillis();
            arrayList = addlist(arrayList);
            timeTwo = SystemClock.uptimeMillis();
            linkedList = addlist(linkedList);
            timeThree = SystemClock.uptimeMillis();
            output.setText("Время заполнения ArrayList " + (timeTwo - timeOne) + "мс"
                    + "\nВремя заполнения LinkedList" + (timeThree - timeTwo) + "мс");

            timeOne = SystemClock.uptimeMillis();
            arrayList.remove(1);
            timeTwo = SystemClock.uptimeMillis();
            arrayList.remove(1);
            timeThree = SystemClock.uptimeMillis();

            output.append("\n\nВремя добавления элеметов:\nВ начало ArrayList " + (timeTwo -timeOne) + " мс "
            + "\nВ начало LinkedList " + (timeThree - timeTwo) + " мс ");

            timeOne = SystemClock.uptimeMillis();
            arrayList.remove(listSize/2);
            timeTwo = SystemClock.uptimeMillis();
            arrayList.remove(listSize/2);
            timeThree = SystemClock.uptimeMillis();

            output.append("\nВ середину ArrayList " + (timeTwo - timeOne) + " мс "
                    + "\nВ середину LinkedList " + (timeThree - timeTwo) + " мс ");

            timeOne = SystemClock.uptimeMillis();
            arrayList.add(listSize);
            timeTwo = SystemClock.uptimeMillis();
            arrayList.add(listSize);
            timeThree = SystemClock.uptimeMillis();

            output.append("\nВ конец ArrayList " + (timeTwo - timeOne) + " мс "
                    + "\nВ конец LinkedList " + (timeThree - timeTwo) + " мс ");


        }
    };
    private List<Integer> addlist(List<Integer> list){
        int integerBefore = 0;
        int integerAfter = 1;
        int integer;
        list.add(integerBefore);
        list.add(integerAfter);
        for (int i = 3; i <= listSize; i++){
            integer = integerBefore + integerAfter;
            list.add(integer);
            integerBefore = integerAfter;
            integerAfter = integer;
        }
        return list;
    }
    private List<Integer> addListHomework(List<Integer> list) {
        int integer = 0;
        list.add(integer);
        for (int i = 3; i < listSize; i++){
            integer +=10;
            list.add(integer);
        }
        return list;
    }
}