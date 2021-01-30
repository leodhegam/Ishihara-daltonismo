package com.tads.ishihara

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.tads.ishihara.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {
            resposta1.text="0"
            resposta2.text="0"
            resposta3.text="0"
        }


        binding.buttonTeste1.setOnClickListener {
            var i = Intent(this,TesteActivity::class.java)
            var param = Bundle()
            param.putInt("img",1)
            i.putExtras(param)
            startActivityForResult(i,1)
        }
        binding.buttonTeste2.setOnClickListener {
            var i = Intent(this,TesteActivity::class.java)
            var param = Bundle()
            param.putInt("img",2)
            i.putExtras(param)
            startActivityForResult(i,2)

        }
        binding.buttonTeste3.setOnClickListener {
            var i = Intent(this,TesteActivity::class.java)
            var param = Bundle()
            param.putInt("img",3)
            i.putExtras(param)
            startActivityForResult(i,3)

        }


        binding.verificarButton.setOnClickListener{
            if(binding.resposta1.text =="74" && binding.resposta2.text =="8" && binding.resposta3.text =="29") {
                binding.resultadoTeste.text = "Normal"
                binding.invalidateAll()
            }
            else if(binding.resposta1.text == "0" || binding.resposta2.text =="0" || binding.resposta3.text =="0" ){

                Toast.makeText(this, "Por favor , realize os 3 testes", Toast.LENGTH_SHORT).show()
            }else {
                binding.resultadoTeste.text = "Procure um médico"
                binding.invalidateAll()
            }
        }
    }
             override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
         super.onActivityResult(requestCode, resultCode, data)
             if(requestCode == 1) {
                 if(resultCode == Activity.RESULT_OK) {
                     binding.resposta1.text = data?.extras?.getString("res")
                     binding.invalidateAll()
                 }
             } else if(requestCode == 2 ) {
                 if(resultCode ==Activity.RESULT_OK) {
                     binding.resposta2.text = data?.extras?.getString("res")
                     binding.invalidateAll()
                 }
             } else if (requestCode == 3) {
                     if(resultCode == Activity.RESULT_OK) {
                     binding.resposta3.text = data?.extras?.getString("res")
                     binding.invalidateAll()
                 }

             }
             }
}




//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        when(requestCode) {
//             1-> {
//                when(resultCode){
//                    Activity.RESULT_OK->{
//                       val result = data?.extras?.getString("resp")
//                       binding.resposta1.text = result
//                    }
//                }
//            }
//            2->{
//                when(resultCode){
//                    Activity.RESULT_OK->{
//                        val result = data?.extras?.getString("resp")
//                        binding.resposta2.text = result
//                    }
//                }
//        }3-> {
//            when(resultCode){
//                Activity.RESULT_OK->{
//                    val result = data?.extras?.getString("resp")
//                    binding.resposta3.text = result
//                }
//            }
//        }
//       }
//    }





