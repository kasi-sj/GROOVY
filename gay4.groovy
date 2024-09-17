
import java.time.Year
import java.time.LocalDate
def function_practice(){
    def date = new Date()

    // Date
    println date.format("dd") // date of the month [01-31]
    println date.format("DD") // date of the year [001-366]
    println date.format("MM") // month in number [01-12]
    println date.format("MMM") // month in words (4 letter) [Jan-Dec]
    println date.format("MMMM") // month in words [January-December]
    println date.format("E") // day of week in (3 letter) [Sun-Sat]
    println date.format("EEEE") // day of week in words [Sunday-Saturday]
    println date.format("yy") // year in 2 digits [00-99]  
    println date.format("yyyy") // year in 4 digits [0000-9999]

    // Time
    println date.format("HH") // hour in 24 hour format [00-23]
    println date.format("hh") // hour in 12 hour format [01-12]
    println date.format("mm") // minute [00-59]
    println date.format("ss") // second [00-59]
    println date.format("SSS") // millisecond [000-999]
    println date.format("a") // AM/PM

    // Timezone
    println date.format("z") // timezone [PST, PDT, CST, CDT, EST, EDT, GMT, IST]
    println date.format("Z") // timezone offset [+0530]
}

def function_1(){
    def today = new Date()
    println today.format("yyyy-MM-dd")
}

def function_2(){
    def today = new Date()
    def tomorrow = today + 1
    println tomorrow.format("yyyy-MM-dd")
}

def function_3(){
    def day1 = Date.parse("yyyy-MM-dd","2024-09-01")
    def day2 =  Date.parse("yyyy-MM-dd" , "2024-09-16")
    println day2-day1
}

def function_4(){
    def s = "2024-09-16"
    def date = Date.parse("yyyy-MM-dd" , s);
    println date.format("dd/MM/yyyy")
}

def function_5(){
    def date = Date.parse("yyyy-MM-dd","2024-09-16")
    def plus = 10
    def newDate = date+plus
    println newDate.format("yyyy-MM-dd")
}

def function_6(){
    // we can use java.time.Year library
    def year = 2024
    if(Year.of(year).isLeap()){
        println "${year} is a Leap Year"
    }else{
        println "${year} is not a Leap Year"
    }
}

def function_7(){
    def date = Date.parse("yyyy-MM-dd","2024-09-16")
    println date.format("EEEE")
}

def function_8(){
    // we need to use LocalDate class to minus month
    def date = LocalDate.parse("2024-09-16")
    def newdate = date.minusMonths(1)
    println newdate
}

def function_9(){
    // we need to use LocalDate class to minus month
    def date = LocalDate.parse("2024-09-16")
    def newdate = date.withDayOfMonth(1)
    println newdate.format("EEEE")
}

def function_10(){
    def date1 = Date.parse("yyyy-MM-dd","2024-09-16")
    def date2 = Date.parse("yyyy-MM-dd","2024-08-16")
    if(date1 == date2){
        println "Same"
    }else if(date1 < date2){
        println "Earlier"
    }else{
        println "Later"
    }
}
// function_practice()
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