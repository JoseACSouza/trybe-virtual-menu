package com.example.trybevirtualmenu.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trybevirtualmenu.R
import com.example.trybevirtualmenu.adapters.PratoAdapter
import com.example.trybevirtualmenu.interfaces.OnItemClickListener
import com.example.trybevirtualmenu.models.PratosDatabase

class MainActivity : AppCompatActivity(), OnItemClickListener {

    private val listaDePratos: RecyclerView by lazy { findViewById(R.id.main_menu) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listaDePratos.layoutManager = LinearLayoutManager(this)
        val adapter = PratoAdapter(PratosDatabase.getAll())
        adapter.setOnItemClickListener(this)
        listaDePratos.adapter = adapter
    }

    override fun onItemClick(view: View, position: Int) {
        val intent = Intent(baseContext, MenuItemDetailActivity::class.java)
        intent.putExtra("prato_id", position + 1)
        startActivity(intent)
    }
}
