import java.time.Period
import java.time.LocalDate
def function_1(){
    // Convert the date "2024-10-01" into the string format "01-Oct-2024"
    def date = Date.parse("yyyy-MM-dd" , "2024-10-01");
    def newDateString = date.format("dd-MMM-yyyy")
    println newDateString
}

def function_2(){
    // Subtract 5 weeks from the date "2024-12-01" and return the result.
    def date = Date.parse("yyyy-MM-dd" , "2024-12-01");
    date -= 5*7
    println date.format("yyyy-MM-dd")
}

def function_3(){
    // Find the date of the first Monday of the month for the given date "2024-07-15".
    def weekDayMap = [Sun : 0 , Mon : 1 , Tue : 2 , Wed : 3 , Thu : 4 , Fri : 5 , Sat : 6]
    def date = Date.parse("yyyy-MM-dd","2024-07-15")
    def weekDay = date.format("EE")
    def dateNo = Integer.parseInt(date.format("dd"))
    def nearMondayDiff =  (weekDayMap[weekDay] - 1)
    def newDateNo = (dateNo - nearMondayDiff + 7)%7
    def firstMonday = date - (dateNo - newDateNo)
    println firstMonday.format("yyyy-MM-dd")
}


def function_4(){
    // Calculate the age of a person born on "1995-10-12" as of today’s date
    def dateOfBirth = Date.parse("yyyy-MM-dd","1995-10-12")
    def today = new Date()
    def diff = {
        s1,s2 -> Integer.parseInt(s1) - Integer.parseInt(s2)
    }
    def yearDiff = diff(today.format("YYYY") , dateOfBirth.format("YYYY"))
    def monthDiff = diff(today.format("MM") , dateOfBirth.format("MM"))
    def dateDiff = diff(today.format("dd") , dateOfBirth.format("dd"))
    if(monthDiff > 0 || (monthDiff == 0 && dateDiff >= 0)){
        println "the age of the person is ${yearDiff}"
    }else {
        println "the age of the person is ${yearDiff-1}"
    }
}

def function_5(){
    // Problem: Given the date "2023-05-15", check if it is before today’s date.
    def date = Date.parse("yyyy-MM-dd","2023-05-15")
    def today = new Date()
    if(date < today){
        println "the date is in past"
    }else {
        println "the date is not in past"
    }
}

def function_6(){
    //Problem: Given a date "2024-09-27" (a Friday), return the next business day
    def publicHoliday = ["2024-09-30"].toSet()
    def date = Date.parse("yyyy-MM-dd" , "2024-09-27")
    date++;
    while(true){
        def week = date.format("EE")
        if("Sun" == week || "Sat" == week || publicHoliday.contains(date.format("yyyy-MM-dd")))date +=1
        else break
    }
    println date.format("yyyy-MM-dd")
}

def function_7(){
    // Calculate the age of a person born on "1995-10-12" as of today’s date
    def dateOfBirth = LocalDate.parse("1990-05-15")
    def today =  LocalDate.parse(new Date().format("yyyy-MM-dd"))
    def age = Period.between(dateOfBirth,today)
    println "Age: ${age.years} years, ${age.months} months, ${age.days} days"
}

def function_8(){
    //Problem: Given the year 2024, list all the Fridays of that year in the yyyy-MM-dd format.
    def getYearOfTheDate = {
        date -> Integer.parseInt(date.format("yyyy"))
    }
    def getWeekOfTheDate = {
        date -> date.format("EE")
    }
    def currentYear = getYearOfTheDate(new Date())
    def date = Date.parse("dd-MM-yyyy","01-01-${currentYear}")
    while(getYearOfTheDate(date) == currentYear){
        if(getWeekOfTheDate(date) == "Fri") println date.format("yyyy-MM-dd")
        date++;
    }
}

def function_9() {
    // Find the Date of Easter for a Given Yea
    int year = 2025
    int a = year % 19
    int b = year / 100
    int c = year % 100
    int d = b / 4
    int e = b % 4
    int f = (b + 8) / 25
    int g = (b - f + 1) / 3
    int h = (19 * a + b - d - g + 15) % 30
    int i = c / 4
    int k = c % 4
    int l = (32 + 2 * e + 2 * i - h - k) % 7
    int m = (a + 11 * h + 22 * l) / 451
    int month = (h + l - 7 * m + 114) / 31
    int day = ((h + l - 7 * m + 114) % 31) + 1

    def easterDate = new GregorianCalendar(year, month - 1, day).time
    println easterDate.format("yyyy-MM-dd")
}

