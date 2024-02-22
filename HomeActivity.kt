package my.android.thirdloginapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.auth.oAuthCredential
import my.android.thirdloginapplication.MainActivity.Companion.auth
import my.android.thirdloginapplication.databinding.ActivityHomeBinding
import my.android.thirdloginapplication.databinding.ActivityMainBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLogout.setOnClickListener {
            Firebase.auth.signOut()
            startActivity(Intent(this, MainActivity :: class.java))
            finish()
        }

        binding.txtUseremail.text = emailUpdate()

    }

    private fun emailUpdate(): String {
        return "Email: ${auth.currentUser?.email.toString()}"

    }
}