package org.example;

class Main {
    public static void main(String[] args) {
        Student student = new StudentBuilderImpl().setStudent("Ann","Smith","Oxford").setBirthday("01.01.2000").setGroup("CS31").build();
        System.out.println(student.toString());
    }
}

 class Student {
    String name, surname, birthday, parentsName, university, group, MagisterTopic, SpecialistTopic;

    @Override
    public String toString() {
        return "Student's name: " + name + '\n' +
               "surname: " + surname + '\n' +
               "birthday: " + birthday + '\n' +
               "parentsName: " + parentsName + '\n' +
               "university: " + university + '\n' +
               "group: " + group + '\n' +
               "MagisterTopic: " + MagisterTopic + '\n' +
               "SpecialistTopic: " + SpecialistTopic + '\n' + '\n';
    }

}

interface StudentBuilder {
    StudentBuilder setStudent(String name, String surname,String university); //об'явили обов'язкові параметри
    StudentBuilder setParentsName(String parentsName);
    StudentBuilder setBirthday(String birthday);
    StudentBuilder setGroup(String group);
    StudentBuilder setMagisterTopic(String MagisterTopic);
    StudentBuilder setSpecialistTopic(String SpecialistTopic);
    Student build();
}


class StudentBuilderImpl implements StudentBuilder {
    Student student = new Student();
    @Override
    public StudentBuilder setStudent(String name, String surname, String university) {
        student.name = name;
        student.surname = surname;
        student.university = university;
        return this;
    }

    @Override
    public StudentBuilder setParentsName(String parentsName) {
        student.parentsName = parentsName;
        return this;
    }

    @Override
    public StudentBuilder setBirthday(String birthday) {
        student.birthday = birthday;
        return this;
    }

    @Override
    public StudentBuilder setGroup(String group) {
        student.group = group;
        return this;
    }

    @Override
    public StudentBuilder setMagisterTopic(String MagisterTopic) {
        student.MagisterTopic = MagisterTopic;
        return this;
    }

    @Override
    public StudentBuilder setSpecialistTopic(String SpecialistTopic) {
        student.SpecialistTopic = SpecialistTopic;
        return this;
    }

    @Override
    public Student build() {
       return student;
    }
}