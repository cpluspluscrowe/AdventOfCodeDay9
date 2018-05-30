import java.io.File

fun main(args: Array<String>){
    var score = 0
    var level = 1
    var garbageCount = 0
    val charIter: CharIterator = File("./src/input.txt").readText().iterator()
    while(charIter.hasNext()){
        var character = charIter.next()
        while(character == '!'){
            charIter.next()
            character = charIter.next()
        }
        if(character == '{'){
            score += level*1
            level += 1
        }
        if(character == '}'){
            level -= 1
        }
        if(character == '<'){
            while(character != '>'){
                character = charIter.next()
                while(character == '!'){
                    charIter.next() // skip one char
                    character = charIter.next()
                }
                if(character != '>'){
                    garbageCount += 1
                }
            }
        }
    }
    println(score)
    println(garbageCount)
}