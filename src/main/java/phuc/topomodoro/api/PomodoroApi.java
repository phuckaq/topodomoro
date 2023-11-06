package phuc.topomodoro.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import phuc.topomodoro.entity.Pomodoro;
import phuc.topomodoro.service.PomodoroService;

@RestController
@RequestMapping("/api/pomo")
public class PomodoroApi {
    @Autowired
    private PomodoroService pomodoroService;

    @PostMapping
    public Pomodoro savePomodoro(@RequestBody Pomodoro pomodoro) {
        return pomodoroService.savePomodoro(pomodoro);
    }
}
