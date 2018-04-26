package com.demo;

/**
 * Created by Autumn on 2018/4/26.
 */
public class Main {
    public static void main(String[] args) {
        MedicineList medicineList = new MedicineList();
        IVisitor casherVisitor = new CasherVisitor();
        IVisitor pharmacistsVisitor = new PharmacistsVisitor();
        medicineList.accept(casherVisitor);
        medicineList.accept(pharmacistsVisitor);

    }
}
