package ajuniofc.com.br.firebaseapp

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_cadastra.*

class CadastraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastra)

        cadastraButton.setOnClickListener{
            onCadastra(emailId.text.toString(), passwordId.text.toString(), this)
        }
    }

    private fun onCadastra(
        email: String,
        password: String,
        activity: Activity
    ) {
        val auth = FirebaseAuth.getInstance()
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(activity){
                task ->
            if(task.isSuccessful){
                Toast.makeText(applicationContext,"Usuario criado com sucesso", Toast.LENGTH_SHORT).show()
                finish()
            }else{
                Toast.makeText(applicationContext,"Falha ao criar usuario", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
