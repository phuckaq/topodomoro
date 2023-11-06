package phuc.topomodoro.service;

import phuc.topomodoro.entity.PomodoroConfig;

public interface PomodoroConfigService {
    PomodoroConfig getPomodoroConfig();
    PomodoroConfig savePomodoroConfig(PomodoroConfig pomodoroConfig);
}
