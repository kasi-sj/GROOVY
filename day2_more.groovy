def function_1(){
    def company = [
        "Engineering" : ["Alice": 5000, "Bob": 4500],
        "Sales" : ["Carol": 3000, "David": 3500],
        "HR" : ["Eve": 4000, "Frank": 3700]
    ]
    company.collectEntries {
        def sum = 0
        it.value.each { 
            jt -> sum += jt.value
        }
        [(it.key) : sum]
    }
}

def function_2(){
    def products = [
        "Electronics" : ["Phone": [500, 550, 600], "Laptop": [1000, 1100, 1200]],
        "Furniture" : ["Table": [200, 250], "Chair": [150, 170]]
    ]
    products.collectEntries {
        it.value.collectEntries {
            jt -> {
                [(jt.key):(jt.value.sum() / jt.value.size())]
            }
        }
    }
}

def function_3(){
    def studentGrades = [
        "John" : ["Math": 85, "English": 78, "Science": 92],
        "Sarah" : ["Math": 88, "English": 90, "Science": 85],
        "Mike" : ["Math": 60, "English": 65, "Science": 70]
    ]
    studentGrades.collectEntries {
        def sum = 0
        it.value.each {jt -> sum += jt.value}
        [(it.key) : Math.round(sum/it.value.size())]
    }
}

def function_4(){
    def warehouseStock = [
        "Warehouse1" : ["Laptop": 10, "Phone": 20, "Tablet": 15],
        "Warehouse2" : ["Laptop": 5, "Phone": 10, "Tablet": 20],
        "Warehouse3" : ["Laptop": 8, "Phone": 12, "Tablet": 7]
    ]
    def ans = [:]
    warehouseStock.each {
        it.value.each {
            jt -> {
                def val = ans[jt.key]?:0
                ans[jt.key] = val+jt.value
            }
        }
    }
    ans
}

def function_5(){
    def cityPopulation = [
        "CityA" : ["District1": 50000, "District2": 75000, "District3": 100000],
        "CityB" : ["District1": 60000, "District2": 85000],
        "CityC" : ["District1": 70000, "District2": 90000, "District3": 110000, "District4": 50000]
    ]
    cityPopulation.collectEntries {
        def sum = 0
        it.value.each {jt -> sum += jt.value}
        [(it.key) : sum]
    }
}

def function_6(){
    def employeeHierarchy = [
        "Engineering" : ["Alice": [25, 6000], "Bob": [30, 4500]],
        "Sales" : ["Carol": [28, 5000], "David": [23, 3500]],
        "HR" : ["Eve": [35, 7000], "Frank": [40, 6500]]
    ]
    employeeHierarchy.collectEntries {
        it.value.collectEntries {jt -> [(jt.key) : it.key]}
    }
}

def function_7(){
    def companyProjects = [
        "CompanyA" : [
            "ProjectX": ["Alice", "Bob", "Carol"],
            "ProjectY": ["Alice", "David"]
        ],
        "CompanyB" : [
            "ProjectZ": ["Bob", "Carol", "Eve"],
            "ProjectW": ["David", "Frank"]
        ]
    ]
    def ans = [:]
    companyProjects.each {
        it.value.each {
            jt -> jt.value.each {
                kt -> {
                    def val = ans[kt]?:0
                    ans[kt] = val + 1
                }
            }
        }
    }
    ans
}

def function_8(){
    def universities = [
        "UniversityA": [
            "Math101" : ["Prof. Smith", "Prof. Johnson"],
            "CS102" : ["Prof. Johnson", "Prof. Williams"]
        ],
        "UniversityB": [
            "Physics101" : ["Prof. Smith", "Prof. Lee"],
            "CS102" : ["Prof. Johnson"]
        ]
    ]
    def ans = [:]
    universities.each {
        it.value.each {
            jt -> {
                jt.value.each {
                    kt -> {
                        def val = ans[kt]?:[].toSet()
                        val.add(it.key)
                        ans[kt] = val
                    }
                }
            }
        }
    }
    ans
}

def function_9(){
    def departmentBudgets = [
        "Engineering": [
            "ProjectX": 100000,
            "ProjectY": 150000
        ],
        "Marketing" : [
            "ProjectA": 50000,
            "ProjectB": 30000
        ],
        "Sales" : [
            "ProjectZ": 80000,
            "ProjectW": 60000
        ]
    ]
    departmentBudgets.collectEntries {
        def sum = 0
        it.value.each {
            jt -> sum += jt.value
        }
        [(it.key) : sum]
    }
}

def function_10(){
    def studentGrades = [
        "John": [
            "Math": 85,
            "English": 78,
            "Science": 92
        ],
        "Sarah": [
            "Math": 88,
            "English": 90,
            "Science": 85
        ],
        "Mike": [
            "Math": 60,
            "English": 65,
            "Science": 70
        ]
    ]
    def tot = [:]
    def cnt = [:]
    studentGrades.each {
        it.value.each {
            jt -> {
                def val = tot[jt.key]?:0
                val += jt.value
                def fre = cnt[jt.key]?:0
                fre += 1
                tot[jt.key] = val
                cnt[jt.key] = fre
            }
        }
    }
    tot.collectEntries {
        [(it.key) : it.value / cnt[it.key]]
    }
}

def function_11(){
    def cityPopulation = [
        "CityA" : [
            "District1": [50000, 52000, 54000],
            "District2": [75000, 78000, 81000]
        ],
        "CityB" : [
            "District1": [60000, 62000, 65000],
            "District3": [70000, 73000, 76000]
        ]
    ]
    def ans = [:]
    cityPopulation.each {
        it.value.each {
            jt -> {
                jt.value.sort()
                def diff = jt.value[-1] - jt.value[0]
                def grow = (diff / jt.value[0])*100
                if(ans[jt.key])return
                ans[jt.key] = Math.round(grow*100)/100
            }
        }
    }
    ans
}

