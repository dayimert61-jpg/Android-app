package com.student.recipes

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvContent = findViewById<TextView>(R.id.tvContent)

        val recipeData = """
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

        tvContent.text = recipeData
    }
}
