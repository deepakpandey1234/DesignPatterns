package com.deepak.behavioural.iterator;

interface ItemIterator {
    public Item getFirst();

    public Item getLast();

    public Item get(int index);

    public Item next();

    public Item previous();

    public int getCount();
}

/**
 * Created by panded4 on 9/8/2016.
 * user defined Iterator
 * Example : collection framework iterator
 * Resultset
 */
class Item {
    String name;
    int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

class Menu {
    int count = 0;
    int index = 0;

    Item menuItem[] = new Item[50];

    public void addItem(Item item) {
        menuItem[count++] = item;
    }

    public ItemIterator getIterator() {
        return new MenuIterator();
    }

    class MenuIterator implements ItemIterator {
        @Override
        public Item getFirst() {
            return menuItem[0];
        }

        @Override
        public Item getLast() {
            index = count - 1;
            return menuItem[index];
        }

        @Override
        public Item get(int index) {
            if (index < count && index >= 0) {
                return menuItem[index];
            }
            return null;
        }

        @Override
        public Item next() {
            index++;
            if (index >= count)
                index = 0;
            return menuItem[index];
        }

        @Override
        public Item previous() {
            index--;
            if (index < 0)
                index = count - 1;
            return menuItem[index];
        }

        @Override
        public int getCount() {
            return count;
        }
    }
}

public class IteratorDemo {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.addItem(new Item("pen", 50));
        menu.addItem(new Item("abc", 50));
        menu.addItem(new Item("pencil", 50));
        menu.addItem(new Item("hahah", 50));
        menu.addItem(new Item("xyz", 50));
        menu.addItem(new Item("pekisadan", 50));
        menu.addItem(new Item("hshhash", 50));
        ItemIterator itemIterator = menu.getIterator();
        System.out.println(itemIterator.getCount());

    }
}
