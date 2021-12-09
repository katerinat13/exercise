# exercise
Info

**1. Execute program**

get the exercise.jar and run it (_java -jar exercise.jar_)

**2. Create the executable.jar** 

execute _mvn clean compile assembly:single_
and the jar will be created in the target path.

**3. Program logic.(Tips)**

  You will be prompted to enter 1 or 2 for Storing items or get a Report accordingly.

 In case you want to exit, just type "exit" and press enter.

 While on Storing or Report Function you can go back by typing "back" and press enter.

In Storing you should type name, serial number and value separated by comma and press enter.
Then a json file will be created in the path the jar exists.

In Report function, you will be prompted to enter 1 if you want the report to be displayed as html, or 2 if you want to generate a csv report. Type "back" to go back!