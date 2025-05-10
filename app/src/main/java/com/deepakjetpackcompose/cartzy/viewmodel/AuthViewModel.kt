package com.deepakjetpackcompose.cartzy.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.deepakjetpackcompose.cartzy.model.UserModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore

class AuthViewModel: ViewModel() {
    private val auth: FirebaseAuth= Firebase.auth
    private val fireStore: FirebaseFirestore= Firebase.firestore

    fun signUp(email:String,password:String,name:String,onResult:(Boolean,String?)-> Unit){
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                if(it.isSuccessful){
                    val userId=it.result?.user?.uid
                    val userModel= UserModel(email = email,name=name,uid=userId!!)
                    fireStore.collection("users").document(userId).set(userModel)
                        .addOnCompleteListener { dbtask->
                            if(dbtask.isSuccessful){
                                onResult(true,null)
                            }else{
                                onResult(false,"Something went wrong")
                                Log.d("db",dbtask.isSuccessful.toString())
                            }
                        }
                }else{
                    onResult(false,it.exception?.localizedMessage)
                }
            }
    }

    fun login(email:String,password: String,onResult:(Boolean,String?)-> Unit){
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                if(it.isSuccessful){
                    onResult(true,null)
                }else{
                    onResult(false,it.exception?.localizedMessage)
                }
            }

    }
}