package com.HZ_A9.mysql.student.studentDao;

import com.HZ_A9.entities.Student;

public interface studentDao {
    abstract void showStudentInfo(Student student);
    abstract boolean downloadChooseCourseInfo(Student student);
    abstract boolean chooseCourse(Student student);
    abstract boolean updateStudentPassword(Student student);
}
