package com.example.demodao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.demodao.Model.EntityInformazioni
import com.example.demodao.Model.EntityNote
import com.example.demodao.Model.EntityUser
import com.example.demodao.db.DatabaseAndroid
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       /* GlobalScope.launch {
            //val db = DatabaseAndroid.getDatabase(this@MainActivity)
            //db.userDao().insert(EntityUser(1, "pippino.it", "pidfso", "pluto", "Luiggino"))
            //db.infoDao().insertInformation(EntityInformazioni(1, "M", "padova", "1212", "nfisni"))
            //db.noteDao().insertNote(EntityNote(1, 1, "nuova nota", "isdnaisdiasndiansdiansidn"))
            //db.userDao().deleteUser(EntityUser(2, "pippod.it","pippo","pluto","gino"))
           // val lista = db.userDao().getAll()
            //val pippo = findViewById<TextView>(R.id.utente)

            //pippo.setText("${lista[0].cognome} ")

        }*/


        GlobalScope.launch(Dispatchers.IO){

           // val db = DatabaseAndroid.getDatabase(this@MainActivity)

            val button = findViewById<Button>(R.id.button)

            val password = findViewById<EditText>(R.id.password)
            val input1: String = password.text.toString()

            val nome = findViewById<EditText>(R.id.nome)
            val input2: String = nome.text.toString()

            val cognome = findViewById<EditText>(R.id.cognome)
            val input3: String = cognome.text.toString()

button.setOnClickListener {

    val email = findViewById<EditText>(R.id.email)
    val input0: String = email.text.toString()

    val password = findViewById<EditText>(R.id.password)
    val input1: String = password.text.toString()


    Log.d("G",input0.toString())
    Log.d("G",input1.toString())
    Toast.makeText(this@MainActivity, "OK", Toast.LENGTH_SHORT).show()

    GlobalScope.launch {
        val db = DatabaseAndroid.getDatabase(this@MainActivity)
        val email: List<String> = db.userDao().getAllEmail()
        val password: List<String> =db.userDao().getAllPassword()

        val ema = email.indexOf(input0)
        Log.d("P",ema.toString())
        val pas = password.indexOf(input1)
        Log.d("P",pas.toString())

        if(ema == pas ) {

            Log.d("P","corretto")
           // Toast.makeText(this@MainActivity, "Trovato", Toast.LENGTH_SHORT).show()

        }else {
            Log.d("V","Non corretto")

            //  Toast.makeText(this@MainActivity, "Errato", Toast.LENGTH_SHORT).show()

        }

    }

}






          /*  button.setOnClickListener {

                GlobalScope.launch {
                    val db = DatabaseAndroid.getDatabase(this@MainActivity)
                    db.userDao().insert(
                        EntityUser(
                            input0, input1, input2, input3
                        )
                    )

                }
*/


            }




        }

    }
