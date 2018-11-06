package lab5

class Isogram {
    companion object {
        fun isIsogram(string: String): Boolean {

            var filteredString =
                    string
                            .toLowerCase()
                            .replace("-", "")
                            .replace(" ", "")

            var comparison = filteredString
                    .toSet()
                    .size
                    .compareTo(filteredString
                            .toCharArray()
                            .size)

            when (comparison) {
                0 -> return true
                else -> return false
            }
        }

    }
}

class WordCount {
    companion object {
        fun phrase(string: String): Map<String, Int> {

            var cleanString = string
                    .toLowerCase()
                    .replace(":", " ")
                    .replace(".", " ")
                    .replace("\n", " ")
                    .replace(",", " ")
                    .replace(" '", " ")
                    .replace("' ", " ")


            var rtrnvar = cleanString
                    .split(' ')
                    .groupingBy { it }
                    .eachCount()

            return rtrnvar

        }


    }
}

class IsbnVerifier {

    fun isValid(text: String): Boolean = text
            .toLowerCase()
            .replace("-", "")
            .matches(Regex(pattern = "^\\d{9}[\\d|x]$"))
            .compareTo(true)
            .toString()
            .replace("0", text
                    .toLowerCase()
                    .replace("-", ""))
            .dropLast(1).foldIndexed(text
                    .toLowerCase()
                    .replace("-", "")
                    .matches(Regex(pattern = "^\\d{10}$"))
                    .compareTo(true)
                    .toString()
                    .replace("0", (text
                            .toLowerCase()
                            .replace("-", "")
                            .lastOrNull())
                            .toString())
                    .replace("-1", "10")
                    .toInt())
            { i, acc, c -> acc + (c - '0') * (10 - i) }.rem(11) == 0

}


