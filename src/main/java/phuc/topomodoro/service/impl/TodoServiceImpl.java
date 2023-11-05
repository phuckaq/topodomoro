package phuc.topomodoro.service.impl;

import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phuc.topomodoro.constant.Constant;
import phuc.topomodoro.entity.Item;
import phuc.topomodoro.exception.NoRecordExceptionHandler;
import phuc.topomodoro.repo.TodoRepo;
import phuc.topomodoro.service.TodoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    private TodoRepo todoRepo;

    @Override
    public List<Item> getItems() {
        return todoRepo.findAll();
    }

    @Override
    public Item getItem(Integer id) {
        Optional<Item> item = todoRepo.findById(id);
        return item.orElseThrow(() -> new NoRecordExceptionHandler(Constant.NOT_FOUND_EXP + id));
    }

    @Override
    public List<Item> saveItems(List<Item> items) {
        List<Item> savedItems = new ArrayList<>();
        for(Item item : items){
            Item itemToSave = item;
            if (item.getId() != null){
                Optional<Item> itemInDb = todoRepo.findById(item.getId());
                if(itemInDb.isPresent()){
                    itemToSave = itemInDb.get().toBuilder()
                            .title(item.getTitle())
                            .completed(item.getCompleted())
                            .updated(item.getUpdated())
                            .subItems(item.getSubItems())
                            .build();
                }
            }
            savedItems.add(todoRepo.save(itemToSave));
        }
        return savedItems;
    }

    @Override
    public void deleteItems(List<Integer> ids) {
       for(Integer id : ids){
           Optional<Item> itemInDb = todoRepo.findById(id);
           if (itemInDb.isPresent()){
               todoRepo.deleteById(id);
           }
           else {
               throw new NoRecordExceptionHandler(Constant.NOT_FOUND_EXP + id);
           }
       }
    }
}
