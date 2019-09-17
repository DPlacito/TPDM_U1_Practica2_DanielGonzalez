package mx.edu.ittepic.tpdm_u1_practica2_danielgonzalez

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main2.*
import java.io.OutputStreamWriter

class Main2Activity : AppCompatActivity() {

    var layo_PR: LinearLayout? = null
    var btn_Regresar: Button? = null
    var gridlayout: GridLayout? = null
    var btn_Capturar: Button? = null
    var valor: EditText? = null
    var posicionC: EditText? = null
    var posicionR: EditText? = null
    var archivo1: RadioButton? = null
    var archivo2: RadioButton? = null
    var archivo3: RadioButton? = null
    var cadena = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        layo_PR = findViewById(R.id.layo_posicionR)
        btn_Regresar = findViewById(R.id.btnRegresar)
        gridlayout = findViewById(R.id.Gridlayoutxd)
        btn_Capturar = findViewById(R.id.btnCapturar)
        valor = findViewById(R.id.valor)
        posicionC = findViewById(R.id.posicionC_layout)
        posicionR = findViewById(R.id.posicionR_layout)
        archivo1 = findViewById(R.id.rb_Archivo1)
        archivo2 = findViewById(R.id.rb_Archivo1)
        archivo3 = findViewById(R.id.rb_Archivo1)

        var eligioVector = intent.extras?.getString("hide")
        if (eligioVector?.equals("oculto") == true) {
            layo_PR?.setVisibility(View.GONE)
        }



        btn_Capturar?.setOnClickListener {
            var numero = valor?.text.toString().toInt()
            var columna = posicionC?.text.toString()
            var renglon = posicionR?.text.toString()

            gridlayout?.columnCount = columna.toInt()
        }

        //Accion Del Boton Regresar
        btn_Regresar?.setOnClickListener {
            finish()
        }
    }
}

