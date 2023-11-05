package phuc.topomodoro.service;

import phuc.topomodoro.entity.Item;

import java.util.List;
import java.util.Optional;

public interface TodoService {
    List<Item> getItems();
    Item getItem(Integer id);
    List<Item> saveItems(List<Item> items);
    void deleteItems(List<Integer> ids);
}
