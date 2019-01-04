package zw.co.deepkah.voucher.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zw.co.deepkah.voucher.document.Level;
import zw.co.deepkah.voucher.repository.LevelRepository;
import zw.co.deepkah.voucher.service.LevelService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LevelServiceImpl implements LevelService {
    private LevelRepository levelRepository;

    @Override
    public Optional<List<Level>> findAll() {
        return Optional.ofNullable(levelRepository.findAll());
    }

    @Override
    public Optional<Level> getOne(String Id) {
        return Optional.ofNullable(levelRepository.findById(Id).get());
    }

    @Override
    public void removeById(String Id) {
        levelRepository.deleteById(Id);
    }

    @Override
    public void remove(Level level) {
     levelRepository.delete(level);
    }

    @Override
    public Level save(Level level) {
        return levelRepository.save(level);
    }
}
