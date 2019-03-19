package ajuniofc.com.br.firebaseapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginButton.setOnClickListener(this)
        cadastraId.setOnClickListener(this)
        recuperarId.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.loginButton -> onLogin(emailId.text.toString(), passwordId.text.toString(), this@MainActivity)
            R.id.cadastraId -> goToCadastro()
            R.id.recuperarId -> goToRecuperarSenha()
            else -> Toast.makeText(this, "View invalida", Toast.LENGTH_SHORT).show()
        }
    }

    private fun goToRecuperarSenha() {
        startActivity(Intent(this, RecuperarSenhaActivity::class.java))
    }

    private fun goToCadastro() {
        startActivity(Intent(this, CadastraActivity::class.java))
    }

    private fun onLogin(
        email: String,
        password: String,
        activity: MainActivity
    ) {
        val auth = FirebaseAuth.getInstance()
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(activity){
            task ->
            if(task.isSuccessful){
                startActivity(Intent(applicationContext, HomeActivity::class.java))
            }else{
                Toast.makeText(applicationContext,"Falha de autenticacao", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
