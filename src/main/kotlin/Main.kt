enum class Color {
    RED,
    GREEN,
    BLUE,
    GRAY,
    MAGENTA,
    AQUA,
    SILVER,
    YELLOW
}

data class ToDoListItem(var checked: Boolean, var task: String) {
    override fun toString(): String {
        return if(checked)
            "V-$task"
        else
            "X-$task"
    }
}

sealed class NoteContent {
    data class Text(var text: String) : NoteContent() {
        override fun toString(): String {
            return "\n$text"
        }
    }
    data class Image(var path: String) : NoteContent() {
        override fun toString(): String {
            return "\n$path"
        }
    }
    data class ToDoList(var list: List<ToDoListItem>) : NoteContent() {
        override fun toString(): String {
            var res = "\nTo do list:"
            for(item in list)
                res += "\n\t$item"
            return res
        }
    }
}

data class Note(val noteContents: List<NoteContent>, var clr: Color) {
    override fun toString(): String {
        var res = "\nColor: $clr"
        for(content in noteContents) {
            res += "$content"
        }
        return res
    }
}

fun main() {
    val notes: List<Note> = listOf(
        Note(listOf(
            NoteContent.Image("image1.png"),
            NoteContent.Text("To do today:"),
            NoteContent.ToDoList(listOf(
                ToDoListItem(true, "Take a shower"),
                ToDoListItem(false, "Get groceries"),
                ToDoListItem(false, "Take dog on a walk")
            ))), Color.BLUE),
        Note(listOf(
            NoteContent.Image("image2.png"),
            NoteContent.Text("Fancy letters"),
            NoteContent.ToDoList(listOf(
                ToDoListItem(false, "Buy towels"),
                ToDoListItem(false, "Go to the mall")
            ))), Color.RED),
        Note(listOf(
            NoteContent.Image("clouds.png"),
            NoteContent.Text("I'm tired :("),
        ), Color.GREEN),
        Note(listOf(
            NoteContent.Image("calm.jpeg"),
            NoteContent.Text("Everything is fine everything is fine"),
            NoteContent.ToDoList(listOf(
                ToDoListItem(false, "Get breakfast"),
                ToDoListItem(false, "???"),
                ToDoListItem(false, "Good day!")
            ))), Color.GRAY),
        Note(listOf(
            NoteContent.Image("soft_breeze.jpg"),
            NoteContent.Text("I like winter"),
            NoteContent.ToDoList(listOf(
                ToDoListItem(false, "Get breakfast"),
                ToDoListItem(false, "Kick gum"),
                ToDoListItem(false, "Chew ass"),
                ToDoListItem(false, "Good day!")
            ))), Color.MAGENTA),
        Note(listOf(
            NoteContent.Image("people_cheering.jpeg"),
            NoteContent.Text("Big day"),
            NoteContent.ToDoList(listOf(
                ToDoListItem(false, "Dress appropriately"),
                ToDoListItem(false, "Go to uni"),
                ToDoListItem(false, "Get degree")
            ))), Color.SILVER),
        Note(listOf(
            NoteContent.Image("soup.png"),
            NoteContent.Text("I like soup"),
            NoteContent.ToDoList(listOf(
                ToDoListItem(true, "Wait until lunch"),
                ToDoListItem(true, "Eat soup"),
                ToDoListItem(false, "Wait until dinner"),
                ToDoListItem(false, "Eat soup")
            ))), Color.AQUA),
        Note(listOf(
            NoteContent.Image("deer.jpg"),
            NoteContent.Text("Cool deer")),
            Color.YELLOW)
    )

    for(note in notes)
        println(note)
}
