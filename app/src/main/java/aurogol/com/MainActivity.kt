package aurogol.com

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import aurogol.com.PreferenceHelper.get
import aurogol.com.PreferenceHelper.set
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    private val snackBar by lazy {
        Snackbar.make(mainLayout, R.string.press_back_again, Snackbar.LENGTH_SHORT)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val preferences = PreferenceHelper.defaultPrefs(this)
        if (preferences["session",false])
            goToMenuActivity()

        btnLogin.setOnClickListener{
            createSessionPreference()
            goToMenuActivity()
        }

        tvGoToRegister.setOnClickListener {
            Toast.makeText(this,getString(R.string.please_fill_your_register_data),Toast.LENGTH_SHORT).show()

            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun createSessionPreference(){
        val preferences = PreferenceHelper.defaultPrefs(this)
        preferences["session"] = true
    }

    private fun goToMenuActivity(){
        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
        finish()
    }
    override fun onBackPressed() {
        if(snackBar.isShown)
            super.onBackPressed()
        else
            snackBar.show()
    }
}