package com.example.app

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.signin.internal.SignInClientImpl
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.OAuthProvider

class LoginScreen : AppCompatActivity() {

    private lateinit var auth:FirebaseAuth
    private lateinit var signInBtn:Button
    private lateinit var registerTv:TextView
    private lateinit var googleSignInClient:GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)
        supportActionBar?.hide();

        auth = FirebaseAuth.getInstance();

        val signInBtn = findViewById<Button>(R.id.signInBtn)
        signInBtn.setOnClickListener {
            val email = findViewById<EditText>(R.id.mailLoginTxt).text.toString();
            val password = findViewById<EditText>(R.id.pswdLoginTxt).text.toString();
            this.login(email,password);
        }

        val twitterBtn = findViewById<ImageButton>(R.id.facebookBtn);

        twitterBtn.setOnClickListener {
            this.twitterSignIn();
        }

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("861719252186-3upctcs97si0e8csmgogle8n1kds25i0.apps.googleusercontent.com")
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

        val googleBtn = findViewById<ImageButton>(R.id.googleBtn);

        googleBtn.setOnClickListener {
            this.googleSignIn();
        }

        val registerTv = findViewById<TextView>(R.id.registerTv)
        registerTv.setOnClickListener{
            this.goToRegister();
        }
    }

    private fun login(email:String, password: String){
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener{task ->
            if(task.isSuccessful){

                Toast.makeText(applicationContext, "Lograste logearte", Toast.LENGTH_LONG).show()
                val intent = Intent(this, MainActivity::class.java);
                startActivity(intent);
                finish();
            }
        }.addOnFailureListener{exception ->
            Toast.makeText(applicationContext, exception.localizedMessage, Toast.LENGTH_LONG).show()
        }
    }

    private fun googleSignIn(){
        val signInIntent = googleSignInClient.signInIntent;
        launcher.launch(signInIntent);
    }

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result -> if(result.resultCode == Activity.RESULT_OK) {
        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
        handleResults(task);
    }
    }

    private fun handleResults(task: Task<GoogleSignInAccount>){
        if(task.isSuccessful){
            val account : GoogleSignInAccount? = task.result
            if(account != null){
                updateUI(account)
            }
        }else{
            Toast.makeText(this, task.exception.toString(), Toast.LENGTH_LONG).show()
        }
    }

    private fun updateUI(account: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        auth.signInWithCredential(credential).addOnCompleteListener{
            if(it.isSuccessful){
                Toast.makeText(applicationContext, "Lograste logearte", Toast.LENGTH_LONG).show()
                val intent = Intent(this, MainActivity::class.java);
                startActivity(intent);
            }else{
                Toast.makeText(this, it.exception.toString(), Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun twitterSignIn(){
        val provider = OAuthProvider.newBuilder("twitter.com");
        provider.addCustomParameter("lang", "en");

        val pendingResultTask = auth.pendingAuthResult
        if(pendingResultTask != null){
            pendingResultTask.addOnSuccessListener {
                Toast.makeText(applicationContext, "Lograste logearte", Toast.LENGTH_LONG).show()
                val intent = Intent(this, MainActivity::class.java);
                startActivity(intent);
            }
        }else
        {
            auth.startActivityForSignInWithProvider(this, provider.build())
                .addOnSuccessListener {
                    Toast.makeText(applicationContext, "Lograste logearte (?", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, MainActivity::class.java);
                    startActivity(intent);
                }
        }
    }

    private fun goToRegister(){
        val intent = Intent(this, RegisterScreen::class.java)
        startActivity(intent);
    }
}