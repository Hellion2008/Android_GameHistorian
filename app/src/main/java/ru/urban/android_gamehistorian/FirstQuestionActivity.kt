package ru.urban.android_gamehistorian

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FirstQuestionActivity : AppCompatActivity() {

    private var score = 0
    private val point = 100
    private var countQuestion = 0
    private var maxQuestion = 5

    private val questionsDb = DataBaseQuestion()

    private lateinit var questionRG: RadioGroup
    private lateinit var firstVersionRB: RadioButton
    private lateinit var secondVersionRB: RadioButton
    private lateinit var thirdVersionRB: RadioButton

    private lateinit var questionTV: TextView

    private lateinit var answerBTN: Button

    private lateinit var scoreTV: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_first_question)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setSupportActionBar(findViewById(R.id.toolbarMain))

        questionRG = findViewById(R.id.questionRG)
        firstVersionRB = findViewById(R.id.firstVersionRB)
        secondVersionRB = findViewById(R.id.secondVersionRB)
        thirdVersionRB = findViewById(R.id.thirdVersionRB)

        questionTV = findViewById(R.id.questionTV)
        answerBTN = findViewById(R.id.answerBTN)
        scoreTV = findViewById(R.id.scoreTV)
        changeQuestion()

        answerBTN.setOnClickListener {
            checkAnswer()
            if (countQuestion < maxQuestion)
                changeQuestion()
            else {
                val intent = Intent(this, ResultActivity::class.java)
                    .putExtra("score", score)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun changeQuestion(){
        val question = questionsDb.questions[countQuestion++]
        questionTV.text = question.textQuestion
        firstVersionRB.text = question.versions[0]
        secondVersionRB.text = question.versions[1]
        thirdVersionRB.text = question.versions[2]
        scoreTV.setText("Количество баллов: $score")

    }

    private fun checkAnswer(){
        var id = questionRG.checkedRadioButtonId
        val radioButton: RadioButton = findViewById(id)
        if (radioButton.text == questionsDb.questions[countQuestion - 1].answer){
            score += point
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