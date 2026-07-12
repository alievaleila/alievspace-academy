package com.example.library_management_system;

class Magazine extends Publication implements Borrowable {

    private int issueNumber;

    public Magazine(String title, int year, int issueNumber) {
        super(title, year);
        this.issueNumber = issueNumber; }

    @Override
    void displayInfo() {
        System.out.println("Magazine: " + getTitle() + ", Issue: " + issueNumber); }

    public void borrowItem(String user) { setBorrowedBy(user); }
    public void returnItem() { setBorrowedBy(null); }
}