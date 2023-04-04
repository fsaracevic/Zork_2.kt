import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val roomDescription = "You are in a dark room. There is a locked door to the north."
    var hasKey = false
    var hasKnife = false
    var isMonsterDead = false
    var currentRoom = ""
    var inMonsterRoom = false

    while (!currentRoom.contains("Congratulations! You got out!")) {
        currentRoom = roomDescription

        if (inMonsterRoom) {
            currentRoom = "You are in a dark room. There is a door to the north."
            if (!isMonsterDead) {
                currentRoom += "A monster is in front of you."
            }
        } else {
            if (!hasKey) {
                currentRoom += " There is a key on the table."
            }
            if (!hasKnife) {
                currentRoom += " There is a knife on the table."
            }
        }

        println(currentRoom)
        print("> ")

        val input = scanner.nextLine()

        when (input) {
            "go north" -> {
                if (currentRoom.contains("locked") && !inMonsterRoom) {
                    println("The door is locked. You need a key to unlock it.")
                } else if (inMonsterRoom && !isMonsterDead) {
                    println("You can't go north, there is a monster in front of you.")
                } else if (inMonsterRoom && isMonsterDead) {
                    println("Congratulations! You got out!")
                    currentRoom = "Congratulations! You got out!"
                }
            }
            "pick up key" -> {
                if (!hasKey && !inMonsterRoom) {
                    hasKey = true
                    println("You picked up the key.")
                } else {
                    println("There is nothing to pick up.")
                }
            }
            "pick up knife" -> {
                if (!hasKnife && !inMonsterRoom) {
                    hasKnife = true
                    println("You picked up the knife.")
                } else {
                    println("There is nothing to pick up.")
                }
            }
            "use key" -> {
                if (hasKey && currentRoom.contains("locked") && !inMonsterRoom) {
                    inMonsterRoom = true
                    println("You unlocked the door and entered the room with the monster.")
                } else if (hasKey) {
                    println("There is nothing to unlock.")
                } else {
                    println("You don't have a key.")
                }
            }
            "use knife" -> {
                if (hasKnife && inMonsterRoom && !isMonsterDead) {
                    isMonsterDead = true
                    println("You killed the monster.")
                } else if (hasKnife) {
                    println("There is nothing to attack.")
                } else {
                    println("You don't have a knife.")
                }
            }
            else -> {
                println("I don't know what you want.")
            }
        }
    }
}
