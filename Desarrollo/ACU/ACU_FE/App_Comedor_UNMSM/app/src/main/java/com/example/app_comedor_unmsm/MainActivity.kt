package com.example.app_comedor_unmsm

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toggle = ActionBarDrawerToggle(this, drawerLayoutMain, R.string.open_drawer, R.string.close_drawer)
        drawerLayoutMain.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayShowHomeEnabled(true)

        nav_view.setNavigationItemSelectedListener {
            when(it.itemId)
            {
                R.id.nav_home->
                {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainerView, HomeFragment())
                        commit()
                    }
                }

                R.id.nav_menu_semanal->
                {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainerView, MenuSemanalFragment())
                        commit()
                    }
                }

                R.id.nav_bugs->
                {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainerView, ErrorFragment())
                        commit()
                    }
                }
            }
            drawerLayoutMain.closeDrawer(GravityCompat.START)

            true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       if(toggle.onOptionsItemSelected(item)) { return true }
        return super.onOptionsItemSelected(item)
    }


}