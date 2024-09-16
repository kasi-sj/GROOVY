def function_1(){
    def numbers = [1, 2, 3, 4, 5]
    numbers.collect {
        it*it
    }
}

def function_2(){
    def names = ["Alice", "Bob", "Carol"]
    names.collect {
        it.toUpperCase()
    }
}

def function_3(){
    def words = ["apple", "banana", "pear"]
    words.collect {
        it.length()
    }
}

def function_4(){
    def items = ["Book", "Pen", "Laptop"]
    items.collect {
        "item:  ${it}"
    }
}

def function_5(){
    def pricesInDollars = [10, 20, 30, 40]
    pricesInDollars.collect {
        it*0.85 
    }
}

def function_6_1(){
    def numbers = [1, 3, 5, 8, 9]
    numbers.find {
        it == 8
    }
}

def function_6_2(){
    def numbers = [10, 25, 60, 80]
    numbers.find {
        it == 60
    }
}


def function_7_1(){
    def names = ["Bob", "Alice", "Charlie"]
    names.find {
        it == "Alice"
    }
}

def function_7_2(){
    def words = ["dog", "catalog", "rat", "scatter"]
    words.find {
        it == "catalog"
    }
}

def function_8(){
    def products = [
        [name: "Laptop", price: 1200],
        [name: "Phone", price: 800],
        [name: "Tablet", price: 600]
    ]
    products.find {
        it.name == "Laptop" && it.price == 1200
    }
}

def function_9() {
    def numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    numbers.findAll {
        it%2 == 0
    }
}

def function_10(){
    def names = ["Alice", "Bob", "Sarah", "Steve", "Carol"]
    names.findAll {
        it.startsWith("S")
    }
}

def function_11(){
    def numbers = [25, 60, 75, 30, 10, 80]
    numbers.findAll {
        it > 50
    }
}

def function_12(){
    def words = ["apple", "banana", "pear", "plum", "grape"]
    def set = [].toSet()
    words.findAll {
        if(set.contains(it[0]))return false
        set.add(it[0])
        return true
    }
}

def function_13(){
    def products = [
        [name: "Laptop", price: 1000],
        [name: "Phone", price: 500],
        [name: "Tablet", price: 300]
    ]
    products.findAll {
        it.price == 1000
    }
}

def function_14(){
    def products = [Laptop: 1000, Phone: 500, Tablet: 300]
    products.each {
        println "${it.key}: costs ${it.value}"
    }
}

def function_15(){
    def numbers = [5, 10, 15, 20]
    def sum = 0
    numbers.each {
        sum += it
    }
    sum
}

def function_16(){
    def stock = [Apples: 50, Bananas: 30, Oranges: 20]
    stock.each {
        it.value += 10
    }
}

def function_17(){
    def products = [Laptop: 1000, Phone: 500, Tablet: 300] 
    products.collectEntries {
        [(it.key) , (int)(it.value*0.8)]
    }
}

def function_18(){
    def names = ["Alice", "Bob", "Carol"]
    names.collectEntries {
        [(it) : it.length()]
    }
}

def function_19(){
    def stock = [Laptop: 5, Phone: 0, Tablet: 3]
    stock.collectEntries {
        [(it.key) : it.value == 0 ? "Out of Stock" : "In Stock"]
    }
}

def function_20(){
    def numbers = [one: 1, two: 2, three: 3, four: 4]
    numbers.collectEntries {
        [(it.key) : it.value*2]
    }
}

def function_21(){
    def countries = ["Canada", "Australia", "India", "Germany"]
    countries.collectEntries {
        [(it) : it[0..3].toUpperCase()]
    }
}

def function_22(){
    def numbers = [10, 20, 30, 40]
    numbers.eachWithIndex {
        it , ind -> println("${ind} ${it}")
    }
}

def function_23(){
    def numbers = [1, 2, 3, 4]
    def sum = 0
    numbers.eachWithIndex {
        it , ind -> sum += it*ind
    }
    sum
}

def function_24(){
    def items = ["Apple", "Banana", "Mango"]
    items.withIndex().collectEntries {
        it , ind -> [(ind) : it]
    }
}

def function_25(){
    def products = ["Laptop", "Phone", "Tablet"]
    products.withIndex().collectEntries {
        it , ind -> [(it) : "P${ind+1}"]
    }
}

def function_26(){
    def numbers = [10, 20, 30, 40, 50] 
    numbers.withIndex().collect {
        it , ind -> ind%2==1 ? -1 : it
    }
}

// println function_1()
// println function_2()
// println function_3()
// println function_4()
// println function_5()


// println function_6_1()
// println function_7_1()
// println function_6_2()
// println function_7_2()
// println function_8()

// println function_9()
// println function_10()
// println function_11()
// println function_12()
// println function_13()

// function_14()
// println function_15()
// println function_16()

// println function_17()
// println function_18()
// println function_19()
// println function_20()
// println function_21()

// function_22()
// println function_23()

// println function_24()
// println function_25()
// println function_26()