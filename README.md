# Getting Started

## PS: In case your maven already uses java version > 11, comment toolchain plugin in pom file. 
## Otherwise check your toolchains.xml (pathToApacheMavenFolder/conf/toolchains.xml)
## Example:
    <toolchains>
        <toolchain>
            <type>jdk</type>
            <provides>
                <version>6</version>
            </provides>
            <configuration>
                <jdkHome>C:\Program Files\Java\jdk1.6.0_45</jdkHome>
            </configuration>
        </toolchain>
    
        <toolchain>
            <type>jdk</type>
            <provides>
                <version>8</version>
            </provides>
            <configuration>
                <jdkHome>C:\Program Files\Java\jdk1.8.0_241</jdkHome>
            </configuration>
        </toolchain>
    
        <toolchain>
            <type>jdk</type>
            <provides>
                <version>16</version>
            </provides>
            <configuration>
                <jdkHome>C:\Program Files\Java\jdk-16</jdkHome>
            </configuration>
        </toolchain>
    </toolchains>

## Steps
    - Install docker (Tested on linux containers)
    - Run: 'mvn clean package -Pdocker' to generate jar file
    - Go to your project folder and run 'docker-compose config' to check for docker-compose file errors
    - Run docker-compose up --build
    - If you have Mongo Compass, access using this connection string:
        -   mongodb://root:root@localhost:27017/test?authSource=test&readPreference=primary&appname=MongoDB%20Compass&ssl=false
    
## Using Intellij Http Request to test:

    POST http://localhost:8081/spring-data-mongo-db/customer
    accept: application/json;charset=UTF-8
    Content-Type: application/json;charset=UTF-8
    
    {
        "firstName": "Teste",
        "lastName": "Teste"
    }

    GET http://localhost:8081/spring-data-mongo-db/customer
    accept: application/json;charset=UTF-8
    Content-Type: application/json;charset=UTF-8
