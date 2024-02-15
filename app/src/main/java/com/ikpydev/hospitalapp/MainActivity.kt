package com.ikpydev.hospitalapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.ikpydev.hospitalapp.data.UserRoomDatabase
import com.ikpydev.hospitalapp.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collectLatest

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var database: UserRoomDatabase
    private lateinit var adapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = UserAdapter()

        binding.names.adapter = adapter

        database = UserRoomDatabase.getDatabase(this)

        lifecycleScope.launchWhenCreated {
            database.wordDao().selectAll().collectLatest { it ->
                adapter.submitList(it.sortedBy { it.data })
            }

        }

        binding.newAdd.setOnClickListener {

            val intent = Intent(this, MainTwoActivity::class.java)
            startActivity(intent)
        }

        binding.sortName.setOnClickListener {

            lifecycleScope.launchWhenCreated {
                database.wordDao().selectAll().collectLatest { it ->
                    adapter.submitList(it.sortedBy { it.name })
                }
            }
        }
        binding.sortDoctor.setOnClickListener {

            lifecycleScope.launchWhenCreated {
                database.wordDao().selectAll().collectLatest { it ->
                    adapter.submitList(it.sortedBy { it.doctor_name })
                }
            }
        }
        binding.sortTime.setOnClickListener {
            lifecycleScope.launchWhenCreated {
                database.wordDao().selectAll().collectLatest { it ->
                    adapter.submitList(it.sortedBy { it.data })
                }
            }
        }

    }
}