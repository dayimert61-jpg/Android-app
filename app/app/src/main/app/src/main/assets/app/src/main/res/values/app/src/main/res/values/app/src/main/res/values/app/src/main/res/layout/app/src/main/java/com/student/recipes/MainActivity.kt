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
            val inputStream: InputStream = assets.open("recipes.json")
            val jsonString = inputStream.bufferedReader().use { it.readText() }
            val jsonArray = JSONArray(jsonString)

            val builder = StringBuilder()
            for (i in 0 until jsonArray.length()) {
                val obj = jsonArray.getJSONObject(i)
                val name = obj.optString("name", "No name")
                val category = obj.optString("category", "No category")
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
            e.printStackTrace()
            tvContent.text = "Error loading recipes: ${e.message}"
        }
    }
}
