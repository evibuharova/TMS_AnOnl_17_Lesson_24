package com.example.tms_anonl_17_lesson_24.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tms_anonl_17_lesson_24.Note
import com.example.tms_anonl_17_lesson_24.NoteHolder
import com.example.tms_anonl_17_lesson_24.SingleLiveEvent
import com.example.tms_anonl_17_lesson_24.list.NoteListFragment.*
import java.util.Date

class NoteListViewModel : ViewModel() {
    private val _state = MutableLiveData<State>()
    val state: LiveData<State> = _state
    val event = SingleLiveEvent<Event>()

    init {
        NoteHolder.notes.add(
            Note("examle note", "some random text", Date().toString())
        )
        _state.value = State.Initial(NoteHolder.notes.toList())
    }

    fun onAction(action: Action) = when (action) {
        Action.Update -> {
            val oldNotes = (_state.value as? State.Notes)?.items
            if (oldNotes != NoteHolder.notes) {
                event.value = Event.ShowSuccessMessage
            }
            _state.value = State.Notes(NoteHolder.notes.toList())
        }

        Action.AddClick -> {
            event.value = Event.GoToAddScreen
        }
    }
}
