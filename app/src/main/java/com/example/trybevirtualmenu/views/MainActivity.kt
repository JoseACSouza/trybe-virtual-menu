package com.example.trybevirtualmenu.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trybevirtualmenu.R
import com.example.trybevirtualmenu.adapters.PratoAdapter
import com.example.trybevirtualmenu.models.Prato

class MainActivity : AppCompatActivity() {

    private val listaDePratos: RecyclerView by lazy { findViewById(R.id.main_menu) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Pratos = listOf<Prato>(
            Prato(getString(R.string.name_prato_1),
                R.drawable.prato_01
            ),
            Prato(getString(R.string.name_prato_2),
            R.drawable.prato_02,
            ),
            Prato(getString(R.string.name_prato_3),
                R.drawable.prato_03,
            ),
            Prato(getString(R.string.name_prato_4),
                R.drawable.prato_04,
            ),
            Prato(getString(R.string.name_prato_5),
                R.drawable.prato_05,
            ),
            Prato(getString(R.string.name_prato_6),
                R.drawable.bebida_01,
            )
        )

        listaDePratos.layoutManager = LinearLayoutManager(this)
        listaDePratos.adapter = PratoAdapter(Pratos)
    }
}
