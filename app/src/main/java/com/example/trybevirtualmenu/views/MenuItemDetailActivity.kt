package com.example.trybevirtualmenu.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.trybevirtualmenu.R
import com.example.trybevirtualmenu.models.PratosDatabase
import com.google.android.material.button.MaterialButton
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView

class MenuItemDetailActivity : AppCompatActivity() {
    private val imageMeal : ShapeableImageView by lazy { findViewById(R.id.detail_image) }
    private val nameMeal : MaterialTextView by lazy { findViewById(R.id.detail_name) }
    private val descMeal : MaterialTextView by lazy { findViewById(R.id.detail_description) }
    private val priceMeal : MaterialTextView by lazy { findViewById(R.id.detail_price) }
    private val backButton : MaterialButton by lazy { findViewById(R.id.detail_back) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_item_detail)

        if(intent !== null){
            val mealId = intent.getIntExtra("prato_id", 1)

            val meal = PratosDatabase.getById(mealId)
            if(meal !== null){
                nameMeal.text = meal.name
                imageMeal.setImageResource(meal.image)
                descMeal.text = meal.description
                priceMeal.text = meal.price
            }
        }
        backButton.setOnClickListener {
            val backIntent = Intent(baseContext, MainActivity::class.java)
            startActivity(backIntent)
        }
    }
}
