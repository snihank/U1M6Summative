package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.Item;

import java.util.List;

public interface ItemDao {
<<<<<<< HEAD

=======
>>>>>>> d0a8ae62bb60ab7ac7f379a3116429c38169f189
    Item addItem(Item item);
    Item getItem(int id);
    List<Item> getAllItems();
    void updateItem(Item item);
    void deleteItem(int id);
}
