package com.atguigu4.exer;

/**
 * @Author: caitonggang
 * @Description: TODO
 * @Date: 2020/4/21 11:21
 * @Version 1.0
 */
///*
//        FlowID:
    //    Type:
    //    IDCard:
    //    ExamCard:
    //    StudentName:
    //    Location:
    //    Grade:
    //
// */
public class Student {
    private int flowID;
    private int Type;
    private String IDCard;
    private String ExamCard;
    private String StudentName;
    private String Location;
    private int grade;

    public Student() {
    }

    public Student(int flowID, int type, String IDCard, String examCard, String studentName, String location, int grade) {
        this.flowID = flowID;
        Type = type;
        this.IDCard = IDCard;
        ExamCard = examCard;
        StudentName = studentName;
        Location = location;
        this.grade = grade;
    }

    public int getFlowID() {
        return flowID;
    }

    public void setFlowID(int flowID) {
        this.flowID = flowID;
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }

    public String getExamCard() {
        return ExamCard;
    }

    public void setExamCard(String examCard) {
        ExamCard = examCard;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        System.out.println("=========查询结果===========");
        return info();
    }
    private String info() {
        return "流水号：" + flowID + "\n四级/六级：" + Type + "\n身份证号：" + IDCard + "\n准考证号：" + ExamCard +
                "\n学生姓名：" + StudentName + "\n区域：" + Location + "\n成绩：" + grade;
    }

}
