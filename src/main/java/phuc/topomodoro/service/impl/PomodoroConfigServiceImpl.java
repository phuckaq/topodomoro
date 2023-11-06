package phuc.topomodoro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phuc.topomodoro.constant.Constant;
import phuc.topomodoro.entity.PomodoroConfig;
import phuc.topomodoro.exception.NoRecordExceptionHandler;
import phuc.topomodoro.repo.PomodoroConfigRepo;
import phuc.topomodoro.service.PomodoroConfigService;

import java.util.Optional;

@Service
public class PomodoroConfigServiceImpl implements PomodoroConfigService {

    @Autowired
    private PomodoroConfigRepo pomodoroConfigRepo;

    @Override
    public PomodoroConfig getPomodoroConfig() {
        return pomodoroConfigRepo.findAll().get(0);
    }

    @Override
    public PomodoroConfig savePomodoroConfig(PomodoroConfig pomodoroConfig) {
        if (pomodoroConfig.getId() != null) {
            Optional<PomodoroConfig> pomodoroConfigInDb = pomodoroConfigRepo.findById(pomodoroConfig.getId());
            if (pomodoroConfigInDb.isPresent()) {
                pomodoroConfigInDb.get().setWorkDuration(pomodoroConfig.getWorkDuration());
                pomodoroConfigInDb.get().setBreakDuration(pomodoroConfig.getBreakDuration());
                return pomodoroConfigRepo.save(pomodoroConfigInDb.get());
            }
        }
        throw new NoRecordExceptionHandler(Constant.UNABLE_TO_SAVE);

    }
}
