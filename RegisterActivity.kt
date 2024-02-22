package my.android.thirdloginapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import my.android.thirdloginapplication.databinding.ActivityMainBinding
import my.android.thirdloginapplication.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAccCreateAcc.setOnClickListener {
            val email = binding.edtxtAccEmail.text.toString()
            val password = binding.edtxtAccPass.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty())
            {
                MainActivity.auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
                    if (it.isSuccessful){
                        Toast.makeText(this, "Account created successfully", Toast.LENGTH_LONG).show()
                        //intent to home activity
                        startActivity(Intent(this, MainActivity :: class.java))
                        finish()
                    }
                }.addOnFailureListener {
                    Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}