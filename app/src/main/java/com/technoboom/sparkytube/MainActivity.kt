package com.technoboom.sparkytube
import io.reactivex.rxkotlin.subscribeBy;
import io.reactivex.rxkotlin.toObservable;

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = listOf("Alpha", "Beta", "Gamma", "Omega")

        list.toObservable()
                .filter { it.length > 5 }
                .subscribeBy(
                        onNext = { println(it) },
                        onError = { it.printStackTrace() },
                        onComplete = { println("Done") }
                )
    }
}
