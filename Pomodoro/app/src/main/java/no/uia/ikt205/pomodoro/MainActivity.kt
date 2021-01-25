package no.uia.ikt205.pomodoro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import no.uia.ikt205.pomodoro.util.millisecondsToDescriptiveTime

class MainActivity : AppCompatActivity() {

    lateinit var timer:CountDownTimer
    lateinit var startButton:Button
    lateinit var coutdownDisplay:TextView
    lateinit var startButton30:Button
    lateinit var startButton60:Button
    lateinit var startButton90:Button
    lateinit var startButton120:Button

    var timeToCountDownInMs = 5000L
    val timeTicks = 1000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       startButton = findViewById<Button>(R.id.startCountdownButton)
       startButton.setOnClickListener(){
           startCountDown(it)


       }
       startButton30= findViewById<Button>(R.id.startCountdownButton30)
        startButton30.setOnClickListener(){
            timeToCountDownInMs = 30000L

        }
       startButton60= findViewById<Button>(R.id.startCountdownButton60)
        startButton60.setOnClickListener(){
            timeToCountDownInMs = 60000L

        }
       startButton90= findViewById<Button>(R.id.startCountdownButton90)
        startButton90.setOnClickListener(){
            timeToCountDownInMs = 900000L

        }
       startButton120= findViewById<Button>(R.id.startCountdownButton120)
        startButton120.setOnClickListener(){
            timeToCountDownInMs = 120000L

        }

        coutdownDisplay = findViewById<TextView>(R.id.countDownView)

    }

    fun startCountDown(v: View){

        timer = object : CountDownTimer(timeToCountDownInMs,timeTicks) {
            override fun onFinish() {
                Toast.makeText(this@MainActivity,"Arbeidsøkt er ferdig", Toast.LENGTH_SHORT).show()
            }

            override fun onTick(millisUntilFinished: Long) {
               updateCountDownDisplay(millisUntilFinished)
            }

        }

        timer.start()
    }

    fun updateCountDownDisplay(timeInMs:Long){
        coutdownDisplay.text = millisecondsToDescriptiveTime(timeInMs)
    }
    fun cancelTimer(timeInMs: Long){
        if(timeInMs >= 0){
        timer.cancel()
        }
    }


}