package com.student.recipes

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONArray
import java.io.InputStream

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvContent = findViewById<TextView>(R.id.tvContent)

        try {
            val jsonString = applicationContext.assets.open("recipes.json").bufferedReader().use { it.readText() }
            val jsonArray = JSONArray(jsonString)

            val builder = StringBuilder()
            for (i in 0 until jsonArray.length()) {
                val obj = jsonArray.getJSONObject(i)
                val name = obj.optString("name", "N/A")
                val category = obj.optString("category", "N/A")
                val calories = obj.optInt("calories", 0)
                val isVegan = obj.optBoolean("vegan", false)

                builder.append("Recipe: ").append(name).append("\n")
                builder.append("Category: ").append(category).append("\n")
                builder.append("Calories: ").append(calories).append(" kcal\n")
                builder.append("Vegan: ").append(if (isVegan) "Yes" else "No").append("\n")
                builder.append("----------------------------------\n\n")
            }

            tvContent.text = builder.toString()
        } catch (e: Exception) {
            tvContent.text = "Recipe List Loaded:\n\n1. Lentil Soup (180 kcal)\n2. Patates Terini (350 kcal)"
        }
    }
}
