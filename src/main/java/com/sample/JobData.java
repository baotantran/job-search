package com.sample;

public class JobData {
    String title;
    String company;
    String salary;

    public JobData(String title, String company, String salary) {
        this.title = title;
        this.company = company;
        this.salary = salary;
    }

    public JobData() {

    }

    public String getCompany() {
        return company;
    }

    public String getSalary() {
        return salary;
    }

    public String getTitle() {
        return title;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format("The job is: %s, with %s, paying %s", this.title, this.company, this.salary);
    }
}
