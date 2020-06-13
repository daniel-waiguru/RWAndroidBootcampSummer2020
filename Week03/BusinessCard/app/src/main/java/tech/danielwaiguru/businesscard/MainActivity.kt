package tech.danielwaiguru.businesscard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
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
}