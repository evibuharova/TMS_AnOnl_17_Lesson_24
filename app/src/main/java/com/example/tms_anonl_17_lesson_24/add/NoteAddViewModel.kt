package com.example.tms_anonl_17_lesson_24.add

import androidx.lifecycle.ViewModel
import com.example.tms_anonl_17_lesson_24.Note
import com.example.tms_anonl_17_lesson_24.NoteHolder
import com.example.tms_anonl_17_lesson_24.SingleLiveEvent
import com.example.tms_anonl_17_lesson_24.add.NoteAddFragment.Action
import com.example.tms_anonl_17_lesson_24.add.NoteAddFragment.Event
import java.util.Date

class NoteAddViewModel : ViewModel() {
    val event = SingleLiveEvent<Event>()

    fun onAction(action: Action) = when (action) {
        is Action.SaveClick -> {
            val newMote = Note(action.text, action.header, Date().toString())
            NoteHolder.notes.add(newMote)
            event.value = Event.GoBack
        }
    }
}
