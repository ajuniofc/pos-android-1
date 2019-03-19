package ajuniofc.com.br.firebaseapp

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_recuperar_senha.*

class RecuperarSenhaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperar_senha)

        recuperarButtonId.setOnClickListener {
            onRecuperarSenha(emailId.text.toString(), this)
        }
    }

    private fun onRecuperarSenha(
        email: String,
        activity: Activity
    ) {
        val auth = FirebaseAuth.getInstance()
        auth.verifyPasswordResetCode(email).addOnCompleteListener(activity){
                task ->
            if(task.isSuccessful){
                Toast.makeText(applicationContext,"E-mail enviado!", Toast.LENGTH_SHORT).show()
                finish()
            }else{
                Toast.makeText(applicationContext,"Falha ao conectar com Firebase", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
