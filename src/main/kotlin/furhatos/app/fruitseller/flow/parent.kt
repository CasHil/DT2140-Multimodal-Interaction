package furhatos.app.fruitseller.flow

import furhatos.app.fruitseller.flow.main.Idle
import furhatos.flow.kotlin.*

val Parent: State = state {

    onUserLeave {
        when {
            users.count == 0 -> goto(Idle)
            it == users.current -> furhat.attend(users.other)
        }
    }

    onUserEnter {
        val originalUser = users.current
        furhat.attend(it)
        when {
            users.count >= 2 -> {
                delay(1000)
                furhat.say("I am helping another customer first. I will get back to you as soon as possible.")
            }
        }
        furhat.attend(originalUser)
        reentry()
    }
}