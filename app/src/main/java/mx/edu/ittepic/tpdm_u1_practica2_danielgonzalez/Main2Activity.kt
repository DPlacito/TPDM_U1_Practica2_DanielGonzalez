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
    var btn_Archivar: Button?=null
    var valor: EditText? = null
    var posicionC: EditText? = null
    var posicionR: EditText? = null
    var archivo1: RadioButton? = null
    var archivo2: RadioButton? = null
    var archivo3: RadioButton? = null
    var cadena = ""
    var m=0
    var v=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        layo_PR = findViewById(R.id.layo_posicionR)
        btn_Regresar = findViewById(R.id.btnRegresar)
        gridlayout = findViewById(R.id.Gridlayoutxd)
        btn_Capturar = findViewById(R.id.btnCapturar)
        btn_Archivar = findViewById(R.id.btnArchivar)
        valor = findViewById(R.id.valor)
        posicionC = findViewById(R.id.posicionC_layout)
        posicionR = findViewById(R.id.posicionR_layout)
        archivo1 = findViewById(R.id.rb_Archivo1)
        archivo2 = findViewById(R.id.rb_Archivo1)
        archivo3 = findViewById(R.id.rb_Archivo1)

        var eligioVector = intent.extras?.getString("hide")
        if (eligioVector?.equals("oculta") == true) {
            layo_PR?.setVisibility(View.GONE)
            var campo1 = intent.extras?.getString("campo1")
            gridlayout?.columnCount = campo1.toString().toInt()
        } else {
            var campo1 = intent.extras?.getString("campo1")
            var campo2 = intent.extras?.getString("campo2")
            gridlayout?.columnCount = campo1.toString().toInt()
            gridlayout?.rowCount = campo2.toString().toInt()
        }

        btn_Capturar?.setOnClickListener {
            if (eligioVector?.equals("oculta") == true) {
                if (valor?.text.toString().isEmpty() == true || posicionC?.text.toString().isEmpty() == true) {
                    val alerta = AlertDialog.Builder(this)
                    alerta.setTitle("ERROR!!").setMessage("DEBES DE INTRODUCIR LO DE UN VECTOR")
                        .show()
                } else {
                    var valor = valor?.text.toString()
                    var numero = TextView(this)
                    numero.setText(valor)
                    gridlayout?.addView(numero)
                }
            }
                else{
                    if (valor?.text.toString().isEmpty() == true || posicionC?.text.toString().isEmpty() == true || posicionR?.text.toString().isEmpty() == true) {
                        val alerta = AlertDialog.Builder(this)
                        alerta.setTitle("ERROR!!")
                            .setMessage("DEBES DE INTRODUCIR LO DE UNA MATRIZ")
                            .show()
                    } else {
                        var valor = valor?.text.toString()
                        var numero = TextView(this)
                        numero.setText(valor)
                        gridlayout?.addView(numero)
                    }
                }
        }
        //Accion Del Boton Regresar
        btn_Regresar?.setOnClickListener {
            finish()
        }
      //Para Archivar
        btn_Archivar?.setOnClickListener {
            if(archivo1?.isChecked==true){
                guardarArchivo1()
            }
            if(archivo2?.isChecked==true){
                guardarArchivo2()
            }
            if(archivo3?.isChecked==true){
                guardarArchivo3()
            }
        }
    }
    fun guardarArchivo1(){
        cadena="V"+posicionC?.text.toString()+" /nValor: "+valor?.text.toString()
        if(m==1){cadena= "Titulo: "+"M"+posicionC?.text.toString()+posicionR?.text.toString()+" /nValor: "+valor?.text.toString()}
        val guardarArchivo=OutputStreamWriter(openFileOutput("archivo1.txt",Activity.MODE_PRIVATE))
        guardarArchivo.write(cadena)
        guardarArchivo.flush()
        AlertDialog.Builder(this).setTitle("ATENCION")
            .setMessage("SE GUARDO EN ARCHIVO 1")
            .setPositiveButton("ACEPTAR"){dialog,which->}
            .show()
    }

    fun guardarArchivo2(){
        cadena="V"+posicionC?.text.toString()+" /nValor: "+valor?.text.toString()
        if(m==1){cadena= "Titulo: "+"M"+posicionC?.text.toString()+posicionR?.text.toString()+" /nValor: "+valor?.text.toString()}
        val guardarArchivo=OutputStreamWriter(openFileOutput("archivo2.txt",Activity.MODE_PRIVATE))
        guardarArchivo.write("Titulo: "+cadena+" /nValor: "+valor?.text.toString())
        guardarArchivo.flush()
        AlertDialog.Builder(this).setTitle("ATENCION")
            .setMessage("SE GUARDO EN ARCHIVO 2")
            .setPositiveButton("ACEPTAR"){dialog,which->}
            .show()

    }
    fun guardarArchivo3(){
        cadena="V"+posicionC?.text.toString()+" /nValor: "+valor?.text.toString()
        if(m==1){cadena= "Titulo: "+"M"+posicionC?.text.toString()+posicionR?.text.toString()+" /nValor: "+valor?.text.toString()}

        val guardarArchivo=OutputStreamWriter(openFileOutput("archivo3.txt",Activity.MODE_PRIVATE))
        guardarArchivo.write(cadena)

        guardarArchivo.flush()
        AlertDialog.Builder(this).setTitle("ATENCION")
            .setMessage("SE GUARDO EN ARCHIVO 3")
            .setPositiveButton("ACEPTAR"){dialog,which->}
            .show()

    }
}


