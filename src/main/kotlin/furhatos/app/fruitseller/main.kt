package furhatos.app.fruitseller

import furhatos.app.fruitseller.flow.*
import furhatos.app.fruitseller.flow.main.Greeting
import furhatos.skills.Skill
import furhatos.flow.kotlin.*

class FruitSellerSkill : Skill() {
    override fun start() {
        Flow().run(Greeting)
    }
}

fun main(args: Array<String>) {
    Skill.main(args)
}
