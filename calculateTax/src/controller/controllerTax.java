package controller;

import model.person;
import view.viewTax;

/**
 *
 * @author THANH HUYEN
 */
public class controllerTax {

    viewTax v = new viewTax();

    public void run() {
        person p = v.inputPerson();
//        v.displayPerson(p);
        System.out.println();
        v.displayDetail(p);
        System.out.println();
        v.displayPerson(p);
    }
}
