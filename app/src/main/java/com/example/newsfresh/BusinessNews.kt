package com.example.newsfresh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import kotlinx.android.synthetic.main.activity_main.*

class BusinessNews : AppCompatActivity() {
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_business_news)

        //Action Bar
        val intentAboutUs = Intent(this, AboutUS::class.java)
        val intentBreakingNews = Intent(this, Health::class.java)
        val intentBusinessNews = Intent(this, BusinessNews::class.java)
        val intentIndian = Intent(this, MainActivity::class.java)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when (it.itemId){
                R.id.business -> startActivity(intentBusinessNews)
                R.id.breaking -> startActivity(intentBreakingNews)
                R.id.indian -> startActivity(intentIndian)
                R.id.about -> startActivity(intentAboutUs)
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}