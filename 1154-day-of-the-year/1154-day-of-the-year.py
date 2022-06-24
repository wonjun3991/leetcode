import datetime 

class Solution:
    def dayOfYear(self, date_string: str) -> int:
        currentDate = date.fromisoformat(date_string)
        day_of_year = currentDate.timetuple().tm_yday
        return day_of_year
        