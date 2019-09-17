package mx.edu.ittepic.tpdm_u1_practica2_danielgonzalez

import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    var hide =""
    var lista : ListView ?=null
    var celdillas : EditText?=null
    var renglones : EditText?=null
    var rGroup : RadioGroup?=null
    var rbuttonVector : RadioButton?=null
    var rbuttonMatriz : RadioButton?=null
    var lrenglones : LinearLayout?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lista = findViewById(R.id.menuListView)
        celdillas = findViewById(R.id.celdillas)
        renglones =findViewById(R.id.renglones)
        rGroup = findViewById(R.id.rg)
        rbuttonVector = findViewById(R.id.rbVector)
        rbuttonMatriz = findViewById(R.id.rbMatriz)
        lrenglones = findViewById(R.id.layo_renglones)

        lista?.setOnItemClickListener{adapterView, view, i, l ->
            when (i){

                0 -> abrirCapturar()
                1 -> abrirMostrar()
                2 -> abrirAcercaDe()
                3 -> finish()

            }
        }

        // Parte Dinamica
        rbVector?.setOnClickListener {
            lrenglones?.setVisibility(View.GONE)
        }
        rbMatriz?.setOnClickListener {
            lrenglones?.setVisibility(View.VISIBLE)
        }
    }

    fun abrirCapturar() {
        if (rbuttonMatriz?.isChecked == true) {
            if (celdillas?.text.toString().isEmpty() == true || renglones?.text.toString().isEmpty()==true) {
                val alerta = AlertDialog.Builder(this)
                alerta.setTitle("ERROR!!").setMessage("NO LLENASTE NI CELDILLAS Y/O RENGLONES")
                    .show()
            }
             else {
                var CapturaDatos = Intent(this, Main2Activity::class.java)
                CapturaDatos.putExtra("campo1",celdillas?.text.toString())
                CapturaDatos.putExtra("campo2",renglones?.text.toString())
                startActivity(CapturaDatos)
            }
        }
        if(rbuttonVector?.isChecked==true) {
            if (celdillas?.text.toString().isEmpty() == true) {
                val alerta = AlertDialog.Builder(this)
                alerta.setTitle("ERROR!!").setMessage("DEBES DE INTRODUCIR UN NUMERO EN CELDILLAS")
                    .show()
                return }
            else {
                hide ="oculta"
                var CapturaDatos = Intent(this, Main2Activity::class.java)
                CapturaDatos.putExtra("hide",hide)
                CapturaDatos.putExtra("campo1",celdillas?.text.toString())
                startActivity(CapturaDatos)
            }
        }
    }
    fun abrirMostrar(){
        var MostrarDatos = Intent(this, Main3Activity::class.java)
        startActivity(MostrarDatos)
    }

    fun abrirAcercaDe(){
        val alerta = AlertDialog.Builder(this)

        alerta.setTitle("Acerca De...").setMessage("(c) Daniel Arturo Gonzalez Placito")
            .setPositiveButton("Aceptar"){dialogInterface, i ->  }
            .setNegativeButton("Cancelar"){dialog,which->}.show()
    }
}
