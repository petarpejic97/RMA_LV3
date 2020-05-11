package com.example.drugizadatak

interface PersonInteractionListener {
    fun getStatement(id : Int)
    fun removePerson(id : Int)
    fun updatePerson(id : Int)
}