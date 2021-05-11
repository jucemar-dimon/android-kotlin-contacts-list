package br.com.jucemar_dimon.contacts_list

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class DetailActivity : AppCompatActivity() {
    private var contact:Contact? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contact_detail)
        initToolbar()
        getExtras()
        bindViews()

    }

    private fun getExtras() {
        contact=intent.getParcelableExtra(EXTRA_CONTACT)
    }

    private fun initToolbar(){
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun bindViews(){
        findViewById<TextView>(R.id.name_detail).text=contact?.name
        findViewById<TextView>(R.id.phone_detail).text=contact?.phone
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }


    companion object{
        const val EXTRA_CONTACT:String="EXTRA_CONTACT"
    }
}