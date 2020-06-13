package tech.danielwaiguru.businesscard

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val androidTips = listOf(
        "Lifecycle of Fragments",
        "onAttach() - called first before onCreate()",
        "onCreateView() - called when its time for the fragment to draw its UI for the first time",
        "onViewCreated() - called after onCreateView(), here you can use findViewById()",
        "onActivityCreated() - indicates that the activity's onCreate() has completed",
        "onStart() - called once the fragments gets visible",
        "onPause() - called by the system to indicate that the user is leaving the fragment",
        "onStop() - stops the fragment",
        "onDestroyView() - contains the logic UI specific things that need to be cleaned up",
        "onDestroy() - does the final clean up of the fragment's state",
        "onDetach() - notify that the fragment has been disassociated from its hosting activity"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnNextTip.setOnClickListener {
            var currentTip = androidTips.random()

            txtTips.text = currentTip
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_share -> {
                val sendIntent = Intent()
                sendIntent.type = "text/plain"
                Intent.createChooser(sendIntent, "Share Via")
                startActivity(sendIntent)
                true
            }
            R.id.action_about ->{
                showInfo()
                true
            }
            else ->false
        }
    }
    private fun showInfo(){
        /**
         * setup dialog title and the message to be displayed
         */
        val dialogTitle = getString(R.string.aboutTitle)
        val dialogMessage = getString(R.string.aboutMessage)
        val positiveButtonText = getString(R.string.positiveMessage)
        val alert = AlertDialog.Builder(this)
        alert.setTitle(dialogTitle)
        alert.setMessage(dialogMessage)
        alert.setPositiveButton(positiveButtonText) { _: DialogInterface?, _: Int ->
        }
        alert.create().show()
    }
}