package com.ikpydev.hospitalapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.ikpydev.hospitalapp.data.UserRoomDatabase
import com.ikpydev.hospitalapp.data.Users
import com.ikpydev.hospitalapp.databinding.ActivityMainTwoBinding
import java.util.Date

class MainTwoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainTwoBinding
    val database by lazy {   UserRoomDatabase.getDatabase(this)}
    val repository by lazy { WordRepository(database.wordDao()) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.add.setOnClickListener {

            val name = binding.name.text.toString()
            val last = binding.last.text.toString()
            val time = Date().time.toString()
            val doc_last = binding.doctorLast.text.toString()
            val doc_name = binding.doctorName.text.toString()

            if (name.isNullOrBlank().not() && last.isNullOrBlank().not() && doc_last.isNullOrBlank()
                    .not() && doc_name.isNullOrBlank().not()
            ) {
                val users: Users = Users(
                    id = 0,
                    name = name,
                    last = last,
                    data = time,
                    doctor_name = doc_name,
                    doctor_last = doc_last
                )

                lifecycleScope.launchWhenCreated {
                    repository.insert(users)
                }
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)


            }else{
                Toast.makeText(this, "Birontasi bosh qolib ketii", Toast.LENGTH_SHORT).show()
            }



        }
    }
}