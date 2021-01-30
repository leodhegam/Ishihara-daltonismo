package com.tads.ishihara
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.tads.ishihara.databinding.ActivityTesteBinding


class TesteActivity : AppCompatActivity() {

    lateinit var  binding: ActivityTesteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teste)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_teste)

        var param = intent.extras?.getInt("img")


        binding.apply {
            if(param==1) {
                imageView.setImageResource(R.drawable.ishiaara1)

            }else if(param==2){
                imageView.setImageResource(R.drawable.ishihara2)
            }else {
                imageView.setImageResource(R.drawable.ishihara29)
            }
        }


        binding.confirmaButton.setOnClickListener {
            var intent = Intent()
            intent.putExtra("res", binding.respNumero.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        binding.cancelarButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("CANCELAR", "Cancelado")
            setResult(Activity.RESULT_CANCELED, intent)
            finish()
        }

    }
}