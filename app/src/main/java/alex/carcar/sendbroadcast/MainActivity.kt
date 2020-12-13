package alex.carcar.sendbroadcast

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var receiver: BroadcastReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configureReceiver()
    }

    private fun configureReceiver() {
        val filter = IntentFilter()
        filter.addAction("alex.carcar.sendbroadcast")
        filter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED")
        receiver = MyReceiver()
        registerReceiver(receiver, filter)
    }

    fun broadcastIntent(view: View) {
        val intent = Intent()
        intent.action = "alex.carcar.sendbroadcast"
        intent.flags = Intent.FLAG_INCLUDE_STOPPED_PACKAGES
        sendBroadcast(intent)
    }
}