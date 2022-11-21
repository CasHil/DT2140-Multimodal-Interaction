package furhatos.app.fruitseller.flow

import furhatos.app.fruitseller.flow.main.Idle
import furhatos.flow.kotlin.*

val Parent: State = state {
    onUserLeave(instant = true) {
        when {
            users.count == 0 -> goto(Idle)
            it == users.current -> furhat.attend(users.other)
        }
    }

    onUserEnter {
        val originalUser = users.current
        furhat.glance(it)
        when {
            users.count >= 2 -> furhat.say("I am helping another customer first. I will get back to you as soon as possible.")
        }
        furhat.glance(originalUser)
        reentry()
    }
}