def function_10(){
    // Problem: Write a Groovy function that validates a given date range, "2024-01-15" to
    //"2024-12-30", and splits it into intervals of 60 days each.
    def startDate = Date.parse("yyyy-MM-dd" , "2024-01-15")
    def endDate = Date.parse("yyyy-MM-dd" , "2024-12-30")
    def format = {
        d -> d.format("yyyy-MM-dd")
    }
    for(;startDate <= endDate ; startDate+=61){
        def nextDate = startDate + 60
        nextDate = nextDate < endDate ? nextDate : endDate
        println "[${format(startDate)} to ${format(nextDate)}]"
    }
}

def function_11(){
    //Problem: Given two date ranges, "2024-05-10" to "2024-07-15" and "2024-06-01" to
    //"2024-08-01", find the overlapping date range
    def isBetween = {
        sd1 , ed1 , sd2 , ed2 -> {
            return sd1 <= sd2 && ed2 <= ed1
        }
    }

    def format = {
        d -> d.format("yyyy-MM-dd")
    }

    def sd1 = Date.parse("yyyy-MM-dd" , "2024-05-10")
    def ed1 = Date.parse("yyyy-MM-dd" , "2024-07-15")
    def sd2 = Date.parse("yyyy-MM-dd" , "2024-06-01")
    def ed2 = Date.parse("yyyy-MM-dd" , "2024-08-01")

    if(isBetween(sd1,ed1,sd2,ed2)){
        println "${format(sd2)} to ${format(ed2)}"
    }else if(isBetween(sd2,ed2,sd1,ed1)){
        println "${format(sd1)} to ${format(ed1)}"
    }else{
        def maxStartDate = sd1 > sd2 ? sd1 : sd2
        def minEndDate = ed1 < ed2 ? ed1 : ed2
        println "${format(maxStartDate)} to ${format(minEndDate)}"
    }
}

def function_12(){
    // Generate a List of Dates Excluding Weekends
    def startDate = Date.parse("yyyy-MM-dd" , "2024-01-01")
    def endDate = Date.parse("yyyy-MM-dd" , "2024-01-31")
    def format = {
        d -> d.format("yyyy-MM-dd")
    }
    for(;startDate <= endDate ; startDate++){
        if(startDate.format("EE") == "Sun" || startDate.format("EE") == "Sat")continue
        println "${format(startDate)}"
    }
}

def function_13(){
    //Problem: Given the start date "2024-09-01" and end date "2024-09-30", calculate
    //the total number of working days (excluding weekends and public holidays). Assume
    //"2024-09-15" is a public holiday.
    def publicHoliday = ["2024-09-15"].toSet()
    def startDate = Date.parse("yyyy-MM-dd" , "2024-09-01")
    def endDate = Date.parse("yyyy-MM-dd" , "2024-09-30")
    def format = {
        d -> d.format("yyyy-MM-dd")
    }
    def count = 0
    while(startDate <= endDate){
        def week = startDate.format("EE")
        if("Sun" == week || "Sat" == week || publicHoliday.contains(startDate.format("yyyy-MM-dd")))startDate +=1
        else {
            count++
            startDate += 1
        }
    }
    println count
}

def function_14(){
    // Problem: Given a date "2024-10-05", find the day number of the year (i.e., how
    // many days have passed since January 1st, 2024).
    def date = Date.parse("yyyy-MM-dd" , "2024-10-05")
    println date.format("DD")
}

def function_15(){
    // Problem: Given the date range "2024-01-01" to "2024-12-31", find all the dates that
    // fall on a Tuesday within that range.
    def startDate = Date.parse("yyyy-MM-dd" , "2024-01-01")
    def endDate = Date.parse("yyyy-MM-dd" , "2024-12-31")
    def format = {
        d -> d.format("yyyy-MM-dd")
    }
    while(startDate <= endDate){
        def week = startDate.format("EE")
        if("Tue" == week){
            println format(startDate)
        }
        startDate += 1
    }
}

// function_1()
// function_2()
// function_3()
// function_4()
// function_5()
// function_6()
// function_7()
// function_8()
// function_9()
// function_10()
// function_11()
// function_12()
// function_13()
// function_14()
// function_15()