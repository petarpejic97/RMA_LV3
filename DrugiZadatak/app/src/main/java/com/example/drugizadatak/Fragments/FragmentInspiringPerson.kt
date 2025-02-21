package com.example.drugizadatak.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.drugizadatak.*


class FragmentInspiringPerson : Fragment(){
    protected lateinit var rootView: View
    lateinit var peopleDisplay: RecyclerView
    private var mMain: MainActivity? = null
    val personDao = PersonDatabase.getInstance().personDao()

    companion object {
        fun newInstance(): FragmentInspiringPerson{
            return FragmentInspiringPerson()
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_inspiring_person, container, false)
        initView()
        initMain()
        return rootView
    }
    private fun initView(){
        initializeRecyclerView()
    }
    private fun initMain() {
        mMain = activity as MainActivity?
    }

    private fun initializeRecyclerView(){
        peopleDisplay = rootView.findViewById(R.id.peopleDisplay)
        peopleDisplay.layoutManager = activity?.let { LinearLayoutManager(it) }
        peopleDisplay.itemAnimator = DefaultItemAnimator()
        peopleDisplay.addItemDecoration(DividerItemDecoration(activity,RecyclerView.VERTICAL))

        displayData()

    }

    override fun onResume() {
        super.onResume()
        displayData()
    }
    private fun displayData() {
        val personListener = object : PersonInteractionListener {
            override fun getStatement(id: Int) {
                val person = personDao.getById(id)
                var statements : List<String> = person.statements.split("|")
                val length = statements.size-1
                val number= (0..length).random()
                Toast.makeText(activity,statements[number], Toast.LENGTH_LONG).show()
            }
            override fun removePerson(id: Int) {
                var person = personDao.getById(id)
                personDao.delete(person)
                (peopleDisplay.adapter as InspiringPersonAdapter).refreshData(
                    personDao.getAll() as MutableList<InspiringPerson>
                )
            }
            override fun updatePerson(id: Int) {
                mMain?.getUpdataId(id)
            }
        }
        peopleDisplay.adapter = InspiringPersonAdapter(
            personDao.getAll() as MutableList<InspiringPerson>,
            personListener
        )
    }

}
