package com.andrappdevelop.chemicalenglish.presentation

import android.view.View
import android.widget.Button
import android.widget.TextView
import com.andrappdevelop.chemicalenglish.domain.SimpleResponse

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
        private val questionWord: SimpleResponse,
        private val answerWordOne: SimpleResponse,
        private val answerWordTwo: SimpleResponse,
        private val answerWordThree: SimpleResponse
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
            englishWordTextView.text = questionWord.englishWord
            answerOneTextView.visibility = View.VISIBLE
            answerOneTextView.text = questionWord.russianWord
            answerTwoTextView.visibility = View.VISIBLE
            answerTwoTextView.text = answerWordOne.russianWord
            answerThreeTextView.visibility = View.VISIBLE
            answerThreeTextView.text = answerWordTwo.russianWord
            answerFourTextView.visibility = View.VISIBLE
            answerFourTextView.text = answerWordThree.russianWord
//            progressBar.visibility = View.INVISIBLE
            checkButton.isEnabled = true
            nextButton.isEnabled = false
        }
    }
}