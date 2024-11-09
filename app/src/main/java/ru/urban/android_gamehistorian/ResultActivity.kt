package ru.urban.android_gamehistorian

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {

    private lateinit var finalScoreTV: TextView
    private lateinit var descriptionTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setSupportActionBar(findViewById(R.id.toolbarMain))

        finalScoreTV = findViewById(R.id.finalScoreTV)
        descriptionTV = findViewById(R.id.descriptionTV)

        val finalScore = intent.getIntExtra("score",0)

        finalScoreTV.text = "Ты набрал $finalScore баллов"

        descriptionTV.text = when(finalScore){
            0 -> "Беда!!! Нужно срочно учить историю России!!!"
            100 -> "Плохо! Пора взяться за учебник истории..."
            200 -> "Плохо! Пора подучить историю России."
            300 -> "Неплохо! Но всё-таки нужно повторить пробелы."
            400 -> "Хороший результат! Ты знаешь историю России"
            500 -> "Идеально!!! Ты просто гуру!!!"
            else -> "Ошибка"
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){

            R.id.exitMainMenu -> {
                Toast.makeText(
                    applicationContext,
                    "Приложение закрыто",
                    Toast.LENGTH_LONG
                ).show()
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}