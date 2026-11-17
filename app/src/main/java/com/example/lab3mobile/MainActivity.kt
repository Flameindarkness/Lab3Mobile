package com.example.lab3mobile

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab3mobile.data.TipsDataSource
import com.example.lab3mobile.ui.TipsAdapter

/**
 * Главный экран: список из 30 советов
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val safeArea = insets.getInsets(
                WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout()
            )
            v.setPadding(safeArea.left, safeArea.top, safeArea.right, safeArea.bottom)
            insets
        }

        val tipsList: RecyclerView = findViewById(R.id.tips_list)
        // Число колонок зависит от экрана: 1 на телефоне, 2–3 в альбомной ориентации и на планшете
        tipsList.layoutManager = GridLayoutManager(this, resources.getInteger(R.integer.tip_columns))
        tipsList.adapter = TipsAdapter(TipsDataSource.tips) { tip ->
            startActivity(TipDetailActivity.newIntent(this, tip.day))
        }
    }
}
