package com.andrappdevelop.chemicalenglish.presentation

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

interface UiState {

    fun show(
        englishWordTextView: TextView,
        answerOneTextView: Button,
        answerTwoTextView: Button,
        answerThreeTextView: Button,
        answerFourTextView: Button,
        progressBar: ProgressBar,
        checkButton: Button,
        nextButton: Button
    )

    object ShowProgress : UiState {
        override fun show(
            englishWordTextView: TextView,
            answerOneTextView: Button,
            answerTwoTextView: Button,
            answerThreeTextView: Button,
            answerFourTextView: Button,
            progressBar: ProgressBar,
            checkButton: Button,
            nextButton: Button
        ) {
            englishWordTextView.visibility = View.INVISIBLE
            answerOneTextView.visibility = View.INVISIBLE
            answerTwoTextView.visibility = View.INVISIBLE
            answerThreeTextView.visibility = View.INVISIBLE
            answerFourTextView.visibility = View.INVISIBLE
            progressBar.visibility = View.VISIBLE
            checkButton.isEnabled = false
            nextButton.isEnabled = true
        }
    }

    data class ShowData(private val result: String) : UiState {
        override fun show(
            englishWordTextView: TextView,
            answerOneTextView: Button,
            answerTwoTextView: Button,
            answerThreeTextView: Button,
            answerFourTextView: Button,
            progressBar: ProgressBar,
            checkButton: Button,
            nextButton: Button
        ) {
            englishWordTextView.visibility = View.VISIBLE
            englishWordTextView.text = result
            answerOneTextView.visibility = View.INVISIBLE
            answerTwoTextView.visibility = View.INVISIBLE
            answerThreeTextView.visibility = View.INVISIBLE
            answerFourTextView.visibility = View.INVISIBLE
            progressBar.visibility = View.INVISIBLE
            checkButton.isEnabled = true
            nextButton.isEnabled = true
        }
    }
}