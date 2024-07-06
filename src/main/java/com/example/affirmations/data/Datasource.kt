package com.example.affirmations.data

import com.example.affirmations.R
import com.example.affirmations.model.Affirmation
class Datasource() {
    fun loadAffirmations(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(R.string.affirmation1, R.drawable.fit_1),
            Affirmation(R.string.affirmation2, R.drawable.fit_2),
            Affirmation(R.string.affirmation3, R.drawable.fit_3),
            Affirmation(R.string.affirmation4, R.drawable.fit_4),
            Affirmation(R.string.affirmation5, R.drawable.fit_5),
            Affirmation(R.string.affirmation6, R.drawable.fit_6),
            Affirmation(R.string.affirmation7, R.drawable.fit_7),
            Affirmation(R.string.affirmation8, R.drawable.fit_8),
            Affirmation(R.string.affirmation9, R.drawable.fit_9),
            Affirmation(R.string.affirmation10, R.drawable.fit_10))
    }
}
