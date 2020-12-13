package com.shandanghooman.app.ui.auth

import android.content.ComponentCallbacks
import android.content.Context
import com.shandanghooman.app.data.model.ActionState
import com.shandanghooman.app.data.repository.AuthRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

object ShandangHoomanAuth {
    fun logout(context: Context, callback:((ActionState<Boolean>) -> Unit)? = null){
        val repo = AuthRepository(context)
        CoroutineScope(Dispatchers.IO).launch {
            val resp = repo.logout()
            withContext(Dispatchers.Main){
                if (callback != null) callback.invoke(resp)
            }
        }
    }
}