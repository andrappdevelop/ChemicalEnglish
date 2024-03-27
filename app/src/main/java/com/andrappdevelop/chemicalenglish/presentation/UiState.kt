package com.andrappdevelop.chemicalenglish.presentation

import android.view.View
import android.widget.Button
import android.widget.TextView

interface UiState {

    fun show(
        englishWordTextView: TextView,
        answerOneTextView: Button,
        answerTwoTextView: Button,
        answerThreeTextView: Button,
        answerFourTextView: Button,
//        progressBar: ProgressBar,
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
//            progressBar: ProgressBar,
            checkButton: Button,
            nextButton: Button
        ) {
            englishWordTextView.visibility = View.INVISIBLE
            answerOneTextView.visibility = View.INVISIBLE
            answerTwoTextView.visibility = View.INVISIBLE
            answerThreeTextView.visibility = View.INVISIBLE
            answerFourTextView.visibility = View.INVISIBLE
//            progressBar.visibility = View.VISIBLE
            checkButton.isEnabled = false
            nextButton.isEnabled = true
        }
    }

    data class ShowData(
        private val englishWord: String,
        private val russianWord: String,
        private val fakeRussianWordOne: String,
        private val fakeRussianWordTwo: String,
        private val fakeRussianWordThree: String,
    ) : UiState {
        override fun show(
            englishWordTextView: TextView,
            answerOneTextView: Button,
            answerTwoTextView: Button,
            answerThreeTextView: Button,
            answerFourTextView: Button,
//            progressBar: ProgressBar,
            checkButton: Button,
            nextButton: Button
        ) {
            englishWordTextView.visibility = View.VISIBLE
            englishWordTextView.text = englishWord
            answerOneTextView.visibility = View.VISIBLE
            answerOneTextView.text = russianWord
            answerTwoTextView.visibility = View.VISIBLE
            answerTwoTextView.text = fakeRussianWordOne
            answerThreeTextView.visibility = View.VISIBLE
            answerThreeTextView.text = fakeRussianWordTwo
            answerFourTextView.visibility = View.VISIBLE
            answerFourTextView.text = fakeRussianWordThree
//            progressBar.visibility = View.INVISIBLE
            checkButton.isEnabled = true
            nextButton.isEnabled = true
        }
    }
}