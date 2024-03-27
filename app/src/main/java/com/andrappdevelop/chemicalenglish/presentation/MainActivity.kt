package com.andrappdevelop.chemicalenglish.presentation

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.andrappdevelop.chemicalenglish.R
import com.andrappdevelop.chemicalenglish.core.App

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var answer: String
    private lateinit var view: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = (application as App).viewModel

        val englishWordTextView: TextView = findViewById(R.id.englishWordTextView)
        val answerOneTextView: Button = findViewById(R.id.answerOneTextView)
        val answerTwoTextView: Button = findViewById(R.id.answerTwoTextView)
        val answerThreeTextView: Button = findViewById(R.id.answerThreeTextView)
        val answerFourTextView: Button = findViewById(R.id.answerFourTextView)
//        val progressBar: ProgressBar
        val checkButton: Button = findViewById(R.id.checkButton)
        val nextButton: Button = findViewById(R.id.nextButton)

        nextButton.setOnClickListener {
            viewModel.load()
        }

        answerOneTextView.setOnClickListener {
            answer = answerOneTextView.text.toString()
            view = it
            viewModel.changeColor(it)
        }

        answerTwoTextView.setOnClickListener {
            answer = answerTwoTextView.text.toString()
            view = it
            viewModel.changeColor(it)
        }

        answerThreeTextView.setOnClickListener {
            answer = answerThreeTextView.text.toString()
            view = it
            viewModel.changeColor(it)
        }

        answerFourTextView.setOnClickListener {
            answer = answerFourTextView.text.toString()
            view = it
            viewModel.changeColor(it)
        }

        checkButton.setOnClickListener {
            val bool = viewModel.checkAnswer(answer)
            nextButton.isEnabled = bool
            if (bool)
                viewModel.setGreenColor(view)
        }

        viewModel.liveData().observe(this) {
            it.show(
                englishWordTextView,
                answerOneTextView,
                answerTwoTextView,
                answerThreeTextView,
                answerFourTextView,
                checkButton,
                nextButton
            )
        }
    }
}