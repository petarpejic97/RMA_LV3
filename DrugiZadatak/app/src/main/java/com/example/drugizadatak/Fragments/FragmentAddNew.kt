package com.example.drugizadatak.Fragments

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_add_new.view.*
import android.widget.Toast
import com.example.drugizadatak.*

class FragmentAddNew : Fragment(),OnLongTouchListener {

    val personDao = PersonDatabase.getInstance().personDao()
    protected lateinit var rootView: View
    lateinit var btnAdd: Button
    private var updateFlag = false
    private var updatePersonId = 0
    private var mMain: MainActivity? = null

    companion object {
        fun newInstance(): FragmentAddNew{
            return FragmentAddNew()
        }
    }
    override fun setFieldsForUpdate(id: Int) {
        Log.w("DODEM","DODEM")
        fillFields(id)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_add_new, container, false)
        onClickAdd()
        mMain?.setOnUpdating(this)
        return rootView
    }

    private fun onClickAdd() {
        btnAdd = rootView.findViewById(R.id.btnAdd)

        btnAdd.setOnClickListener{createPerson()}
    }

    private fun createPerson() {
        if(rootView.edFullname.text.toString().isEmpty() || rootView.edBirth.text.toString().isEmpty() || rootView.edDescription.text.toString().isEmpty() ||
            rootView.edLinkImage.text.toString().isEmpty() || rootView.edStatements.text.toString().isEmpty()){
            Toast.makeText(activity,"Some fields are empty !",Toast.LENGTH_LONG).show()
        }
        else{
            val fullname : String = rootView.edFullname.text.toString()
            val birth : String = rootView.edBirth.text.toString()
            val descripton : String = rootView.edDescription.text.toString()
            val imglink : String = rootView.edLinkImage.text.toString()
            val statements = rootView.edStatements.text.toString()


            if(updateFlag){
                val person = InspiringPerson(updatePersonId, imglink, fullname, birth, descripton, statements)
                addPersonInList(person)
                resetFields()
                Toast.makeText(activity,"Person ${person.fullName} updated!",Toast.LENGTH_LONG).show()
            }
            else{
                val id : Int = personDao.getMaxId()+1
                val person = InspiringPerson(id, imglink, fullname, birth, descripton, statements)
                addPersonInList(person)
                Toast.makeText(activity,"Person ${person.fullName} added!",Toast.LENGTH_LONG).show()
                resetFields()
            }

        }
    }
    private fun resetFields(){
        rootView.edFullname.text = Editable.Factory.getInstance().newEditable("")
        rootView.edBirth.text = Editable.Factory.getInstance().newEditable("")
        rootView.edDescription.text = Editable.Factory.getInstance().newEditable("")
        rootView.edLinkImage.text = Editable.Factory.getInstance().newEditable("")
        rootView.edStatements.text = Editable.Factory.getInstance().newEditable("")
    }
    private fun fillFields(id : Int){
        val person = personDao.getById(id)
        updatePersonId = id
        Log.w("ID",id.toString())
            rootView.edFullname.text = Editable.Factory.getInstance().newEditable(person.fullName)
            rootView.edBirth.text = Editable.Factory.getInstance().newEditable(person.birth)
            rootView.edDescription.text = Editable.Factory.getInstance().newEditable(person.descripton)
            rootView.edLinkImage.text = Editable.Factory.getInstance().newEditable(person.image)
            rootView.edStatements.text = Editable.Factory.getInstance().newEditable(person.statements)

            updateFlag = true
    }
    private fun addPersonInList(person: InspiringPerson) {

        if(!updateFlag)
            personDao.insert(person)
        else {
            updateFlag = false
            personDao.update(person)
        }
    }
    override fun onAttach(a: Context) {
        super.onAttach(a)
        mMain = a as MainActivity
    }

    override fun onDetach() {
        super.onDetach()
    }
}
