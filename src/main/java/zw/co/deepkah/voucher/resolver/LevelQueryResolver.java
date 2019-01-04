package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.Level;
import zw.co.deepkah.voucher.service.LevelService;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class LevelQueryResolver implements GraphQLQueryResolver {
    private LevelService levelService;

    public List<Level> getLevelList(){
        return levelService.findAll().get();
    }

    public Level getLevelById(Optional<String> levelId){
        Level level = new Level();
        if(levelId.isPresent()){
             level = levelService.getOne(levelId.get()).get();
        }
        return level;
    }
}
