package phuc.topomodoro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phuc.topomodoro.constant.Constant;
import phuc.topomodoro.entity.Item;
import phuc.topomodoro.entity.Pomodoro;
import phuc.topomodoro.exception.UnableSaveRecordExceptionHandler;
import phuc.topomodoro.repo.PomodoroRepo;
import phuc.topomodoro.service.PomodoroService;
import phuc.topomodoro.service.TodoService;

import java.util.List;
import java.util.Optional;

@Service
public class PomodoroServiceImpl implements PomodoroService {

    @Autowired
    private TodoService todoService;

    @Autowired
    private PomodoroRepo pomodoroRepo;

    @Override
    public Pomodoro savePomodoro(Pomodoro pomodoro) {
        Pomodoro savePomodoro = pomodoro;
        if (pomodoro.getId() != null){
            Optional<Pomodoro> pomodoroInDb = pomodoroRepo.findById(pomodoro.getId());
            if (pomodoroInDb.isPresent()){
                pomodoroInDb.get().setStartTime(pomodoro.getStartTime());
                pomodoroInDb.get().setEndTime(pomodoro.getEndTime());
                savePomodoro = pomodoroInDb.get();
            }
        }
        List<Item> itemPomos = todoService.saveItems(pomodoro.getItems());
        savePomodoro.setItems(itemPomos);
        return pomodoroRepo.save(savePomodoro);
    }
}
