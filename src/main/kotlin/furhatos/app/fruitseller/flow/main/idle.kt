package furhatos.app.fruitseller.flow.main

import furhatos.flow.kotlin.*

val Idle: State = state {

    init {
        when {
            users.count > 0 -> {
                val user = users.random
                furhat.attend(user)
                goto(Greeting)
            }
            users.count == 0 && furhat.isVirtual() -> furhat.say("I can't see anyone. Add a virtual user please. ")
            users.count == 0 && !furhat.isVirtual() -> furhat.say("I can't see anyone. Step closer please. ")
        }
    }

    onEntry {
        furhat.attendNobody()
    }

    onUserEnter {
        furhat.attend(it)
        goto(Greeting)
    }
}
