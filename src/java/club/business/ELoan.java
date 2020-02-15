// ELoan maintains a list of item values with quantity on hand (QOH)
package club.business;

import club.data.BookIO;
import java.io.Serializable;
import java.util.*;

public class ELoan implements Serializable {

    private static ArrayList<Book> items;

    public ELoan() {
    }

    public static ArrayList loadItems(String path) {
        if (items == null) {
            items = BookIO.getBooks(path);
        }
        // manually add books if books.txt is not found or empty
        if (items == null || items.size() <= 0) {
            items = new ArrayList();
            items.add(new Book("201", "Murach Java Servlet and JSP", 2));
            items.add(new Book("301", "Essential C#", 3));
            items.add(new Book("401", "Workflow Modeling", 1));
        }
        return items;
    }

    public static Book getItem(String code) {
        Book foundItem = null;
        for (int i = 0; i <
                items.size(); i++) {
            Book curItem = (Book) items.get(i);
            if (curItem.getCode().equals(code)) {
                foundItem = curItem;
                break;
            }
        }
        return foundItem;
    }

    public static void subtractFromQOH(String code, int qty) {
        int onHand = 0;
        for (int i = 0; i <
                items.size(); i++) {
            Book curItem = (Book) items.get(i);
            if (curItem.getCode().equals(code)) {
                onHand = curItem.getQuantity();
                if (onHand > 0) {
                    curItem.setQuantity(onHand - qty);
                }
                break;
            }

        }
    }

    public static void addToQOH(String code, int qty) {
        int onHand = 0;
        for (int i = 0; i <
                items.size(); i++) {
            Book curItem = (Book) items.get(i);
            if (curItem.getCode().equals(code)) {
                onHand = curItem.getQuantity();
                curItem.setQuantity(onHand + qty);
                break;

            }
        }
    }

    public static int getQOH(String code) {
        int onHand = 0;
        for (int i = 0; i <
                items.size(); i++) {
            Book curItem = (Book) items.get(i);
            if (curItem.getCode().equals(code)) {
                onHand = curItem.getQuantity();
                break;
            }
        }
        return onHand;
    }
}