def function_12(){
    def projectSkills = [
        "ProjectX": [
            "Alice": ["Java", "Groovy", "SQL"],
            "Bob": ["Groovy", "Kotlin", "Python"]
        ],
        "ProjectY": [
            "Carol": ["Python", "SQL", "JavaScript"],
            "David": ["JavaScript", "HTML", "CSS"]
        ]
    ]
    projectSkills.collectEntries {
        def skills = [].toSet()
        it.value.each {
            jt -> skills.addAll(jt.value)
        }
        [(it.key) : skills]
    }
}

def function_13(){
    def products = [
        "Electronics": [
            "Laptop": 1000,
            "Phone" : 300,
            "Headphones": 100
        ],
        "Furniture": [
            "Chair" : 150,
            "Table" : 450,
            "Lamp" : 50
        ],
        "Clothing": [
            "Shirt": 40,
            "Jeans": 60,
            "Jacket": 200
        ]
    ]

    def onlyProducts = products.collectEntries {
        it.value.collectEntries { jt -> jt }
    }
    
    onlyProducts.groupBy {
        it.value < 200 ? "Low" : it.value < 500 ? "Medium" : "High"
    }
}

def deepMerge(a , b ){
    if(a == null)return b;
    if(b == null)return a;
    if((a instanceof Map) && (b instanceof Map)){
        def ans = [:]
        a.each {
            def key = it.key
            value = deepMerge(a[key],b[key])
            ans[key]=value
        }
        b.each {
            def key = it.key
            if(a[key] != null)return
            ans[key]=it.value
        }
        ans
    }else if((a instanceof Map)){
        return a
    }else{
        return b
    }
}

def function_14(){
    def userProfile1 = [
        "John": [
            "age" : 30,
            "address": [
                "city": "New York",
                "zip": "10001"
            ],
            "phone": "123-456"
        ]
    ]
    def userProfile2 = [
        "John": [
            "age" : 31,
            "address": [
                "city": "Los Angeles",
                "zip": "90001"
            ],
            "email": "john@example.com"
        ]
    ]
    deepMerge(userProfile1 , userProfile2)
}

def function_15(){
    def company = [
        "Engineering": [
            "Alice" : 85,
            "Bob" : 92,
            "Carol" : 75
        ],
        "Marketing": [
            "David" : 88,
            "Eve" : 91
        ],
        "Sales": [
            "Frank" : 65,
            "Grace" : 78
        ]
    ]
    company.collectEntries {
        [(it.key) : it.value.inject(0) {sum , jt -> sum += jt.value} / it.value.size()]
    }
}

def function_16(){
    def departments = [
        "Engineering": [
            "Alice" : 85,
            "Bob" : 92,
            "Carol" : 75
        ],
        "HR": [
            "David" : 88,
            "Eve" : 81,
            "Frank" : 90
        ],
        "Finance": [
            "Grace" : 95,
            "Hank" : 80
        ]
    ]
    departments.collectEntries {
        def entry = it.value.inject(["value" : 0 , "name" : "nobody"]) { 
            entry , jt -> {
                if(entry.value < jt.value){
                    entry.value = jt.value
                    entry.name = jt.key
                }
                entry
            }
        }
        [(it.key) : [(entry.name) : entry.value]]
    }
}

def function_17(){
    def warehouses = [
        "Warehouse1": [
            "Laptop": 50,
            "Phone" : 100,
            "Tablet": 75
        ],
        "Warehouse2": [
            "Laptop": 30,
            "Phone" : 150,
            "Tablet": 50
        ],
        "Warehouse3": [
            "Laptop": 20,
            "Phone" : 50,
            "Tablet": 100
        ]
    ]
    def quantity = [:]
    warehouses.each {
        it.value.each {
            jt -> {
                def val = quantity[jt.key]?:0
                val += jt.value
                quantity[jt.key] = val
            }
        }
    }
    def ans = [:]
    warehouses.each {
        it.value.each {
            jt -> {
                if(ans[jt.key]==null) ans[jt.key] = [:]
                ans[jt.key][it.key] = "${jt.value}/${quantity[jt.key]} * 100"
            }
        }
    }
    ans
}

def DFS(map , node) {
    if(map[node]==null||map[node]==0)return [(node) : []]
    [(node) : map[node].collectEntries {
        DFS(map , it)
    }]
}

def function_18(){
    def relationships = [
        "CEO" : ["VP1", "VP2"],            
        "VP1" : ["Manager1", "Manager2"],   
        "VP2" : ["Manager3", "Manager4"],   
        "Manager1" : ["Employee1", "Employee2"], 
        "Manager2" : ["Employee3"],         
        "Manager3" : ["Employee4", "Employee5"], 
        "Manager4": ["Employee6"]          
    ]

    def indeg = [:]
    relationships.each {
        indeg[it.key] = 0
    }
    relationships.each {
        it.value.each {
            jt -> {
                if(indeg[jt] == null)indeg[jt] = 0
                indeg[jt] += 1
            }
        }
    }
    def ans = "Found Cycle"
    indeg.each {
        if(it.value == 0){
            ans = DFS(relationships , it.key)
        }
    }
    ans
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
// println function_11()
// println function_12()
// println function_13()
// println function_14()
// println function_15()
// println function_16()
// println function_17()
// println function_18()