package com.example.kargopaipo

import com.example.kargopaipo.data.NwService
import com.example.kargopaipo.data.Repository

/**
 * Created by Kanish Roshan on 2020-02-17.
 */
class Injection {

    fun getRepository():Repository{

        return Repository(NwService.create())
    }
}