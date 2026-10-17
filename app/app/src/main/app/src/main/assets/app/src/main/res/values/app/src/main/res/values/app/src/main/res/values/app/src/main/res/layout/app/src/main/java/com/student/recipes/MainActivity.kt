package com.student.recipes

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val textView = TextView(this)
        textView.textSize = 18f
        textView.setPadding(40, 40, 40, 40)
        
        val content = """
            RECIPE APP
            ==================================

            Recipe: Lentil Soup
            Category: Soup
            Calories: 180 kcal
            Vegan: Yes
            ----------------------------------

            Recipe: Patates Terini
            Category: Main Course
            Calories: 350 kcal
            Vegan: No
            ----------------------------------
        """.trimIndent()

        textView.text = content
        setContentView(textView)
    }
}
