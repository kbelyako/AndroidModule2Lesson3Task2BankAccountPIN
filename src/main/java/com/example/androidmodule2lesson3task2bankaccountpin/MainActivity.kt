package com.example.androidmodule2lesson3task2bankaccountpin
/*
ДЗ. Задание 2. Среднее
Главная активити – с данными о банковской карте: имя, фамилия, возраст, id-номер клиента.
Вторая активити – с рекламой. Просто вставьте в нее любую большую картинку.
При входе в главную активити запрашивается PIN код. Нужно сделать так, чтобы он
запрашивался и при открытии приложения и при возврате с активити с рекламой. И был
незаполненным, если вы возвращаетесь из рекламной активити.
 */

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var PIN="4545"
        var enteredPIN=""

        btPIN_OK.setOnClickListener() {
           enteredPIN=etPIN.text.toString()
            if(enteredPIN.equals(PIN)){
                clBankAccountInfo.setVisibility(View.VISIBLE)
                clPIN.setVisibility(View.INVISIBLE)
                if (tvPIN.text=="WRONG PIN!!!"){
                    tvPIN.text="enter PIN"
                }
            }
            else {tvPIN.text="WRONG PIN!!!"}
        }

     btAdd.setOnClickListener() {
         val intent = Intent(this,AdvertisingActivity::class.java)
         startActivity(intent)
     }
    }

    override fun onStart() {
        super.onStart()
        Log.d("MyLOG", "activity started")
        clBankAccountInfo.setVisibility(View.INVISIBLE)
        etPIN.getText().clear()
        clPIN.setVisibility(View.VISIBLE)
    }
    override fun onResume() {
        super.onResume()
        Log.d("MyLOG", "activity resumed")
    }
    override fun onPause() {
        super.onPause()
        Log.d("MyLOG", "activity paused")
    }
    override fun onStop() {
        super.onStop()
        Log.d("MyLOG", "activity stopped")
    }
    override fun onRestart() {
        super.onRestart()
        Log.d("MyLOG", "activity restarted")
    }
}