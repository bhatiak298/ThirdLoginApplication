package my.android.thirdloginapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import my.android.thirdloginapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //static object
    companion object{
        lateinit var auth: FirebaseAuth
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //initialize it
        auth = FirebaseAuth.getInstance()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val email = binding.edtxtEmail.text.toString()
            val password = binding.edtxtPass.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty())
            {
                MainActivity.auth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
                    if (it.isSuccessful){
                        Toast.makeText(this, "Login Successfull", Toast.LENGTH_LONG).show()
                        //intent to home activity
                        startActivity(Intent(this, HomeActivity :: class.java))
                        finish()
                    }
                }.addOnFailureListener {
                    Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
                }
            }
        }

        binding.btnCreateAcc.setOnClickListener {
            startActivity(Intent(this, RegisterActivity :: class.java))
            finish()
        }

    }
}