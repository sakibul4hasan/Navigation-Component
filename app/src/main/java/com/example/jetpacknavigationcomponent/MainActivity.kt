package com.example.jetpacknavigationcomponent

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.jetpacknavigationcomponent.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var drawer_layout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val bottom_nav_view = findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        val navigation_view = findViewById<NavigationView>(R.id.navigation_view)
        drawer_layout = findViewById(R.id.drawer_layout)
        val headerView = navigation_view.getHeaderView(0)
        val closeNavId = headerView.findViewById<ImageView>(R.id.closeNavId)
        setSupportActionBar(toolbar)


        //GET NAV CONTROLLER
        //navController = findNavController(R.id.fragmentContainerView)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        //APP BAR CONFIG
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.homeFragment, R.id.settingsFragment, R.id.notificationFragment, R.id.accountFragment),
            drawer_layout
        )

        //SETUP ACTION BAR
        setupActionBarWithNavController(navController, appBarConfiguration)
        /*toolbar.setupWithNavController(navController)*/
        //SETUP BOTTOM NAV
        bottom_nav_view.setupWithNavController(navController)
        //SETUP NAV DRAWER
        navigation_view.setupWithNavController(navController)

        closeNavId.setOnClickListener {
            drawer_layout.closeDrawer(GravityCompat.START)
        }

        /*//NAVIGATION DRAWER FULL SCREEN WITH IN STATUS BAR
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val width = displayMetrics.widthPixels
        val params = navigation_view.layoutParams as DrawerLayout.LayoutParams
        params.width = width
        navigation_view.layoutParams = params*/


    }

    //BACK OPTION CONTROL
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) or super.onSupportNavigateUp()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        //menu?.add(Menu.NONE, R.id.settingsFragment, Menu.CATEGORY_SECONDARY, "Settings")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return if (item.itemId == R.id.aboutApp) {
            //destination trans with global action
            val action = SettingGraphDirections.actionGlobalAboutAppFragment()
            navController.navigate(action)
            return true
        } else {
            //destination trans with itemId massing to destination id
            item.onNavDestinationSelected(navController) or super.onOptionsItemSelected(item)
        }

    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else super.onBackPressed()
    }

}