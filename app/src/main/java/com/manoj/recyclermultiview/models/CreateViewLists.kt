package com.manoj.recyclermultiview.models

import com.manoj.recyclermultiview.constants.AppConstants

class CreateViewLists {

  companion object{

   fun getTeachersList(): MutableList<ClassMember> {
        return createTeachersList()
    }

    fun getStudentsList(): MutableList<ClassMember> {
        return createStudentsList()
    }

    private fun createTeachersList(): MutableList<ClassMember> {
        val teachers = mutableListOf<ClassMember>()
        teachers.add(ClassMember(1, "Sajitha"))
        teachers.add(ClassMember(2, "Saranya"))
        teachers.add(ClassMember(3, "Soumya"))
        teachers.add(ClassMember(4, "Savithri"))
        teachers.add(ClassMember(5, "Sangeetha"))
        teachers.add(ClassMember(1, "Sajitha"))
        teachers.add(ClassMember(2, "Saranya"))
        teachers.add(ClassMember(3, "Soumya"))
        teachers.add(ClassMember(4, "Savithri"))
        teachers.add(ClassMember(5, "Sangeetha"))
        return teachers
    }

    private fun createStudentsList(): MutableList<ClassMember> {
        val student = mutableListOf<ClassMember>()
        student.add(ClassMember(1, "John"))
        student.add(ClassMember(2, "Jomon"))
        student.add(ClassMember(3, "Jithin"))
        student.add(ClassMember(4, "Jaison"))
        student.add(ClassMember(5, "Jeevan"))
        student.add(ClassMember(1, "John"))
        student.add(ClassMember(2, "Jomon"))
        student.add(ClassMember(3, "Jithin"))
        student.add(ClassMember(4, "Jaison"))
        student.add(ClassMember(5, "Jeevan"))
        return student
    }

    fun createHeaderType(header:String):ClassMember {
        return ClassMember(1, header,AppConstants.ViewType.HEADER)
    }

    fun createFooterType(header:String):ClassMember {
        return ClassMember(1, header,AppConstants.ViewType.FOOTER)
    }
  }
}