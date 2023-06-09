package com.example.login.firebase.domain.usecase

import com.example.login.firebase.domain.repository.AuthRepository
import com.example.login.firebase.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FirebaseSignUpUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {

    suspend operator fun invoke(email:String, password: String): Flow<Resource<Boolean>> = flow{

        emit(Resource.Loading)
        val isSignUpSuccesfully:Boolean = authRepository.signUp(email, password)

        if (isSignUpSuccesfully){
            emit(Resource.Succes(true))
        }else{
            emit(Resource.Error("SignUp Error"))
        }

    }


}