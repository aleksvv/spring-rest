dependencies {
    compile("org.springframework.boot:spring-boot-devtools")
    compile("com.jayway.jsonpath:json-path:2.4.0")
    
    testCompile("org.junit.jupiter:junit-jupiter-api")
    testRuntime("org.junit.jupiter:junit-jupiter-engine")
    testCompile("org.springframework.boot:spring-boot-starter-test")
}

tasks.test {
    useJUnitPlatform()
}