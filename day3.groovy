def function_1(){
    def ip = [
        [name: "John", skills: ["Java", "Groovy"], experience: 5], 
        [name: "Jane", skills: ["Python", "Ruby"], experience: 3] 
    ]

    def op = []
    ip.each {
        it.skills.each {
            jt -> op.add(["name" : it.name , "skills" : jt , "experience" : it.experience])
        }
    }
    op
}

def function_2(){
    def ip = [
        name: "John", 
        addresses: [ 
            [
                city: "New York", 
                zip: "10001", 
                type: "home"
            ], 
            [
                city: "Los Angeles", 
                zip: "90001", 
                type: "work"
            ] 
        ] 
    ]
    def op = []

    ip.addresses.collect {
        ["name" : ip.name , "addresses" : "${it.city}, ${it.zip} (${it.type})"]
    }
}

def function_3(){
    def ip = [ 
        [1, 2, 3], 
        [4, 5, 6], 
        [7, 8, 9] 
    ]
    def op = ip.collect { it }
    for(int j = 0 ; j < ip[0].size() ; j++){
        def col = ip.collect {
            it[j]
        }
        op.add(col)
    }
    op
}

def function_4(){
    def ip = [
        name: "John", 
        pets: [ 
            [name: "Max", type: "dog", age: 3], 
            [name: "Whiskers", type: "cat", age: 5]
        ] 
    ]

    ip.pets.collect {
        ["name" : ip.name , "pet" : "${it.name} (${it.type}, ${it.age} Years)"]
    }
}

def function_5(){
    def ip = [ 
        [name: "John", age: 30, country: "USA"], 
        [name: "Jane", age: 25, country: "Canada"], 
        [name: "Bob", age: 40, country: "Mexico"] 
    ]
    ip.collect {
        def st = it.age.intdiv(10) * 10
        def en = st+9
        ["name" : it.name , "ageGroup" : "${st}-${en}" , "country":it.country] 
    }
}

def function_6(){
    def ip = [ 
        [1, 2, 3], 
        [4, 5, 6], 
        [7, 8, 9] 
    ]
    (0..(ip[0].size()-1)).collect {
        ip.collect {
            jt -> jt[it]
        }
    }
}

def function_7(){
    def ip = [
        name: "John", 
        skills: ["Java", "Groovy"], 
        experience: 5, 
        certifications: ["Oracle Certified Java Programmer", "Groovy Certified Developer"]
    ]
    (0..(ip.skills.size()-1)).collect {
        ["name" : ip.name , "skill" : ip.skills[it] , "experience" : ip.experience , "certification" : ip.certifications[it]]
    }
}

def function_8(){
    def ip = [ 
        [name: "John", age: 30, country: "New York"], 
        [name: "Jane", age: 25, country: "Los Angeles"], 
        [name: "Bob", age: 40, country: "Chicago"] 
    ]
    ip.collect {
        def st = it.age.intdiv(10) * 10
        def en = st+9
        ["name" : it.name , "ageGroup" : "${st}-${en}" , "country":it.country] 
    }
}

def function_9(){
    def ip = [
        name: "John", 
        pets: [ 
            [name: "Max", type: "dog", age: 3], 
            [name: "Whiskers", type: "cat", age: 5]
        ],
        favoriteFood: "Pizza"  
    ]

    ip.pets.collect {
        ["name" : ip.name , "pet" : "${it.name} (${it.type}, ${it.age} Years)" , "favoriteFood": ip.favoriteFood ]
    }
}

def function_10(){
    def ip = [ 
        [1, 2, 3], 
        [4, 5, 6], 
        [7, 8, 9] 
    ]
    def op = []
    for(int i = 0 ; i < ip.size() ; i++){
        if(i%2==0){
            op.add(ip[i])
        }else{
            op.get(op.size()-1).addAll(ip[i])
        }
    }
    op
}
// println function_1()
// println function_2()
// println function_3()
// println function_4()
// println function_5()
// println function_6()
// println function_7()
// println function_8()
// println function_9()
// println function_10()