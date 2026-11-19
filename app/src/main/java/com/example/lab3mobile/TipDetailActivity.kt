package com.example.lab3mobile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab3mobile.data.TipsDataSource
import com.google.android.material.appbar.MaterialToolbar

/**
 * Экран с полным описанием совета. Номер дня передаётся через Intent
 */
class TipDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tip_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val safeArea = insets.getInsets(
                WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout()
            )
            v.setPadding(safeArea.left, safeArea.top, safeArea.right, safeArea.bottom)
            insets
        }

        val toolbar: MaterialToolbar = findViewById(R.id.toolbar)
        toolbar.setNavigationOnClickListener { finish() }

        val tip = TipsDataSource.getTip(intent.getIntExtra(EXTRA_TIP_DAY, 0))
        if (tip == null) {
            finish()
            return
        }

        findViewById<ImageView>(R.id.tip_image).setImageResource(tip.imageRes)
        findViewById<TextView>(R.id.tip_day).text = getString(R.string.tip_day, tip.day)
        findViewById<TextView>(R.id.tip_title).setText(tip.titleRes)
        findViewById<TextView>(R.id.tip_full_description).setText(tip.fullDescriptionRes)
    }

    companion object {
        private const val EXTRA_TIP_DAY = "extra_tip_day"

        /**
         * Явный Intent для открытия экрана совета
         */
        fun newIntent(context: Context, day: Int): Intent =
            Intent(context, TipDetailActivity::class.java).putExtra(EXTRA_TIP_DAY, day)
    }
}
