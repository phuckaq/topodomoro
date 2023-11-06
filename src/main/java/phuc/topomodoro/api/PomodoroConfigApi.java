package phuc.topomodoro.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import phuc.topomodoro.entity.PomodoroConfig;
import phuc.topomodoro.service.PomodoroConfigService;

@RestController
@RequestMapping("/api/pomo-config")
public class PomodoroConfigApi {

    @Autowired
    private PomodoroConfigService pomodoroConfigService;

    @GetMapping
    public PomodoroConfig getPomodoroConfig() {
        return pomodoroConfigService.getPomodoroConfig();
    }

    @PostMapping
    public PomodoroConfig savePomodoroConfig(@RequestBody PomodoroConfig pomodoroConfig) {
        return pomodoroConfigService.savePomodoroConfig(pomodoroConfig);
    }
}
