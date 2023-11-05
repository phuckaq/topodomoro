package phuc.topomodoro.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import phuc.topomodoro.entity.Item;
import phuc.topomodoro.service.TodoService;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoApi {

    @Autowired
    private TodoService todoService;

    @GetMapping("/items")
    public List<Item> getItems() {
        return todoService.getItems();
    }

    @GetMapping("/item/{id}")
    public Item getItem(@PathVariable Integer id) {
        return todoService.getItem(id);
    }

    @PostMapping("/items")
    public List<Item> saveItems(@RequestBody List<Item> items) {
        return todoService.saveItems(items);
    }

    @DeleteMapping("/items")
    public void deleteItems(@RequestBody List<Integer> ids) {
        todoService.deleteItems(ids);
    }
}