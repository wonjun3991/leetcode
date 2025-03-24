class Solution {
    fun countDays(days: Int, meetings: Array<IntArray>): Int {
        if (meetings.any{meeting -> meeting[0] == 1 && meeting[1] == days}){
            return 0
        }

        val daysArray: Array<Int> = Array(days + 2) { 0 }

        meetings.forEach { meeting ->
            daysArray[meeting[0]] = daysArray[meeting[0]] + 1
            daysArray[meeting[1] + 1] = daysArray[meeting[1] + 1] - 1
        }

        var count = 0
        var inMeeting = 0
        daysArray.forEach {
            inMeeting += it
            if (inMeeting == 0){
                count++
            }
        }

        return count - 2
    }
}

// 0 1 2 3 4  5 6 7 8 9 10 
//   1     -1 1 0 0 -1 1 0 -1