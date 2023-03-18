The application was created to manage students/grades/exams/subjects/professors in The thechnical high school 
(BTS-Brêvet de technicien supérieur).
The content of the application is in french language.
you'll find a folder named database inside the folder'src', this folder contains the code of the database used
for this system,
the application divided into 3 parts (student/professor/manager of school/college). 
to differ between them, in the database in the table 'Utilisateur' there is a field named 'role' it accepts only 
3 values 'Etudiant' which means student, 'Enseignant' which means Professor and 'Directeur' which means Manager,

By the way, there is only one Manager in the application which is the admin at the same time he can add/delete/modify
studens/professors/subjects/exams/majors/unities(which contains one or more subjects), assign a professor to teach 
one or more subjects in a specific major(or several majors) keeping mind that every major contains 2 levels
(1st year and 2nd year), he can also add students to the class they belong to, in the exam section there are two
types of exams The passing exams for the 1st year and The National exam for the second year
(they are the final exams of each year).

As for the professors, their interfaces contains the classes and major which they are teaching they can add 
continuous monitoring exams for a specific subject to inform the students about the date of it and they can also
add grades of each students after the exam has done.

The students in the system they are just receiving the news related to exams,continuous monitoring exams and the grades
from the professors and manager.

Note : if you want to upload a pictures you got to choose it from the folder 'pictures' it is inside the folder
'WebContent'
Note 2 : the folder 'vpproject' contains UML digrams of our system there are a global usecase diagram and sub usecase
diagrams, sequence diagram of each usecase and the class diagram which the base model of our database





















